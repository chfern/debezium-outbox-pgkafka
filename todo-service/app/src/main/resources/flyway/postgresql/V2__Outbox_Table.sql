create table outbox (
    id uuid not null,
    payload varchar(max) not null,
    primary key(id)
);