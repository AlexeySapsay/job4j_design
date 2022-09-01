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

-- делаем в psql в окне транзакции1 и транзакции2
--begin transaction isolation level serializable;

--2. Выполняем следующую последовательность операций:
--
--- в первой транзакции находим сумму столбца count;
--
--select sum(count) from products;
--- далее обновляем одну из записей:
--
--update products set count = 26 where name = 'product_1';
--- потом переходим во вторую транзакцию и выполняем запрос на нахождение суммы столбца count;
--
--select sum(count) from products;
--- также обновляем одну из записей:
--
--update products set count = 26 where name = 'product_2';
--- фиксируем изменения во второй транзакции;
--
--- фиксируем изменения в первой транзакции.