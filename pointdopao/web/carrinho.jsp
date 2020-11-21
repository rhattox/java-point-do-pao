<%@page contentType="text/html" pageEncoding="UTF-8" %>
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






                <c:forEach items="${carrinhoLista}" var="produto" varStatus="control">
                    <div class="col-3">
                        <div class="card-deck">
                            <div class="card mb-3">
                                <!--<img class="card-img-top" src="..." alt="">-->
                                <div class="card-body">
                                    <h5 class="card-title">${produto.nome}</h5>
                                    <p class="card-text"><small class="text-muted">Quantidade: ${produto.quantidade}</small></p>
                                    <p class="card-text valor-produto">R$ ${produto.preco}</p>

                                </div>
                            </div>
                        </div>
                    </div>
                    </div>
                </c:forEach>


                <button class="btn btn-procurar alinhamento-conteudo-dir" onclick="navegarParaPagina('acesso', 'default')">Adcionar Mais</button>



                <button class="btn btn-procurar alinhamento-conteudo-dir" onclick="navegarParaPagina('acesso', 'limpar')">Limpar</button>











            </section>
        </div>
    </body>
</html>
