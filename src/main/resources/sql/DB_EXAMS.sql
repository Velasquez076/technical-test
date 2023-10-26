-- base de datos para mysql
create database db_exams;

use db_exams;

create table tb_exm_exam(
    exm_id_exam int not null auto_increment,
    exm_exam_topic varchar(100) not null,
    exm_status varchar(100) not null,
    primary key(exm_id_exam)
) engine = innodb;

-- tabla de preguntas
create table tb_exm_questions(
    exm_id_question int not null auto_increment,
    exm_question_exam varchar(200) not null,
    exm_first_option varchar(200) not null,
    exm_second_option varchar(200) not null,
    exm_third_option varchar(200) not null,
    exm_fourth_option varchar(200) not null,
    exm_correct_answer varchar(100) not null,
    exm_fk_id_exam int not null,
    primary key (exm_id_question),
    constraint fk_axm_ex foreign key (exm_fk_id_exam) references tb_exm_exam (exm_id_exam)
)engine = innodb;

-- Tabla de estudiantes
create table tb_exm_student(
    exm_id_student int not null auto_increment,
    exm_name_student varchar(100) not null,
    exm_age_student varchar(3),
    exm_city_student varchar(50) not null,
    exm_time_zone_student varchar(100) not null,
    exm_qualification int default null,
    primary key(exm_id_student)
)engine = innodb;

-- tabla para asignar la fecha del examen
create table tb_exm_assign_exam(
    exm_id_assign_exam int not null auto_increment,
    exm_exam_date varchar(50) not null,
    exm_fk_id_student int not null,
    exm_fk_id_exam int not null,
    primary key(exm_id_assign_exam),
    constraint fk_axm_student foreign key (exm_fk_id_student) references tb_exm_student (exm_id_student),
    constraint fk_axm_ass_exam foreign key (exm_fk_id_exam) references tb_exm_exam (exm_id_exam)
) engine = innodb;

-- tabla que contiene las respuestas de los estudiantes
create table tb_exm_collect_answers (
    exm_id_collect_answers int not null auto_increment,
    exm_first_answer_exam varchar(200) not null,
    exm_second_answer_exam varchar(200) not null,
    exm_third_answer_exam varchar(200) not null,
    exm_fk_id_exam int not null,
    exm_fk_id_student int not null,
    constraint fk_axm_ex_answer foreign key (exm_fk_id_exam) references tb_exm_exam (exm_id_exam),
    constraint fk_axm_student_answer foreign key (exm_fk_id_student) references tb_exm_student (exm_id_student),
    primary key(exm_id_collect_answers)
) engine = innodb;
