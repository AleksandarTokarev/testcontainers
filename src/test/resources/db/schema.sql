create table users
(
    id serial not null
        constraint users_pk
            primary key,
    name text
);

INSERT INTO users(name) values ('U1');
INSERT INTO users(name) values ('U2');
INSERT INTO users(name) values ('U3');
INSERT INTO users(name) values ('U4');

