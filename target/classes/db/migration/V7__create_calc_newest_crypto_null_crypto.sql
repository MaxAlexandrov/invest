create function calc_newest_crypto(date_begin timestamp without time zone, date_end timestamp without time zone)
    returns TABLE(date date, crypto character varying, price real)
    language plpgsql
as
$$
declare
begin

    return query
        select
            cast(t.date as date),
            t.name,
            t.price
        from coins t
        where (t.date_time between date_begin and date_end)
        order by t.date_time DESC LIMIT 1;

end
$$;

alter function calc_newest_crypto(timestamp, timestamp) owner to postgres;

