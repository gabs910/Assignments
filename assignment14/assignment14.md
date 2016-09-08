-- create table called major
create table major (
id int primary key auto_increment,
major varchar(50),
SAT_score int check (SAT_score between 400 and 1600)
);


-- populating table class with data
insert major(major, SAT_score) values('General Business',800);
insert major(major, SAT_score) values('Accounting',1000);
insert major(major, SAT_score) values('Finance',1100);
insert major(major, SAT_score) values('Math',1300);
insert major(major, SAT_score) values('Engineering',1350);
insert major(major, SAT_score) values('Education',900);
insert major(major, SAT_score) values('General Studies',500);


-- create table instructor
create table instructor(
id int primary key auto_increment,
first_name varchar(30) not null,
last_name varchar(30) not null,
yrs_of_exp int not null,
tenured tinyint(1),
maj_id int,
foreign key(maj_id) references major(id)
);


-- populate table instructor
insert instructor(first_name,last_name,maj_id,yrs_of_exp,tenured)
values('Instructor','One',1,10,1);
insert instructor(first_name,last_name,maj_id,yrs_of_exp,tenured)
values('Instructor','Two', 2, 5,0);
insert instructor(first_name,last_name,maj_id,yrs_of_exp,tenured)
values('Instructor','Three', 3, 20,1);
insert instructor(first_name,last_name,maj_id,yrs_of_exp,tenured)
values('Instructor','Four', 4, 15,1);
insert instructor(first_name,last_name,maj_id,yrs_of_exp,tenured)
values('Instructor','Five', 5, 2,0);
insert instructor(first_name,last_name,maj_id,yrs_of_exp,tenured)
values('Instructor','Six',6,4,0);
insert instructor(first_name,last_name,maj_id,yrs_of_exp,tenured)
values('Instructor','Seven', 7,3,0);


-- create class table
create table class(
id int primary key auto_increment,
class_name varchar(50),
class_no int,
teach_id int,
foreign key(teach_id) references instructor(id)
);


-- populate class table
insert class(class_name, class_no) values('English', 101);
insert class(class_name, class_no) values('English', 102);
insert class(class_name, class_no) values('English', 103);
insert class(class_name, class_no) values('English', 201);
insert class(class_name, class_no) values('English', 202);
insert class(class_name, class_no) values('English', 203);
insert class(class_name, class_no) values('English', 301);
insert class(class_name, class_no) values('English', 302);
insert class(class_name, class_no) values('English', 303);

insert class(class_name, class_no) values('Math', 201);
insert class(class_name, class_no) values('Math', 202);
insert class(class_name, class_no) values('Math', 203);
insert class(class_name, class_no) values('Math', 301);
insert class(class_name, class_no) values('Math', 302);
insert class(class_name, class_no) values('Math', 303);
insert class(class_name, class_no) values('Math', 304);

insert class(class_name, class_no) values('History', 101);
insert class(class_name, class_no) values('History', 201);
insert class(class_name, class_no) values('History', 301);

insert class(class_name, class_no) values('Computer Science', 311);
insert class(class_name, class_no) values('Computer Science', 312);
insert class(class_name, class_no) values('Computer Science', 313);
insert class(class_name, class_no) values('Computer Science', 441);
insert class(class_name, class_no) values('Computer Science', 442);
insert class(class_name, class_no) values('Computer Science', 443);

insert class(class_name, class_no) values('Psychology', 101);
insert class(class_name, class_no) values('Psychology', 102);
insert class(class_name, class_no) values('Psychology', 231);
insert class(class_name, class_no) values('Psychology', 232);

insert class(class_name, class_no) values('Education', 221);
insert class(class_name, class_no) values('Education', 222);
insert class(class_name, class_no) values('Education', 223);
insert class(class_name, class_no) values('Education', 351);
insert class(class_name, class_no) values('Education', 352);
insert class(class_name, class_no) values('Education', 353);


-- create table major_class_relationship
create table major_class_relationship(
id int primary key auto_increment,
major_id int not null,
class_id int not null,
foreign key(major_id) references major(id),
foreign key(class_id) references class(id)
);


