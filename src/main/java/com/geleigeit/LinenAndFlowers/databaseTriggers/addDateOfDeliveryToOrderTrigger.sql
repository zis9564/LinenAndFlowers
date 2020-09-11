CREATE or REPLACE FUNCTION to_delivered_status_function(bigint) RETURNS VOID AS $$
BEGIN
    UPDATE public.orders SET order_status_id = public.order_statuses.id
    FROM public.order_statuses
    WHERE status = 'DELIVERED' AND public.orders.id = $1;
END
$$ LANGUAGE plpgsql;

CREATE or REPLACE FUNCTION to_delivered_status_update() RETURNS TRIGGER AS $$
BEGIN
    IF (new.arrival_date NOTNULL AND old.arrival_date IS NULL) THEN
        PERFORM to_delivered_status_function(old.id);
        RETURN new;
    ELSE
        RETURN null;
    END IF;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER change_status_to_delivered
    AFTER UPDATE
        OF arrival_date
    ON orders
    FOR EACH ROW
EXECUTE PROCEDURE to_delivered_status_update();