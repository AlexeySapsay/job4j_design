--https://job4j.ru/profile/exercise/51/task-view/336
-- Many-to-many

create table logins(
    id serial primary key,
	login varchar(255),
	email_id int references logins(id) unique
);

create table emails(
    id serial primary key,
	email varchar(255)
);


insert into logins(login) values ('NochoyElf');
insert into logins(login) values ('RozoviyEbozavrik');
insert into logins(login) values ('Miha128');


insert into emails(email) values ('NochoyElf@mail.ru');
insert into emails(email) values ('RozoviyEbozavrik@goole.com');
insert into emails(email) values ('Miha128@yandex.ru');

SELECT * from logins;
SELECT * from emails;



