create function calc_range_crypto(date_begin timestamp without time zone, date_end timestamp without time zone)
    returns TABLE(year integer, month integer, crypto character varying, range_price real, max_price real, min_price real)
    language plpgsql
as
$$
declare
begin
    return query
        select
            CAST(EXTRACT(YEAR FROM t.date) AS int)  as year,
            CAST(EXTRACT(MONTH FROM t.date) AS int) as month,
            t.name                                       as crypto,
            (max(t.price) - min(t.price)) / min(t.price) as range_price,
            max(t.price)                                 as max_price,
            min(t.price)                                 as min_price
        from coins t
        where t.date between date_begin and date_end
        group by month, year, crypto
        order by crypto, year, month
    ;

end
$$;

alter function calc_range_crypto(timestamp, timestamp) owner to postgres;

