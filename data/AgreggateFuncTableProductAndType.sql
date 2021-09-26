--1. Дана структура
create table product(
    id serial primary key,
    name varchar(255),
	type_id integer,
	expired_date timestamp,
    price float
);

create table type(
    id serial primary key,
    name varchar(255)
);

--2. Заполнить таблицы данными.
insert into product (name, type_id, expired_date, price)
	values ('Не Российский', 1, current_date + 10, 500);
insert into product (name, type_id, expired_date, price)
	values ('Пармезан', 1, current_date + 15, 1500);
insert into product (name, type_id, expired_date, price)
	values ('Моцарела', 1, current_date + 5, 800);
insert into product (name, type_id, expired_date, price)
	values ('Итальянский', 1, '2021.06.18', 750);
insert into product (name, type_id, expired_date, price)
	values ('Зеленый слоник', 2, current_date + 4, 50);
insert into product (name, type_id, expired_date, price)
	values ('Гномик в деревне', 2, current_date + 8, 65);
insert into product (name, type_id, expired_date, price)
	values ('Козье', 2, current_date + 3, 80);
insert into product (name, type_id, expired_date, price)
	values ('Пшеничный', 3, current_date + 3, 45);
insert into product (name, type_id, expired_date, price)
	values ('Бородинский', 3, current_date + 5, 65);
insert into product (name, type_id, expired_date, price)
	values ('Ржаной', 3, current_date + 5, 35);
insert into product (name, type_id, expired_date, price)
	values ('Цельнозерновой', 3, current_date + 6, 75);
insert into product (name, type_id, expired_date, price)
	values ('Молочная', 4, current_date + 12, 350);
insert into product (name, type_id, expired_date, price)
	values ('Докторская', 4, current_date + 9, 450);
insert into product (name, type_id, expired_date, price)
	values ('Охотничья', 4, current_date + 14, 400);
insert into product (name, type_id, expired_date, price)
	values ('Сервелат', 4, current_date + 15, 650);
insert into product (name, type_id, expired_date, price)
	values ('Столичная', 4, '2021.06.15', 350);
insert into product (name, type_id, expired_date, price)
	values ('Мороженое Лакомка', 5, current_date + 15, 30);
insert into product (name, type_id, expired_date, price)
	values ('Мороженое Эскимо', 5, current_date + 10, 45);
insert into product (name, type_id, expired_date, price)
	values ('Мороженое Молочное', 5, current_date + 15, 40);
insert into product (name, type_id, expired_date, price)
	values ('Шоколадное', 5, current_date + 10, 55);
	
insert into type (name) values ('СЫР');
insert into type (name) values ('МОЛОКО');
insert into type (name) values ('ХЛЕБ');
insert into type (name) values ('КОЛБАСА');
insert into type (name) values ('МОРОЖЕНОЕ');

Select * FROM product;
Select * FROM type;

--1. Написать запрос получение всех продуктов с типом "СЫР"
SELECT *
FROM product as p 
join type as t on p.type_id = t.id
WHERE t.name LIKE 'СЫР';

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженое"
SELECT *
FROM product as p 
join type as t on p.type_id = t.id
WHERE p.name LIKE '%Мороженое%';

--3. Написать запрос, который выводит все продукты, срок годности которых уже истек
SELECT *
FROM product as p
join type as t on p.type_id = t.id
WHERE p.expired_date < current_date;

--4. Написать запрос, который выводит самый дорогой продукт.
SELECT p.name, t.name, MAX(p.price) as m 
FROM product as p
JOIN type as t on p.type_id = t.id
GROUP BY p.name, t.name
ORDER BY m desc
LIMIT 1;

--5. Написать запрос, который выводит для каждого типа количество 
-- продуктов к нему принадлежащих. В виде имя_типа, количество
SELECT t.name, count(p.type_id)
FROM product as p JOIN type as t
ON p.type_id = t.id
GROUP BY t.name;

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
SELECT p.name, t.name 
FROM product as p JOIN type as t
ON p.type_id = t.id
GROUP BY p.name, t.name
HAVING t.name = 'СЫР' or t.name = 'МОЛОКО'
ORDER BY p.name asc;

--7. Написать запрос, который выводит тип продуктов, 
--которых осталось меньше 10 штук. Под количеством 
--подразумевается количество продуктов определенного типа. 
--Например, если есть тип "СЫР" и продукты "Сыр плавленный" и 
--"Сыр моцарелла", которые ему принадлежат, то количество продуктов 
--типа "СЫР" будет 2. 
SELECT t.name, count(t.id) 
FROM product as p JOIN type as t
ON p.type_id = t.id
GROUP BY t.name
HAVING count(t.id)< 10;

--8. Вывести все продукты и их тип.
SELECT p.name, t.name
FROM product as p JOIN type as t
ON p.type_id = t.id;
