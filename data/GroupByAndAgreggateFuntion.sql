--1. Дана структура
create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

--2. Заполнить таблицы данными.
INSERT INTO devices(name, price) values('PC1', 50000);
INSERT INTO devices(name, price) values('PC2', 150000);
INSERT INTO devices(name, price) values('Laptop1', 60000);
INSERT INTO devices(name, price) values('Laptop2', 100000);
INSERT INTO devices(name, price) values('Smartfon',30000);
INSERT INTO devices(name, price) values('MiBand', 3000);
INSERT INTO devices(name, price) values('RobotCliner1', 15000);
INSERT INTO devices(name, price) values('RobotCliner2', 5000);

INSERT INTO people(name) values('Аня'), ('Ваня'), ('Боря');

Select * FROM devices;
Select * FROM people;
Select * FROM devices_people;

INSERT INTO devices_people(device_id, people_id) values(1, 2), (1,2);
INSERT INTO devices_people(device_id, people_id) values(3, 2), (1,1);
INSERT INTO devices_people(device_id, people_id) values(4, 2), (2,2);
INSERT INTO devices_people(device_id, people_id) values(3, 2), (4,3);
INSERT INTO devices_people(device_id, people_id) values(5, 2), (4,3);
INSERT INTO devices_people(device_id, people_id) values(6, 2), (4,3);
INSERT INTO devices_people(device_id, people_id) values(7, 2), (4,3);
INSERT INTO devices_people(device_id, people_id) values(8, 2), (4,3);

--3. Используя агрегатные функции вывести среднюю, мин и макс цену устройств.
SELECT avg(devices.price) FROM devices_people join devices on device_id = devices.id;
SELECT min(devices.price) FROM devices_people join devices on device_id = devices.id;
SELECT max(devices.price) FROM devices_people join devices on device_id = devices.id;

SELECT * FROM devices_people join devices on device_id = devices.id;

--4. Используя группировку вывести для каждого человека среднюю цену его устройств.
SELECT dp.people_id, avg(devices.price) FROM devices_people as dp join devices on dp.device_id = devices.id
group by dp.people_id;

--5. Дополнить запрос п.4. условием, что средняя стоимость устройств должна быть больше 5000.
SELECT dp.people_id, avg(devices.price) FROM devices_people as dp join devices on dp.device_id = devices.id
group by dp.people_id
having avg(devices.price)>5000;