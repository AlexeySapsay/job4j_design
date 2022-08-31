create view show_students_with_books
    as select s.name as student, a.name as author from students as s
         join orders o on s.id = o.student_id
         join books b on o.book_id = b.id
         join authors a on b.author_id = a.id;

select * from show_students_with_books;

alter view show_students_with_books rename to show;

drop view show;