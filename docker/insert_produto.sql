CREATE TABLE "produto" (
  "id" serial NOT NULL,
  "nome" character varying(120) NOT NULL,
  "descricao"character varying(120),
  "preco" float NOT NULL,
  "quantidade" int NOT NULL
);


INSERT INTO produto (nome, preco, quantidade )
 VALUES ('pâo de queijo', '8.50', '10');

 INSERT INTO produto (nome, preco, quantidade )
 VALUES ('bolo', '12.00', '3');

 INSERT INTO produto (nome, preco, quantidade )
 VALUES ('pÂo francês', '1.50', '30');

 INSERT INTO produto (nome, preco, quantidade )
 VALUES ('misto quente', '4.00', '15');

 INSERT INTO produto (nome, preco, quantidade )
 VALUES ('café', '2.50', '30');

 INSERT INTO produto (nome, preco, quantidade )
 VALUES ('pâo de queijo', '8.50', '10');