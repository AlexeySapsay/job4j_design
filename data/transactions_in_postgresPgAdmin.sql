--создаем таблицу, если не существует
create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

-- или почистим существующую таблицу перед работой
select * from products;
delete from products;

--Добавим в эту таблицу некоторые данные:
insert into products (name, producer, count, price) values ('product_1', 'producer_1', 3, 50);
insert into products (name, producer, count, price) values ('product_2', 'producer_2', 15, 32);
insert into products (name, producer, count, price) values ('product_3', 'producer_3', 8, 115);

--Теперь запустим транзакцию:
begin transaction;

--выполним вставку еще одной записи в таблицу:
insert into products (name, producer, count, price) VALUES ('product_4', 'producer_4', 11, 64);

--зафиксируем изменения в нашей транзакции:
commit transaction;

--и выполним проверку состояния нашей таблицы после транзакции:
select * from products;

-- результат селекта. Как видим, все работает хорошо и правильно
--20	product_1	producer_1	3	50
--21	product_2	producer_2	15	32
--22	product_3	producer_3	8	115
--23	product_4	producer_4	11	64

--Начнем новую транзакцию:
begin transaction;

--выполним удаление всех записей из таблицы:
delete from products;

--после удалим таблицу из БД:
drop table products;

--и выполним откат изменений с помощью ROLLBACK:
rollback transaction;

--после чего выполним выборку данных из таблицы products:
select * from products;
-- rollback отрабатывает не верно, возвращается только пустая таблица
-- без данных. Попробовал разными способами, но результат тот же.

--Запустим еще одну транзакцию:
begin transaction;

--вставим еще одну запись в нашу таблицу:
insert into products (name, producer, count, price) VALUES ('product_5', 'producer_5', 17, 45);

--т.к таблица не востановлена, добавлю данные ручками
insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 50);
insert into products (name, producer, count, price) VALUES ('product_2', 'producer_2', 15, 32);
insert into products (name, producer, count, price) VALUES ('product_3', 'producer_3', 8, 115);

--добавим точку сохранения в нашу транзакцию:
savepoint first_savepoint;

--далее выполним в транзакции несколько команд – UPDATE, DELETE:
delete from products where price = 115;
update products set price = 75 where name = 'product_1';

--после этого мы выполним выборку всех записей из таблицы products:
select * from products;

--2	"product_2"	"producer_2"	15	32
--4	"product_4"	"producer_4"	11	64
--5	"product_5"	"producer_5"	17	45
--1	"product_1"	"producer_1"	3	75

--выполним ROLLBACK до точки сохранения, которую мы добавили ранее:
rollback to first_savepoint;
-- в ИДЕА не находит точку сохранения, возможно в PgAdmin это заработает

--повторно выполним выборку всех данных из таблицы products:
select * from products;

--после этого зафиксируем все изменения, которые были внесены в нашей
--транзакции с учетом отката изменений до точки сохранения:
commit transaction;

--------------------------------------------------------------------
--Домашная работа!
--------------------------------------------------------------------
--повторно выполним выборку всех данных из таблицы products:
select * from products;
--1	"product_1"	"producer_1"	3	50
--2	"product_2"	"producer_2"	15	32
--3	"product_3"	"producer_3"	8	115
--4	"product_4"	"producer_4"	11	64
--5	"product_5"	"producer_5"	17	45

--2. По аналогии с описанием выполните транзакцию с несколькими точками сохранения.
--Поэкспериментируйте с откатом изменений к разным точкам сохранения.
--В комментарий приложите скриншот консольного вывода выполнения Ваших команд.

--Запустим еще одну транзакцию:
begin transaction;

--вставим еще одну запись в нашу таблицу:
insert into products (name, producer, count, price) VALUES ('product_10', 'producer_7', 111, 500);

--добавим точку сохранения в нашу транзакцию:
savepoint first_savepoint;

--далее выполним в транзакции несколько команд – UPDATE, DELETE:
delete from products where price = 500;


--после этого мы выполним выборку всех записей из таблицы products:
select * from products;
--7	"product_1"	"producer_1"	3	50
--8	"product_2"	"producer_2"	15	32
--9	"product_3"	"producer_3"	8	115
--10 "product_4" "producer_4"	11	64

--выполним ROLLBACK до точки сохранения, которую мы добавили ранее:
rollback to first_savepoint;
-- в ИДЕА не находит точку сохранения, в PgAdmin это заработает
--повторно выполним выборку всех данных из таблицы products:
select * from products;
--1	"product_1"	"producer_1"	3	50
--2	"product_2"	"producer_2"	15	32
--3	"product_3"	"producer_3"	8	115
--4	"product_4"	"producer_4"	11	64
--5	"product_10"	"producer_7"	111	500

--добавим точку сохранения в нашу транзакцию:
savepoint second_savepoint;

--далее выполним в транзакции несколько команд – UPDATE, DELETE:
delete from products where price = 500;

--выполним ROLLBACK до точки сохранения, которую мы добавили ранее:
rollback to second_savepoint;
-- в ИДЕА не находит точку сохранения, в PgAdmin это заработает

--повторно выполним выборку всех данных из таблицы products:
select * from products;

--1	"product_1"	"producer_1"	3	50
--2	"product_2"	"producer_2"	15	32
--3	"product_3"	"producer_3"	8	115
--4	"product_4"	"producer_4"	11	64
--5	"product_10"	"producer_7"	111	500

--после этого зафиксируем все изменения, которые были внесены в нашей
--транзакции с учетом отката изменений до точки сохранения:
commit transaction;
