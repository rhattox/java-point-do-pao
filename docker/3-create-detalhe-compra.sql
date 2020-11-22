CREATE TABLE "detalhe_compra" (
  "id" serial NOT NULL,
  "id_compra" integer NOT NULL,
  "id_produto" integer NOT NULL,
  "quantidade_produto" integer NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_produto) REFERENCES produto (id),
  FOREIGN KEY (id_compra) REFERENCES compra (id)
);

