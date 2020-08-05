create table todos (
    id bigserial not null,
    task_name varchar(255),
    completed boolean,
    primary key(id)
);