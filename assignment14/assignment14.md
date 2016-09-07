--create table called major
create table major (
id int primary key auto_increment,
major varchar(50),
SAT_score int check (SAT_score between 400 and 1600)
);

--populating table class with data
insert major(major, SAT_score) values('General Business',800);
insert major(major, SAT_score) values('Accounting',1000);
insert major(major, SAT_score) values('Finance',1100);
insert major(major, SAT_score) values('Math',1300);
insert major(major, SAT_score) values('Engineering',1350);
insert major(major, SAT_score) values('Education',900);
insert major(major, SAT_score) values('General Studies',500);


--create table instructor
create table instructor(
id int primary key auto_increment,
first_name varchar(30) not null,
last_name varchar(30) not null,
yrs_of_exp int not null,
tenured tinyint(1),
maj_id int,
foreign key(maj_id) references major(id)
);

--populate table instructor
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


--create table class
create table class(
id int primary key auto_increment,
class_name varchar(50),
class_no int,
teach_id int,
foreign key(teach_id) references instructor(id)
);

--populate class with data
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


create table major_class_relationship(
id int primary key,
major_id int not null,
class_id int not null,
foreign key(major_id) references major(id),
foreign key(class_id) references class(id)
);

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






create table student_class_relationship(
id int primary key,
student_id int not null,
class_id int not null,
foreign key(student_id) references student(id),
foreign key(class_id) references class(id)
);


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


insert assignment(id,student_id,assignment_nbr,class_id,grade_id)
values(1,110,1,20,2);
insert assignment(id,student_id,assignment_nbr,class_id,grade_id)
values(2,110,2,20,1);
insert assignment(id,student_id,assignment_nbr,class_id,grade_id)
values(3,110,3,10,2);
insert assignment(id,student_id,assignment_nbr,class_id,grade_id)
values(4,150,1,22,0);
insert assignment(id,student_id,assignment_nbr,class_id,grade_id)
values(5,140,1,30,3);
insert assignment(id,student_id,assignment_nbr,class_id,grade_id)
values(6,130,12,5,0);
insert assignment(id,student_id,assignment_nbr,class_id,grade_id)
values(7,180,14,6,3);
insert assignment(id,student_id,assignment_nbr,class_id,grade_id)
values(8,120,1,20,1);