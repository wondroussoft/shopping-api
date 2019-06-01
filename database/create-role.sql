DO
$body$
BEGIN
    IF NOT EXISTS(
            SELECT *
            FROM pg_catalog.pg_user
            WHERE usename = 'customer')
    THEN
        CREATE ROLE customer WITH PASSWORD 'Aa123456';
    END IF;
END
$body$;

ALTER ROLE customer NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION LOGIN;
