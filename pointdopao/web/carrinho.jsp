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
                <c:forEach items="${carrinhoLista}" var="produto" varStatus="control">

                    <s:property value="tmp" escape="false"/>
                    <p>Nome:  ${produto.nome}</p> 
                    <s:property value="tmp" escape="false"/>
                    <p>Quantidade: ${produto.quantidade}</p>
                    <s:property value="tmp" escape="false"/>
                    <p>Preco: ${produto.preco}</p>

                </c:forEach>
            </section>
            <s:property value="tmp" escape="false"/>
            <button  onclick="navegarParaPagina('acesso', 'default')">Adcionar Mais</button>

            <s:property value="tmp" escape="false"/>
            <button  onclick="navegarParaPagina('acesso', 'limpar')">Limpar</button>
        </div>
    </body>
</html>
