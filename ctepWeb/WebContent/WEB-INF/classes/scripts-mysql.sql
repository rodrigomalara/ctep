CREATE TABLE tarefa
(
  id_tarefa integer NOT NULL DEFAULT autoincrement,
  tarefa varchar(60) NOT NULL,
  data_entrega date,
  prioridade smallint,
  estado char(1) NOT NULL,
  timeout timestamp ,
  evento varchar(60),
  descricao text,
  CONSTRAINT tarefa_pk PRIMARY KEY (id_tarefa)
)
WITH (OIDS=FALSE);

CREATE TABLE tarefa_hist
(
  id_tarefa_hist integer NOT NULL DEFAULT auto_increment,
  id_tarefa integer NOT NULL,
  estado_anterior char(1) NOT NULL,
  estado_atual char(1) NOT NULL,
  tstamp timestamp,
  user_name varchar(50),
  comentarios varchar(100),
  CONSTRAINT tarefa_hist_pk PRIMARY KEY (id_tarefa_hist),
  CONSTRAINT tarefa_hist_fk FOREIGN KEY (id_tarefa)
      REFERENCES tarefa (id_tarefa) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
)
WITH (OIDS=FALSE);