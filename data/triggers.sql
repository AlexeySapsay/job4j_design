
create or replace function discount()
    returns trigger as
$$
    BEGIN
        update products
        set price = price - price * 0.2
        where count <= 5 AND id = new.id;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';


create trigger discount_trigger
after insert
on products
for each row
execute procedure discount();

insert into products (name, producer, count, price) values ('product_3', 'producer_3', 8, 115);
insert into products (name, producer, count, price) values ('product_1', 'producer_1', 3, 50);

alter table products disable trigger discount_trigger;

drop trigger discount_trigger on products;

select * from products;


--1 Триггер должен срабатывать после вставки данных, для любого товара и просто насчитывать налог на товар.
-- Действовать он должен не на каждый ряд, а на запрос (statement уровень)


create or replace function tax()
    returns trigger as
$$
    BEGIN
        update products
        set price = price - price * 0.3
        where id = (select id from inserted) and count >=1;
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_trigger
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure tax();




--2 Триггер должен срабатывать до вставки данных и высчитывать налог на товар. Здесь используем row уровень.


create or replace function tax_before()
    returns trigger as
$$
    BEGIN
        update products
        set price = price - price * 0.13
        where count >=1 AND id = new.id;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';


create trigger tax_before_trigger
after insert
on products
for each row
execute procedure tax_before();


drop trigger tax_before_trigger on products;


create table history_of_price (
    id serial primary key,
    name varchar(50),
    price integer,
    date timestamp
);


--3 Нужно написать триггер на row уровне, который при вставке продукта в таблицу products,
-- будет заносить имя, цену и текущую дату в таблицу history_of_price.

update history_of_price
set name = 'product_111', price = 11, date = '2222-07-25 10:30:30'
WHERE price!=0;


create or replace function copying()
    returns trigger as
$$
    BEGIN
        insert into history_of_price(name, price, date)
            VALUES (new.name, new.price, CURRENT_DATE);
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';


create trigger copy_trigger_to_history_of_price
    after insert
    on products
    for each row
    execute procedure copying();

alter table products disable trigger discount_trigger;

drop trigger copy_trigger_to_history_of_price on products;

select * from products;

SELECT * FROM history_of_price;

insert into products (name, producer, count, price) values ('product_3', 'producer_3', 8, 115);
insert into products (name, producer, count, price) values ('product_1333', 'producer_1', 1111, 51341);


insert into history_of_price (name, price, date) values ('product_1', 11,  '2018-07-25 10:30:30' );

update history_of_price
set name = 'product_111', price = 11, date = '2222-07-25 10:30:30'
WHERE price!=0;