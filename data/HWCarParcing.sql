CREATE TABLE box(
	id serial primary key,
	model varchar(255)
);

CREATE TABLE engine(
	id serial primary key,
	model varchar(255)
);

CREATE TABLE transmission(
	id serial primary key,
	model varchar(255)
);


CREATE TABLE Car(
	id serial primary key,
	name varchar(255),
	box_id int references box (id),
	engine_id int references engine(id),
	transmission_id int references transmission (id)
);

insert into box(model) values ('model_box 1');
insert into box(model) values ('model_box 2');
insert into box(model) values ('model_box 3');
insert into box(model) values ('model_box 4');
insert into box(model) values ('model_box 5');

insert into engine(model) values ('model_engine 1');
insert into engine(model) values ('model_engine 2');
insert into engine(model) values ('model_engine 3');

insert into transmission(model) values ('model_transmission 1');
insert into transmission(model) values ('model_transmission 2');

insert into car (name, box_id, engine_id, transmission_id)
values ('CAR_MODEL 1', 2, 2, 1);
insert into car (name, box_id, engine_id, transmission_id)
values ('CAR_MODEL 2', 2, 1, 1);
insert into car (name, box_id, engine_id, transmission_id)
values ('CAR_MODEL 3', 1, 2, 1);

SELECT * FROM car;

--1) Вывести список всех машин и все привязанные к ним детали.
SELECT c.name, b.model, e.model, t.model 
FROM car as c
	JOIN box as b 
	ON c.box_id = b.id 
	JOIN engine as e
	ON c.engine_id = e.id
	JOIN transmission as t
	ON c.transmission_id = t.id;
	
	
--2) Вывести отдельно детали (1 деталь - 1 запрос),
--которые не используются НИ в одной машине, кузова, двигатели, 
--коробки передач.

SELECT b.model as "non use box"
FROM car as c RIGHT JOIN box as b
ON c.box_id = b.id
WHERE c.id IS null;

SELECT e.model as "non use engine"
FROM car as c RIGHT JOIN box as e
ON c.engine_id = e.id
WHERE c.id IS null;

SELECT t.model as "non use transmission"
FROM transmission  as t LEFT JOIN car as c
ON t.id = c.transmission_id  
WHERE c.id IS null;







