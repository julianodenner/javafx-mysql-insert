create schema if not exists db_contato;

use db_contato;

create table if not exists tb_contato(
	codigo integer not null auto_increment,
	nome varchar(200),
	telefone varchar(20),
	primary key(codigo)
);