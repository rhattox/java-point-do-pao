<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css" integrity="sha384-Bfad6CLCknfcloXFOyFnlgtENryhrpZCe29RTifKEixXQZ38WheV+i/6YWSzkz3V" crossorigin="anonymous"/>
    <link rel="stylesheet" type="text/css" href="./css/app.css"/>
    <script src="./js/app.js"></script>
    <title>Point do Pão</title>
</head>
<body>
<section id="cabecalho">
    <nav class="navbar">
        <a class="navbar-brand" href="/pointdopao">
            <img src="./assets/logo_pdp.jpg" width="351" height="59.4" class="d-inline-block align-top" alt="">
        </a>
        <c:if test = "${autenticado == true}">
            <div id="statusUsuarioLogado" class="align-self-end">
                <i class="fas fa-user-circle fa-lg"></i>
                <span>Bem vindo, ${SessionNome}.</span>

                <span class="mr-3">Deseja sair? <a class="font-normal" href="javascript:navegarParaPagina('acesso','sair');">sign out</a>.</span>
            </div>
        </c:if>
        <c:if test = "${autenticado == false || autenticado == null }">
            <div id="statusUsuarioDeslogado" class="align-self-end">
                <a href="javascript:navegarParaPagina('acesso','entrar');"  class="mr-2">Entrar</a>
                <button class="btn btn-procurar alinhamento-conteudo-dir" onclick="navegarParaPagina('acesso', 'cadastrar')">Cadastrar</button>
            </div>
        </c:if>
    </nav>
    <hr class="mb-0" style="border-top: 2px solid #b34c1b;">

    <nav class="navbar navbar-expand-sm barra-botoes">
        <section>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/pointdopao">Home</a>
                </li>

                <c:if test="${isAdm == true}">
                    <li class="nav-item">
                        <a class="nav-link" href="javascript:navegarParaPagina('acesso','gestao');">Produtos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="javascript:navegarParaPagina('acesso','total-compras');">Vendas</a>
                    </li>
                </c:if>
            </ul>
        </section>
        <section class="d-inline-flex">
            <form class="form-inline">
                <input class="form-control mr-sm-2" type="search" placeholder="Procurar" aria-label="Search">
                <button class="btn btn-procurar my-2 my-sm-0" type="submit">
                    <i class="fas fa-search"></i>
                </button>
            </form>
            <a class="navbar-brand ml-4" href="#">
                <img src="./assets/carrinho.svg" width="30" height="30" class="d-inline-block align-top" alt="">
            </a>
        </section>
    </nav>
    <hr class="mt-0" style="border-bottom: 2px solid #b34c1b;">
</section>

<section id="conteudo">
    <div>
        <img src="./assets/banner_home.jpg" class="centralizar-img" alt="">
    </div>

    <section id="produtos" class="alinhamento-conteudo-esq alinhamento-cards-produtos">
        <h3 class="mt-4 mb-4 titulos">Nossos Produtos</h3>
        <div class="row">
            <c:forEach items="${listaProdutos}" var="produto" varStatus="control">
                <div class="col-3">
                    <div class="card-deck">
                        <div class="card mb-3">
                            <!--<img class="card-img-top" src="..." alt="">-->
                            <div class="card-body">
                                <h5 class="card-title">${produto.nome}</h5>
                                <p class="card-text"><small class="text-muted">Quantidade: ${produto.quantidade}</small></p>
                                <p class="card-text valor-produto">R$ ${produto.preco}</p>

                                <div class="d-flex">
                                    <div class="btn-group btn-group-toggle" data-toggle="buttons">
                                        <label class="btn btn-procurar active">
                                            <input type="radio" name="options" id="${control.index}-aumentar" autocomplete="off" onclick="quantidadeItemControl(${control.index}, 'aumentar')" checked>
                                            <i class="fas fa-plus"></i>
                                        </label>
                                        <label class="btn btn-procurar" id="${control.index}-label">
                                            <input type="radio" name="options" id="${control.index}-total" autocomplete="off">0
                                        </label>
                                        <label class="btn btn-procurar">
                                            <input type="radio" name="options" id="${control.index}-diminuir" autocomplete="off" onclick="quantidadeItemControl(${control.index}, 'diminuir')">
                                            <i class="fas fa-minus"></i>
                                        </label>
                                    </div>
                                    <button id="${control.index}-comprar" class="btn btn-procurar-comprar ml-auto" onclick="fecharPedido(${control.index}, ${autenticado})" disabled>Comprar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </section>
</section>
<section id="rodape">
    <footer class="bottom footer-bg">
        <div class="footer-copyright text-center py-3">© 2020 Copyright:
            <a href="https://github.com/bcovies/pointdopao">Github.com</a>
        </div>
    </footer>
</section>
</body>
</html>