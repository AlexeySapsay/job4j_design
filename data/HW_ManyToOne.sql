--https://job4j.ru/profile/exercise/51/task-view/336
-- Many-to-one

create table adress(
    id serial primary key,
	roomNumber int
);

create table rommers(
    id serial primary key,
	firstName varchar(255),
	adress_id int references adress(id)
);

insert into rommers(firstName) values ('Alex');
insert into rommers(firstName) values ('Ivan');
insert into rommers(firstName) values ('Kolia');
insert into rommers(firstName) values ('Masha');

insert into adress(roomNumber) values (1);
insert into adress(roomNumber) values (2);
insert into adress(roomNumber) values (2);
insert into adress(roomNumber) values (1);

SELECT * from rommers;
SELECT * from adress;
SELECT * FROM adress where id IN(SELECT id from rommers);



