-- CREATE DATABASE orcamento;

CREATE TABLE departamentos(
	 id serial PRIMARY KEY
	,nome varchar(100)  NOT NULL UNIQUE
);

CREATE TABLE funcionarios(
	 id serial PRIMARY KEY
	,departamento_id int REFERENCES departamentos(id) 
	,chefe_dpto boolean default ('f')
	,nome varchar(100)  NOT NULL
	,email varchar(100) 
	,endereco varchar(100) 
	,nascimento TIMESTAMP(0) WITHOUT TIME ZONE
);	

CREATE TABLE requisicoes(
	 id serial PRIMARY KEY
	,departamento_id int REFERENCES departamentos(id) 
	,func_lancador_id int REFERENCES funcionarios(id) 
	,func_aprovador_id int REFERENCES funcionarios(id) 
	,numero int not null
	,data_requisicao TIMESTAMP(0) WITHOUT TIME ZONE DEFAULT('now()')
	,data_aprovacao TIMESTAMP(0) WITHOUT TIME ZONE
);

CREATE TABLE rubricas(
	 id serial PRIMARY KEY
	,nome varchar(100)  NOT NULL
	,tipo varchar(1) CHECK (tipo in ('D', 'R', 'I'))
);

CREATE TABLE itens(
	  id serial PRIMARY KEY
	 ,nome varchar(100)  NOT NULL
	 ,rubrica_id int REFERENCES rubricas(id) 
);

CREATE TABLE itens_requisicoes(
	 id serial PRIMARY KEY
	,itens_id int REFERENCES itens(id)
	,requisicao_id int REFERENCES requisicoes(id)
	,quantidade decimal(12,2) NOT NULL 
	,valor decimal(12,2) default(0.00)
);

CREATE TABLE orcamentos(
	  id serial PRIMARY KEY
	 ,nome varchar(100)  NOT NULL
);

CREATE TABLE periodos(
	  id serial PRIMARY KEY
	 ,nome varchar(100)  NOT NULL
	 ,data_inicio TIMESTAMP(0) WITHOUT TIME ZONE
	 ,data_fim TIMESTAMP(0) WITHOUT TIME ZONE
);

CREATE TABLE orc_contab(
	 id serial PRIMARY KEY
	,orcamento_id int REFERENCES orcamentos(id)
	,departamento_id int REFERENCES departamentos(id)
	,rubrica_id int REFERENCES rubricas(id)
	,periodo_id int REFERENCES periodos(id)
	,valor_orcado DECIMAL (12,2) DEFAULT (0.00)
	,saldo DECIMAL (12,2) DEFAULT (0.00)
);

