CREATE TABLE employees(
	ID serial PRIMARY KEY,
	NAME varchar(255),
	SALARY integer,
	GENDER boolean);

INSERT INTO employees(NAME, SALARY, GENDER) values('Alex',100500,TRUE);

UPDATE employees SET SALARY = 300000;

DELETE FROM employees;

SELECT * FROM employees;
