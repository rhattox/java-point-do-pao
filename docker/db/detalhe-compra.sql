CREATE TABLE "detalhe_compra" (
  "id" serial NOT NULL,
  "id_compra" integer NOT NULL,
  "valor_total" numeric (7,2) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_compra) REFERENCES usuario (id),
);

