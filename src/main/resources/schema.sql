create table if not exists customers (
    id uuid primary key,
    name varchar not null,
    email varchar not null unique
);