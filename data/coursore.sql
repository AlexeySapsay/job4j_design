--создаем таблицу, если не существует
create table products (
    id serial primary key,
    name varchar(50),
    count integer default 0,
    price integer
);

-- или почистим существующую таблицу перед работой
select * from products;
delete from products;
drop table products;

--И заполним эту таблицу следующими данными:
insert into products (name, count, price) VALUES ('product_1', 1, 5);
insert into products (name, count, price) VALUES ('product_2', 2, 10);
insert into products (name, count, price) VALUES ('product_3', 3, 15);
insert into products (name, count, price) VALUES ('product_4', 4, 20);
insert into products (name, count, price) VALUES ('product_5', 5, 25);
insert into products (name, count, price) VALUES ('product_6', 6, 30);
insert into products (name, count, price) VALUES ('product_7', 7, 35);
insert into products (name, count, price) VALUES ('product_8', 8, 40);
insert into products (name, count, price) VALUES ('product_9', 9, 45);
insert into products (name, count, price) VALUES ('product_10', 10, 50);
insert into products (name, count, price) VALUES ('product_11', 11, 55);
insert into products (name, count, price) VALUES ('product_12', 12, 60);
insert into products (name, count, price) VALUES ('product_13', 13, 65);
insert into products (name, count, price) VALUES ('product_14', 14, 70);
insert into products (name, count, price) VALUES ('product_15', 15, 75);
insert into products (name, count, price) VALUES ('product_16', 16, 80);
insert into products (name, count, price) VALUES ('product_17', 17, 85);
insert into products (name, count, price) VALUES ('product_18', 18, 90);
insert into products (name, count, price) VALUES ('product_19', 19, 95);
insert into products (name, count, price) VALUES ('product_20', 20, 100);

--После этого мы можем запустить транзакцию, объявить наш курсор:
BEGIN;
DECLARE
    cursor_products cursor for
                        select * from products;

--А теперь получаем данные – например выгрузим 10 строк, вместо 20:
FETCH 10 FROM cursor_products;

--Вывод будет следующим:
--1	"product_1"	1	5
--2	"product_2"	2	10
--3	"product_3"	3	15
--4	"product_4"	4	20
--5	"product_5"	5	25
--6	"product_6"	6	30
--7	"product_7"	7	35
--8	"product_8"	8	40
--9	"product_9"	9	45
--10 "product_10" 10	50

--Сейчас наш курсор находится на позиции 10, давайте прочитаем еще несколько строк с направлением NEXT:
FETCH FROM cursor_products;
FETCH FROM cursor_products;
--Соответственно эти запросы вернут нам, соответственно, 11 и 12 строки.

--Применим эту команду и переместим курсор на 2 строки вперед:
MOVE FORWARD 2 FROM cursor_products;

--Применим эту команду и переместим курсор на 3 строки назад:
MOVE BACKWARD 2 FROM cursor_products;

--Теперь прочитаем следующую строку с помощью FETCH:
FETCH NEXT FROM cursor_products;
--Сейчас наш курсор находится на позиции 15, давайте прочитаем еще несколько строк с направлением NEXT:
--15	"product_15"	15	75


--Закрытие курсора – простой, но важный процесс. Все что необходимо выполнить при этом,
--это использовать ключевое слово CLOSE в сочетании с именем курсора. Синтаксис представлен ниже:
CLOSE cursor_products;

--И последним этапом не забываем корректно завершить нашу транзакцию:
COMMIT;


--------------------------------------------------------------------------------------
---------------------------------HOME WORK--------------------------------------------
--------------------------------------------------------------------------------------
--В описании мы использовали прямой проход в курсоре. Соответственно, Вашим заданием будет
--организовать обратный проход в курсоре (от 20 до 1 записи). Используйте в своем курсоре опцию
--SCROLL, двигайтесь по курсору с помощью MOVE, данные получайте с помощью FETCH.
--Последовательность команд определяйте произвольно.

-- Таблица с данным существует, берем ее из задания выше. Поэтому данными не заполняем

--Ниже представлен пример, как объявлять курсоры:
--DECLARE
--    [cursor_name] [[NO] SCROLL] CURSOR FOR [query];

BEGIN;
DECLARE
    cursor_products SCROLL cursor for
                        select * from products;

--смещаем курсор на 20 позиций в перед
MOVE FORWARD 21 FROM cursor_products;

--Синтаксис выглядит следующим образом:
--FETCH [FORWARD | BACKWARD]
--    [direction (rows)]
--    FROM [cursor_name];
--смещаем курсор на 20 позиций в перед
FETCH BACKWARD 21  FROM cursor_products;

--возьмем предыдущий элемент
FETCH PRIOR  FROM cursor_products;


--Закрытие курсора – простой, но важный процесс. Все что необходимо выполнить при этом,
--это использовать ключевое слово CLOSE в сочетании с именем курсора. Синтаксис представлен ниже:
CLOSE cursor_products;

--И последним этапом не забываем корректно завершить нашу транзакцию:
COMMIT;
