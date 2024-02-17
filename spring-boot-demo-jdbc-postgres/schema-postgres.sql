create table user_entity (
    id integer GENERATED ALWAYS AS IDENTITY,
    first_name varchar(255),
    last_name  varchar(255),
    primary key (id)
);

insert into user_entity (first_name,last_name) VALUES ('Homer','Simpson');
insert into user_entity (first_name,last_name) values ('Bart','Simpson');
insert into user_entity (first_name,last_name) values ('Lisa','Simpson');