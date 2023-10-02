CREATE TABLE IF NOT EXISTS file_metadata
(
    hash                varchar PRIMARY KEY,
    file_name           varchar,
    processed_timestamp timestamp,
    creation_date       timestamp,
    last_modified       timestamp,
    size                bigint
);