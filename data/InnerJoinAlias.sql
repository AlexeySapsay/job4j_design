create table course(
    id serial primary key,
    name varchar(255)
);

create table student(
    id serial primary key,
    name varchar(255),
    course_id int references course(id)
);

insert into course(name) values ('English');
insert into course(name) values ('Math');
insert into course(name) values ('Physics');

insert into student(name, course_id) values ('Ivan', 1);
insert into student(name, course_id) values ('Boris', 2);
insert into student(name, course_id) values ('Petr', 3);

SELECT course.name as course, student.name as student  FROM course  join student on course_id = course.id;
SELECT course.name as course FROM course  join student on course_id = course.id;
SELECT student.name as student  FROM course  join student on course_id = course.id;