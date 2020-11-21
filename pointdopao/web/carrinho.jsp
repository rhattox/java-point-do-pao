<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
              integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css"
              integrity="sha384-Bfad6CLCknfcloXFOyFnlgtENryhrpZCe29RTifKEixXQZ38WheV+i/6YWSzkz3V" crossorigin="anonymous"/>
        <link rel="stylesheet" type="text/css" href="./css/app.css"/>
        <script src="./js/app.js"></script>
        <title>Point do Pão</title>
    </head>
    <body>
        <div class="container container-cadastro-mt">
            <section class="d-flex">
                <p>Nome: </p>  
                <spam>${produto.nome}</spam>
                <br>
                <p>Quantidade</p>
                <spam>${produto.quantidade}</spam>
                <br>
                <p>Preco</p>
                <spam>${produto.preco}</spam>
                <br>
                <p>Carrinho</p>
                <spam>${carrinhoLista.size()}</spam>
            </section>

            <section class="d-flex">
                <c:forEach items="${carrinhoLista}" var="produto" varStatus="control">

                    <h5>${produto.nome}</h5>
                    <p>${produto.quantidade}</p>
                    <p>${produto.preco}</p>
                </c:forEach>
            </section>
            <button  onclick="navegarParaPagina('acesso', 'default')">Adcionar Mais</button>
            <button  onclick="navegarParaPagina('acesso', 'limpar')">Limpar</button>
        </div>
    </body>
</html>
