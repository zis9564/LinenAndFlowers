CREATE or REPLACE FUNCTION set_first_status(bigint) RETURNS VOID AS $$
BEGIN
    UPDATE public.orders SET order_status_id = public.order_statuses.id
    FROM public.order_statuses
    WHERE status = 'QUEUE' AND public.orders.id = $1;
END
$$ LANGUAGE plpgsql;

CREATE or REPLACE FUNCTION first_status_function() RETURNS TRIGGER AS $$
BEGIN
    IF (new.order_status_id IS NULL OR new.order_status_id != 1) THEN
        PERFORM set_first_status(new.id);
        RETURN new;
    ELSE
        RETURN old;
    END IF;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER set_new_order_status
    AFTER INSERT
    ON orders
    FOR EACH ROW
EXECUTE PROCEDURE first_status_function();