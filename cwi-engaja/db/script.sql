CREATE TABLE Desafio (
	id number(10) primary key,
	id_usuario number(10) not null,
	titulo varchar2(50) not null,
	descricao varchar2(120) not null,
	data_limite DATE,
	status varchar2(9),
		constraint UK_Titulo_Desafio UNIQUE (titulo, id_usuario),
		constraint FK_Usuario FOREIGN KEY (id_usuario) REFERENCES Usuario (id),
		constraint CHECK_Status CHECK (status IN ('ATIVO','ENCERRADO'))
);
CREATE SEQUENCE seq_desafio START WITH 1 INCREMENT BY 1;


CREATE TABLE Desafio_Meta (
	id number(10) primary key,
	id_desafio number(10) not null,
	quant_colaboracoes varchar2(50), 
	recompensa varchar2(50),
		constraint FK_Id_Desafio_Meta FOREIGN KEY (id_desafio) REFERENCES Desafio (id)
);
CREATE SEQUENCE seq_desafio_meta START WITH 1 INCREMENT BY 1;


CREATE TABLE Meta_Prestacao (
	id number(10) primary key,
	id_meta number(10) not null,
	descricao varchar2(100),
	imagem varchar2(250),
		constraint FK_Id_Meta_Prestacao FOREIGN KEY (id_meta) REFERENCES Desafio_Meta (id)
);
CREATE SEQUENCE seq_meta_prestacao START WITH 1 INCREMENT BY 1;


CREATE TABLE Desafio_Opcao_Contribuicao (
	id number(10) primary key,
	id_desafio number(10) not null,
	contribuicao varchar2(100),
		constraint FK_Id_Desafio_Opcao FOREIGN KEY (id_desafio) REFERENCES Desafio (id)
);
CREATE SEQUENCE seq_desafio_opcao_contribuicao START WITH 1 INCREMENT BY 1;


CREATE TABLE Desafio_Usuario_Participante (
	id_desafio number(10) not null,
	id_contribuicao number(10) not null,
	id_usuario number(10) not null,
		constraint FK_Id_Desafio FOREIGN KEY (id_desafio) REFERENCES Desafio (id),
		constraint FK_Id_Contribuicao FOREIGN KEY (id_contribuicao) REFERENCES Desafio_Opcao_Contribuicao (id),
		constraint FK_Id_Usuario_Participante FOREIGN KEY (id_usuario) REFERENCES Usuario (id)
);
CREATE SEQUENCE seq_desafio_usuario_participante START WITH 1 INCREMENT BY 1;