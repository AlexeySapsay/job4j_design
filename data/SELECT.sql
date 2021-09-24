create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

INSERT into fauna(name,avg_age,discovery_date) VALUES('fish',10,null);
INSERT into fauna(name,avg_age,discovery_date) VALUES('Fish',10,null);
INSERT into fauna(name,avg_age,discovery_date) VALUES('animal1',1000, date '2020-09-01');
INSERT into fauna(name,avg_age,discovery_date) VALUES('animal2',2,date '2017-09-04');

SELECT name FROM fauna
WHERE name LIKE '%fish%';

SELECT * FROM fauna
WHERE avg_age BETWEEN 10000 and 21000;

SELECT * FROM fauna
WHERE discovery_date IS NULL;

SELECT * FROM fauna
WHERE discovery_date < date '1950-01-01';