--populate table major_class_relationship
insert major_class_relationship(major_id,class_id) values(4,4);
insert major_class_relationship(major_id,class_id) values(1,20);
insert major_class_relationship(major_id,class_id) values(7,26);
insert major_class_relationship(major_id,class_id) values(2,16);
insert major_class_relationship(major_id,class_id) values(4,15);
insert major_class_relationship(major_id,class_id) values(4,3);
insert major_class_relationship(major_id,class_id) values(4,5);
insert major_class_relationship(major_id,class_id) values(6,12);
insert major_class_relationship(major_id,class_id) values(5,6);
insert major_class_relationship(major_id,class_id) values(3,1);
insert major_class_relationship(major_id,class_id) values(2,34);
insert major_class_relationship(major_id,class_id) values(5,30);
insert major_class_relationship(major_id,class_id) values(1,22);
insert major_class_relationship(major_id,class_id) values(6,24);
insert major_class_relationship(major_id,class_id) values(7,35);
insert major_class_relationship(major_id,class_id) values(2,11);
insert major_class_relationship(major_id,class_id) values(6,13);
insert major_class_relationship(major_id,class_id) values(1,2);
insert major_class_relationship(major_id,class_id) values(4,34);
insert major_class_relationship(major_id,class_id) values(3,30);
insert major_class_relationship(major_id,class_id) values(2,4);
insert major_class_relationship(major_id,class_id) values(5,4);
insert major_class_relationship(major_id,class_id) values(2,9);
insert major_class_relationship(major_id,class_id) values(7,17);
insert major_class_relationship(major_id,class_id) values(1,3);



-- create table student_class_relationship
create table student_class_relationship(
id int primary key auto_increment,
student_id int not null,
class_id int not null,
foreign key(student_id) references student(id),
foreign key(class_id) references class(id)
);


-- populate student_class_relationship table
insert student_class_relationship(student_id,class_id) values(100,25);
insert student_class_relationship(student_id,class_id) values(100,20);
insert student_class_relationship(student_id,class_id) values(100,12);
insert student_class_relationship(student_id,class_id) values(100,5);
insert student_class_relationship(student_id,class_id) values(110,6);
insert student_class_relationship(student_id,class_id) values(110,12);
insert student_class_relationship(student_id,class_id) values(110,18);
insert student_class_relationship(student_id,class_id) values(120,2);
insert student_class_relationship(student_id,class_id) values(120,4);
insert student_class_relationship(student_id,class_id) values(120,8);
insert student_class_relationship(student_id,class_id) values(130,6);
insert student_class_relationship(student_id,class_id) values(130,30);
insert student_class_relationship(student_id,class_id) values(130,26);
insert student_class_relationship(student_id,class_id) values(130,16);
insert student_class_relationship(student_id,class_id) values(140,1);
insert student_class_relationship(student_id,class_id) values(140,11);
insert student_class_relationship(student_id,class_id) values(140,31);
insert student_class_relationship(student_id,class_id) values(150,3);
insert student_class_relationship(student_id,class_id) values(150,13);
insert student_class_relationship(student_id,class_id) values(150,29);
insert student_class_relationship(student_id,class_id) values(160,21);
insert student_class_relationship(student_id,class_id) values(160,15);
insert student_class_relationship(student_id,class_id) values(160,8);
insert student_class_relationship(student_id,class_id) values(170,11);
insert student_class_relationship(student_id,class_id) values(170,16);
insert student_class_relationship(student_id,class_id) values(170,17);
insert student_class_relationship(student_id,class_id) values(180,28);
insert student_class_relationship(student_id,class_id) values(190,33);


alter table student
add gpa decimal(5,1);

alter table student
add sat int;

alter table student
add major_id int,
add foreign key(major_id) references major(id);

alter table student
drop column years_of_experience;

alter table assignment
add class_id int,
add foreign key(class_id) references class(id);


