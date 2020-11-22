CREATE TABLE "usuario" (
  "id" serial NOT NULL,
  "tipo" integer NOT NULL,
  "nome" character varying(50) NOT NULL,
  "sobrenome" character varying(50) NOT NULL,
  "email" character varying(50) NOT NULL,
  "senha" character varying(10) NOT NULL,
  "logradouro" character varying(70) NOT NULL,
  "numero" character varying(6) NOT NULL,
  "complemento" character varying(70),
  "bairro" character varying(20) NOT NULL,
  "estado" character varying(2) NOT NULL,
  "cep" character varying(9) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO usuario (id, tipo, nome, sobrenome, email, senha, logradouro, numero, complemento, bairro, estado, cep)
VALUES ('1', '0', 'ADMINISTRADOR', 'POINTDOPAO', 'ADM', 'Pointdopao', 'POINTDOPAO', '123', null, 'TIJUCA', 'RJ', '32145897');
