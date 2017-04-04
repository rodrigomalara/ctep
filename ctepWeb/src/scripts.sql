CREATE SEQUENCE tarefa_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 2
  CACHE 1;
 
CREATE SEQUENCE tarefa_hist_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 2
  CACHE 1;
  
CREATE TABLE tarefa
(
  id_tarefa integer NOT NULL DEFAULT nextval('tarefa_seq'::regclass),
  tarefa character(60) NOT NULL,
  data_entrega date,
  prioridade smallint,
  estado character(1) NOT NULL,
  timeout timestamp without time zone,
  evento character(60),
  descricao text,
  CONSTRAINT tarefa_pk PRIMARY KEY (id_tarefa)
)
WITH (OIDS=FALSE);

CREATE TABLE tarefa_hist
(
  id_tarefa_hist integer NOT NULL DEFAULT nextval('tarefa_hist_seq'::regclass),
  id_tarefa integer NOT NULL,
  estado_anterior character(1) NOT NULL,
  estado_atual character(1) NOT NULL,
  tstamp timestamp without time zone,
  user_name character varying(50),
  comentarios character varying(100),
  CONSTRAINT tarefa_hist_pk PRIMARY KEY (id_tarefa_hist),
  CONSTRAINT tarefa_hist_fk FOREIGN KEY (id_tarefa)
      REFERENCES tarefa (id_tarefa) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
)
WITH (OIDS=FALSE);