--  populate assignment table
insert assignment(student_id,assignment_nbr,class_id,grade_id)
values(110,1,20,2);
insert assignment(student_id,assignment_nbr,class_id,grade_id)
values(110,2,20,1);
insert assignment(student_id,assignment_nbr,class_id,grade_id)
values(110,3,10,2);
insert assignment(student_id,assignment_nbr,class_id,grade_id)
values(150,1,22,0);
insert assignment(student_id,assignment_nbr,class_id,grade_id)
values(140,1,30,3);
insert assignment(student_id,assignment_nbr,class_id,grade_id)
values(130,12,5,0);
insert assignment(student_id,assignment_nbr,class_id,grade_id)
values(180,14,6,3);
insert assignment(student_id,assignment_nbr,class_id,grade_id)
values(120,1,20,1);


-- updated null fields in student table
update student set gpa=3.8, sat=1125, major_id=1 where id=110;
update student set gpa=2.2, sat=700, major_id=6 where id=120;
update student set gpa=4.0, sat=1050, major_id=5 where id=130;
update student set gpa=2.0, sat=1400, major_id=2 where id=140;
update student set gpa=2.6, sat=967, major_id=1 where id=150;
update student set gpa=3.0, sat=1279, major_id=3 where id=160;
update student set gpa=3.8, sat=1050, major_id=4 where id=170;
update student set gpa=1.2, sat=1600, major_id=2 where id=180;
update student set gpa=2.5, sat=600, major_id=3 where id=190;


-- update null fields in class table
update class set teach_id=1 where id=2;
update class set teach_id=4 where id=3;
update class set teach_id=2 where id=4;
update class set teach_id=6 where id=5;
update class set teach_id=5 where id=6;
update class set teach_id=4 where id=7;
update class set teach_id=1 where id=8;
update class set teach_id=1 where id=9;
update class set teach_id=6 where id=10;
update class set teach_id=4 where id=11;
update class set teach_id=3 where id=12;
update class set teach_id=2 where id=13;
update class set teach_id=3 where id=14;
update class set teach_id=4 where id=15;
update class set teach_id=5 where id=16;
update class set teach_id=6 where id=17;
update class set teach_id=1 where id=18;
update class set teach_id=3 where id=19;
update class set teach_id=4 where id=20;
update class set teach_id=5 where id=21;
update class set teach_id=2 where id=22;
update class set teach_id=3 where id=23;
update class set teach_id=2 where id=24;
update class set teach_id=5 where id=25;
update class set teach_id=3 where id=26;
update class set teach_id=2 where id=27;
update class set teach_id=6 where id=28;
update class set teach_id=3 where id=29;
update class set teach_id=4 where id=30;
update class set teach_id=1 where id=31;
update class set teach_id=3 where id=32;
update class set teach_id=2 where id=33;
update class set teach_id=3 where id=34;
update class set teach_id=1 where id=35;


-- add prerequisiste to class table using foreign key referencing class(id)
alter table class
add column prerequisite int,
add constraint fk_prerequisite
foreign key(prerequisite) references class(id);


-- populate prerequisiste field in class table
update class set prerequisite=1 where id=2;
update class set prerequisite=2 where id=3;
update class set prerequisite=3 where id=4;
update class set prerequisite=4 where id=5;
update class set prerequisite=5 where id=6;
update class set prerequisite=6 where id=7;
update class set prerequisite=7 where id=8;
update class set prerequisite=8 where id=9;
update class set prerequisite=10 where id=11;
update class set prerequisite=11 where id=12;
update class set prerequisite=12 where id=13;
update class set prerequisite=13 where id=14;
update class set prerequisite=14 where id=15;
update class set prerequisite=15 where id=16;
update class set prerequisite=17 where id=18;
update class set prerequisite=18 where id=19;
update class set prerequisite=20 where id=21;
update class set prerequisite=21 where id=22;
update class set prerequisite=22 where id=23;
update class set prerequisite=23 where id=24;
update class set prerequisite=24 where id=25;
update class set prerequisite=26 where id=27;
update class set prerequisite=27 where id=28;
update class set prerequisite=28 where id=29;
update class set prerequisite=30 where id=31;
update class set prerequisite=31 where id=32;
update class set prerequisite=32 where id=33;
update class set prerequisite=33 where id=34;
update class set prerequisite=34 where id=35;
