INSERT INTO users(name) values('Alex Sapsay');
INSERT INTO users(name) values('Ivan Ivanov');

INSERT INTO items(name) values ('Bug1');
INSERT INTO items(name) values ('Bug2');
INSERT INTO items(name) values ('Bug3');
INSERT INTO items(name) values ('Bug4');

INSERT INTO comments(id_items, text) values('1','need to fix bug');
INSERT INTO comments(id_items, text) values('2','dont fix that bug');

INSERT INTO roles(name) values('admin');
INSERT INTO roles(name) values('user');
INSERT INTO roles(name) values('guest');

INSERT INTO rules(name) values('admin_rules');
INSERT INTO rules(name) values('user_rules');
INSERT INTO rules(name) values('guest_rules');

INSERT INTO roles_rules(id_roles, id_rules) values('2','1');
INSERT INTO roles_rules(id_roles, id_rules) values('1','2');

INSERT INTO category(name) values('in prosses');
INSERT INTO category(name) values('finished');
INSERT INTO category(name) values('in treker');

INSERT INTO state(name) values('accepted');
INSERT INTO state(name) values('rejected');
INSERT INTO state(name) values('evaluating');

SELECT * FROM roles;
SELECT * FROM rules;
SELECT * FROM roles_rules;
SELECT * FROM category;
SELECT * FROM state;
