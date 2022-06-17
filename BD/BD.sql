CREATE DATABASE agendaBD;
USE agendaBD;

CREATE TABLE contatos(
	con_codigo int not null auto_increment,
    con_nome varchar(50) not null,
    con_email varchar(50) not null,
    con_telefone varchar(15) not null,
    
    primary key (con_codigo)
);

