create table outbox (
    id uuid not null,
    payload jsonb not null,
    primary key(id)
);