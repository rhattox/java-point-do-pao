CREATE TABLE "usuario" (
  "id" serial NOT NULL,
  "tipo" integer NOT NULL,
  "nome" character varying(50) NOT NULL,
  "sobrenome" character varying(50) NOT NULL,
  "email" character varying(50) NOT NULL,
  "senha" character varying(10) NOT NULL,
  "endereco" character varying(70),
  PRIMARY KEY (id)
);

INSERT INTO usuario (id, tipo, nome, sobrenome, email, senha)
VALUES ('1', '0', 'ADMINISTRADOR', 'POINTDOPAO', 'ADM', 'Pointdopao');
