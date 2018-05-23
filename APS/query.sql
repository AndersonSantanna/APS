create database Game;
use Game;

create table Players(
	IdJogador int not null auto_increment,
    NomeJogador varchar(350) not null,
    Usuario varchar(45) not null,
    Senha varchar(500) not null,
    Idade int(8) not null,
    Sexo char(1)not null,
    PRIMARY KEY (IdJogador)
);

create table Arvores(
	IdArvore int not null auto_increment,
    NomeArvore varchar(45) not null,
    expArvore int not null,
    nivelArvore int not null,
    IdJogador int not null,
    primary key (IdArvore),
    foreign key (IdJogador) references Players(IdJogador)
);

alter table Game.Players modify column Sexo varchar(15) not null;
alter table Game.Arvores add column NomeArvore varchar(45) not null;

select * from Game.Players;
select * from Game.Arvores;

create table Questoes(
	IdQuestao int not null auto_increment,
	questao varchar(1000),
    IdRespostaCorreta int not null,
    primary key(IdQuestao)
);

create table Respostas(
	IdResposta int not null auto_increment,
    IdQuestao int not null,
    resposta varchar(500),
    primary key (IdResposta),
    foreign key (IdQuestao) references Questoes(IdQuestao)
)

select max(IdJogador) from Players;
select * from Players;

update Arvores set NomeArvore = "arvoreNome" where IdJogador = 5;

select * from Players inner join Arvores on Players.IdJogador=Arvores.IdJogador where Players.IdJogador = 5
