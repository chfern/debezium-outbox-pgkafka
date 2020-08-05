create table users (
    id bigserial not null,
    created_at timestamptz not null default now(),
    updated_at timestamptz,
    deleted_at timestamptz,
    birth_date timestamptz not null,
    username varchar(20) not null,
    full_name varchar(50) not null,
    email varchar(255) not null,
    gender varchar(6) not null,

    primary key(id)
);

create unique index on users(email) where deleted_at is null;
create unique index on users(username) where deleted_at is null;