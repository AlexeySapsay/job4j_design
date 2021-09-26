--Даны две сущности, представленные в таблицах departments и emploers. 
--Отношение one-to-many. В таблицах только поле name.

--1. Создать таблицы и заполнить их начальными данными
create table departments (
    id serial primary key,
    name varchar(255)
);

create table emploers(
    id serial primary key,
    name varchar(255),
    departments_id int references departments(id)
);


INSERT INTO departments(name) values ('department 1');
INSERT INTO departments(name) values ('department 2');
INSERT INTO departments(name) values ('department 3');
INSERT INTO departments(name) values ('department 4');
INSERT INTO departments(name) values ('department 5');

INSERT INTO emploers(name,departments_id) values ('employer 1',3);
INSERT INTO emploers(name,departments_id) values ('employer 2',4);
INSERT INTO emploers(name,departments_id) values ('employer 3',4);
INSERT INTO emploers(name,departments_id) values ('employer 4',null);

SELECT * FROM departments;
SELECT * FROM emploers;

--2. Выполнить запросы с left, rigth, full, cross соединениями
SELECT * 
FROM emploers e LEFT JOIN departments d 
ON e.departments_id= d.id;

SELECT * 
FROM emploers e RIGHT JOIN departments d 
ON e.departments_id= d.id;

SELECT * 
FROM emploers e FULL JOIN departments d 
ON e.departments_id= d.id;

--3. Используя left join найти департаменты, у которых нет работников
SELECT * 
FROM departments d  LEFT JOIN emploers e  
ON e.departments_id= d.id
WHERE e.departments_id IS NULL;

--4. Используя left и right join написать запросы,
--которые давали бы одинаковый результат. 
SELECT * 
FROM departments d  LEFT JOIN emploers e  
ON e.departments_id= d.id;

SELECT * 
FROM  emploers e  RIGHT JOIN  departments d
ON e.departments_id= d.id;

--5. Создать таблицу teens с атрибутами name, gender и заполнить ее.
--Используя cross join составить все возможные разнополые пары

CREATE TABLE teens (
 	id serial primary key,
	name varchar(255),
	gender boolean
);

INSERT INTO teens(name,gender) values ('Name 1',true);
INSERT INTO teens(name,gender) values ('Name 2',true);
INSERT INTO teens(name,gender) values ('Name 3',false);
INSERT INTO teens(name,gender) values ('Name 4',true);
INSERT INTO teens(name,gender) values ('Name 5',false);

SELECT * FROM teens;

SELECT t1.name as tableOne, t2.name as tableTwo
FROM teens t1 CROSS JOIN teens t2
WHERE t1.gender != t2.gender;

SELECT * 
FROM  teens  CROSS JOIN  teens ;