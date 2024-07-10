CREATE TABLE TOPICO(
    id bigint not null auto_increment,
    autor_id bigint not null,
    data_criacao datetime not null,
    titulo varchar(200) not null,
    mensagem varchar(3000) not null,
    status varchar(50) not null,
    curso_id bigint not null,

    primary key (id),
    constraint fk_topico_autor foreign key (autor_id) references usuario (id),
    constraint fk_topico_curso foreign key (curso_id) references curso (id)
);