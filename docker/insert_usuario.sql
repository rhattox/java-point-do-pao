CREATE TABLE "usuario" (
  "id" serial NOT NULL,
  "tipo" integer NOT NULL,
  "nome" character varying(50) NOT NULL,
  "sobrenome" character varying(50) NOT NULL,
  "email" character varying(50) NOT NULL,
  "senha" character varying(10) NOT NULL,
  "endereco" character varying(70)
);

INSERT INTO usuario (nome, tipo, preco, quantidade )
VALUES ('1', '1', 'Administrador', 'PointdoPao', 'ADM', 'Pointdopao', '0.50');
