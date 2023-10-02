CREATE TABLE IF NOT EXISTS coins
(
    date  timestamp,
    name  varchar,
    price float4,
    PRIMARY KEY (date, name)
);