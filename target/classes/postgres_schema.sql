CREATE TABLE IF NOT EXISTS coins
(
    date  timestamp,
    name  varchar,
    price float4,
    PRIMARY KEY (date, name)
);

CREATE TABLE IF NOT EXISTS file_metadata
(
    hash                varchar PRIMARY KEY,
    file_name           varchar,
    processed_timestamp timestamp,
    creation_date       timestamp,
    last_modified       timestamp,
    size                bigint
);


-- routs


------
