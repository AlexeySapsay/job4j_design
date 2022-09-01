
--создаем процедуру вставки данных
create or replace procedure insert_data(i_name varchar, prod varchar, i_count integer, i_price integer)
language 'plpgsql'
as $$
    BEGIN
    insert into products (name, producer, count, price)
    values (i_name, prod, i_count, i_price);
    END
$$;

--вызываем процедуру вставки данных
call insert_data('product_2', 'producer_2', 15, 32);

--создаем процедуру обновления данных
create or replace procedure update_data(u_count integer, tax float, u_id integer)
language 'plpgsql'
as $$
    BEGIN
        if u_count > 0 THEN
            update products set count = count - u_count where id = u_id;
        end if;
        if tax > 0 THEN
            update products set price = price + price * tax;
        end if;
    END;
$$;

-- проверяем корректность заполнения таблицы
select * from products;

call update_data(10, 0, 2);

call insert_data('product_1', 'producer_1', 3, 50);
call insert_data('product_3', 'producer_3', 8, 115);

call update_data(0, 0.2, 0);

alter procedure update_data(u_count integer, tax float, u_id integer) rename to update;

drop procedure update_data(u_count integer, tax float, u_id integer);


-- подготавливаем пустую таблицу для вставки данных
delete from products;
alter SEQUENCE products_id_seq RESTART with 1;




create or replace function f_insert_data(i_name varchar, prod varchar, i_count integer, i_price integer)
returns void
language 'plpgsql'
as
$$
    begin
        insert into products (name, producer, count, price)
        values (i_name, prod, i_count, i_price);
    end;
$$;


select f_insert_data('product_1', 'producer_1', 25, 50);



create or replace function f_update_data(u_count integer, tax float, u_id integer)
returns integer
language 'plpgsql'
as
$$
    declare
        result integer;
    begin
        if u_count > 0 THEN
            update products set count = count - u_count where id = u_id;
            select into result count from products where id = u_id;
        end if;
        if tax > 0 THEN
            update products set price = price + price * tax;
            select into result sum(price) from products;
        end if;
        return result;
    end;
$$;


select f_update_data(10, 0, 1);
select f_update_data(6, 0, 2);
select f_update_data(9, 0, 3);
select f_update_data(0, 0.2, 0);

select f_insert_data('product_2', 'producer_2', 15, 32);
select f_insert_data('product_3', 'producer_3', 8, 115);


--За основу возьмите таблицу, с которой мы работали в описании. В описании мы рассмотрели вариант вставки
--данных, изменения данных. Добавьте процедуру и функцию, которая будет удалять записи.
--Условия выбирайте сами – удаление по id, удалить если количество товара равно 0 и т.п.


-- создаю процедуру удаления данных по имени и количеству
create or replace procedure delete_data_procedure(n_name varchar)
language 'plpgsql'
as $$
    BEGIN
        delete from products
        where name = n_name and count> 10;
    END;
$$;

select * from products;
-- перед вызовом процедуры
--5	product_2	producer_2	15	38
--6	product_3	producer_3	8	138
--7	product_2	producer_2	15	38
--8	product_3	producer_3	8	138

-- вызываю процедуру удаления данных по имени
call delete_data_procedure('product_2');

-- таблица products после вызова
--6	product_3	producer_3	8	138
--8	product_3	producer_3	8	138


-- создаю хранимую функцию для удаления данных
create or replace function func_delete_data(c_name varchar)
returns void
language 'plpgsql'
as
$$
declare results integer;
    begin
        delete from products where name = c_name;
        return ;
    end;
$$;

-- в случае обновления функции ее нужно удалить, а потом обновить
-- проинициклизировать запуском плай
DROP FUNCTION func_delete_data(c_name varchar);

select func_delete_data('product_1');
select * from products;

-- after call func_delete_data remove 'product_1'
--5	product_2	producer_2	15	38
--6	product_3	producer_3	8	138
--7	product_2	producer_2	15	38
--8	product_3	producer_3	8	138





call delete_data_procedure(10, 0, 2);

call insert_data('product_1', 'producer_1', 3, 50);
call insert_data('product_3', 'producer_3', 8, 115);

call update_data(0, 0.2, 0);