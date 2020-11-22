CREATE TABLE "carrinho" (
  "id" serial NOT NULL,
  "id_usuario" integer NOT NULL,
  "id_produto" integer NOT NULL,
  "valor" numeric (5,2) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_usuario) REFERENCES usuario (id),
  FOREIGN KEY (id_produto) REFERENCES produto(id)
);

