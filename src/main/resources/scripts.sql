create table author
(
    id         serial
        constraint author_pk
            primary key,
    name       varchar,
    surname    varchar,
    patronymic varchar
);
create table book
(
    id          serial
        constraint book_pk
            primary key,
    name        varchar,
    isbn        varchar,
    date_add    varchar,
    date_remove varchar,
    category_id bigint,
    author_id   integer
);
create table book_to_hand
(
    id             serial
        constraint book_to_hand_pk
            primary key,
    date_of_issue  varchar,
    date_of_return integer,
    user_id        bigint,
    book_id        bigint
);
create table category
(
    id   serial
        constraint category_pk
            primary key,
    name varchar
);
create table employee
(
    id         serial
        constraint employee_pk
            primary key,
    name       varchar,
    surname    varchar,
    patronymic varchar,
    login      varchar,
    password   varchar
);
create table person
(
    id         serial
        constraint person_pk
            primary key,
    name       varchar,
    surname    varchar,
    patronymic varchar,
    login      varchar,
    password   varchar
);