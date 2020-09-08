CREATE or REPLACE FUNCTION default_status() RETURNS TRIGGER AS $$
BEGIN
    public.orders SET order_status_id = public.order_statuses.id
    FROM public.order_statuses
    WHERE status = 'IN_DELIVERY' AND public.orders.id = _id;
END;
$$ LANGUAGE plpgsql;

CREATE or REPLACE FUNCTION set_default_status() RETURNS TRIGGER AS $$
BEGIN
    IF (old.tracking_code != new.tracking_code) THEN
        PERFORM default_status(old.id);
        RETURN new;
    ELSE
        RETURN old;
    END IF;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER create_order
    AFTER INSERT
    ON orders
    FOR EACH ROW
EXECUTE PROCEDURE set_default_status();