CREATE or REPLACE FUNCTION status_function(bigint) RETURNS VOID AS $$
BEGIN
    UPDATE public.orders SET order_status_id = public.order_statuses.id
    FROM public.order_statuses
    WHERE status = 'IN_DELIVERY' AND public.orders.id = $1;
END
$$ LANGUAGE plpgsql;

CREATE or REPLACE FUNCTION status_update() RETURNS TRIGGER AS $$
BEGIN
    IF (new.tracking_code NOTNULL AND old.tracking_code IS NULL) THEN
        PERFORM status_function(old.id);
        RETURN new;
    ELSE
        RETURN null;
    END IF;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER change_status_to_in_delivery
    AFTER UPDATE
    OF tracking_code
    ON orders
    FOR EACH ROW
EXECUTE PROCEDURE status_update();