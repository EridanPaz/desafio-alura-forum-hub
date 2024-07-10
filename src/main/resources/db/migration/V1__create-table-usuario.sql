CREATE TABLE USUARIO(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null,
    perfil varchar(30) not null,
    primary key(id)
);