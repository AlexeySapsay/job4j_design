CREATE TABLE roles(
	id serial primary key,
	name varchar(255)
);

CREATE TABLE category(
	id serial primary key,
	name varchar(255)
);

CREATE TABLE state(
	id serial primary key,
	name varchar(255)
);

CREATE TABLE users(
	id serial primary key,
	name varchar(255),
	id_roles int references roles(id)
);


CREATE TABLE rules(
	id serial primary key,
	name varchar(255)
);

CREATE TABLE items(
	id serial primary key,
	name varchar(255),
	id_category int references category(id),
	id_state int references state(id),
	users_id int references users(id)
);

CREATE TABLE comments(
	id serial primary key,
	text varchar(600),
	id_items int references items(id),
	id_users int references users(id)
);

CREATE TABLE attachs(
	id serial primary key,
	name varchar(255),
	id_items int references items(id),
	id_users int references users(id)
);

CREATE TABLE roles_rules(
	id serial primary key,
	id_roles int references roles(id),
	id_rules int references rules(id)
);
