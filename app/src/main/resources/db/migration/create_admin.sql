create table admin(
id serial not null primary key,
first_name text not null,
last_name text not null,
email text not null,
password text not null
);