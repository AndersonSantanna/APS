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
    QtdAdubar int not null,
    QtdRegar int not null,
    QtdDedetizar int not null,
    QtdPodar int not null,
    primary key (IdArvore),
    foreign key (IdJogador) references Players(IdJogador)
);

CREATE EVENT reset
    ON SCHEDULE
      EVERY 1 HOUR
        DO
update Arvores set QtdAdubar = QtdAdubar + 10,
QtdDedetizar = QtdDedetizar +10, QtdPodar = QtdPodar + 10, QtdRegar = QtdRegar +10;

alter table Game.Players modify column Sexo varchar(15) not null;
alter table Game.Arvores add column NomeArvore varchar(45) not null;

select * from Game.Players;
select * from Game.Arvores;
select * from Game.Questoes;
select * from Game.Respostas;

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

select * from Players inner join Arvores on Players.IdJogador=Arvores.IdJogador where Players.IdJogador = 5;

INSERT INTO `Game`.`Questoes` (`questao`, `IdRespostaCorreta`) VALUES ('Qual das alternativas descreve melhor o processo conhecido por Reciclagem?
', '4');
INSERT INTO `Game`.`Questoes` (`questao`, `IdRespostaCorreta`) VALUES ('Como separar corretamente seu lixo?', '6');
INSERT INTO `Game`.`Questoes` (`questao`, `IdRespostaCorreta`) VALUES ('O que é coleta seletiva?', '9');




INSERT INTO `Game`.`Respostas` (`IdResposta`, `IdQuestao`, `resposta`) VALUES ('1', '1', '“Jogar fora” o lixo produzido.');
INSERT INTO `Game`.`Respostas` (`IdResposta`, `IdQuestao`, `resposta`) VALUES ('2', '1', 'Coletar todo tipo de material existente em lixos recicláveis.');
INSERT INTO `Game`.`Respostas` (`IdResposta`, `IdQuestao`, `resposta`) VALUES ('3', '1', 'Nome dado para todo o processo do lixo após seu descarte.');
INSERT INTO `Game`.`Respostas` (`IdResposta`, `IdQuestao`, `resposta`) VALUES ('4', '1', 'Processo de transformação de materiais usados em novos produtos para consumo.');
INSERT INTO `Game`.`Respostas` (`IdResposta`, `IdQuestao`, `resposta`) VALUES ('5', '2', 'Juntar tudo na lixeira, pois os prédios já fazem o trabalho de separação.\n');
INSERT INTO `Game`.`Respostas` (`IdResposta`, `IdQuestao`, `resposta`) VALUES ('6', '2', 'Separar o lixo orgânico (restos de alimentos, papel sujo e lixo sanitário) dos resíduos sólidos (como plástico, vidro, papel, metal e embalagens longa vida).\n');
INSERT INTO `Game`.`Respostas` (`IdResposta`, `IdQuestao`, `resposta`) VALUES ('7', '2', 'Deixar plásticos sujos junto com lixo orgânico.');
INSERT INTO `Game`.`Respostas` (`IdResposta`, `IdQuestao`, `resposta`) VALUES ('8', '2', 'Juntar todo tipo de lixo e descartar em ponto de coleta.');
INSERT INTO `Game`.`Respostas` (`IdResposta`, `IdQuestao`, `resposta`) VALUES ('9', '3', 'Processo de separação e recolhimento dos resíduos para o reaproveitamento por meio de reciclagem.');
INSERT INTO `Game`.`Respostas` (`IdResposta`, `IdQuestao`, `resposta`) VALUES ('10', '3', 'Destinação de resíduos para lixões e aterros.');
INSERT INTO `Game`.`Respostas` (`IdResposta`, `IdQuestao`, `resposta`) VALUES ('11', '3', 'Processo de envio de todo o lixo produzido para cooperativas ou entrega para catadores de rua.');
INSERT INTO `Game`.`Respostas` (`IdResposta`, `IdQuestao`, `resposta`) VALUES ('12', '3', 'A escolha aleatória do melhor lixo produzido.');

