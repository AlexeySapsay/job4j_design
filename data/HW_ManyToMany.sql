--https://job4j.ru/profile/exercise/51/task-view/336
-- Many-to-many

create table visitors(
    id serial primary key,
	nameVisitor varchar(255)
);

create table films(
    id serial primary key,
	nameFilm varchar(255)
);

create table visitors_films(
	id serial primary key,
	visitors_id int references visitors(id),
	films_id int references films(id)
);

insert into visitors(nameVisitor) values ('Boria');
insert into visitors(nameVisitor) values ('Max');
insert into visitors(nameVisitor) values ('Miha');
insert into visitors(nameVisitor) values ('Saha');

insert into films(nameFilm) values ('Vosstanie Java Virtual Mashine 3');
insert into films(nameFilm) values ('Ot zakata do rassveta. Java  vip edition');
insert into films(nameFilm) values ('Crazy Garbage Collector. Best horror 2021');

insert into visitors_films(visitors_id,films_id) values(1,1);
insert into visitors_films(visitors_id,films_id) values(1,2);
insert into visitors_films(visitors_id,films_id) values(1,3);
insert into visitors_films(visitors_id,films_id) values(2,2);
insert into visitors_films(visitors_id,films_id) values(3,1);
insert into visitors_films(visitors_id,films_id) values(3,2);
insert into visitors_films(visitors_id,films_id) values(4,3);

SELECT * from visitors;
SELECT * from films;
SELECT * FROM visitors_films;



