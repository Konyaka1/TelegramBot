drop schema public cascade;

create schema public;

create sequence hibernate_sequence;

alter sequence hibernate_sequence owner to postgres;

create table "CITY"
(
    "ID"          serial  not null
        constraint """CITY""_pk"
            primary key,
    "NAME"        varchar not null,
    "INFORMATION" varchar default 'no info provided'::character varying
);

alter table "CITY"
    owner to postgres;

create unique index city_name_uindex
    on "CITY" ("NAME");

