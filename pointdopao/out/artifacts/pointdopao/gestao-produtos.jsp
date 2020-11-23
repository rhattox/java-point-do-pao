<%@page import="java.sql.*" %>
<%@page import="java.io.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css"
          integrity="sha384-Bfad6CLCknfcloXFOyFnlgtENryhrpZCe29RTifKEixXQZ38WheV+i/6YWSzkz3V" crossorigin="anonymous"/>
    <link rel="stylesheet" type="text/css" href="./css/app.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="./js/app.js"></script>
    <title>Point do pão</title>
</head>
<body>
<section id="cabecalho">
    <nav class="navbar">
        <a class="navbar-brand" href="/pointdopao">
            <img src="./assets/logo_pdp.jpg" width="351" height="59.4" class="d-inline-block align-top" alt="">
        </a>
        <c:if test="${autenticado == true}">
            <div id="statusUsuarioLogado" class="align-self-end">
                <i class="fas fa-user-circle fa-lg"></i>
                <span>Bem vindo, ${SessionNome}.</span>

                <span class="mr-3">Deseja sair? <a class="font-normal"
                                                   href="javascript:navegarParaPagina('acesso','sair');">sign out</a>.</span>
            </div>
        </c:if>
        <c:if test="${autenticado == false}">
            <div id="statusUsuarioDeslogado" class="align-self-end">
                <a href="javascript:navegarParaPagina('acesso','entrar');" class="mr-2">Entrar</a>
                <button class="btn btn-procurar alinhamento-conteudo-dir"
                        onclick="navegarParaPagina('acesso', 'cadastrar')">Cadastrar
                </button>
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
                <li class="nav-item">
                    <a class="nav-link" href="#">Produtos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="javascript:navegarParaPagina('acesso','total-compras');">Vendas</a>
                </li>
            </ul>
        </section>
        <section class="d-flex ml-auto">
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
<section class="container">
    <section>
        <h3 class="mt-4 mb-4 titulos">Novo produto</h3>
        <form class="mt-4" method="POST" action='produto' name="novoProduto" onsubmit="return validaFormCadastro()">
            <div class="form-row">
                <div class="col">
                    <label for="nomeProdutoForm">Nome do produto</label>
                    <input id="nomeProdutoForm" name="nomeProdutoForm" type="text" class="form-control" placeholder="Nome do produto" onblur="validaCampoTexto('nomeProdutoForm', 'nomeProdutoHelp', 'nome do produto')">
                    <small id="nomeProdutoHelp" class="form-text text-danger"></small>
                </div>
                <div class="col-1">
                    <label for="qtdProdutoForm">Quantidade</label>
                    <input id="qtdProdutoForm" name="qtdProdutoForm" type="text" class="form-control" value="1" readonly>
                </div>
                <div class="col">
                    <label for="precoProdutoForm">Preço (R$)</label>
                    <input id="precoProdutoForm" name="precoProdutoForm" type="text" class="form-control" placeholder="Preço por unidade" onblur="validaCampoTexto('precoProdutoForm', 'precoProdutoHelp', 'preço'); formatPrecoProduto()">
                    <small id="precoProdutoHelp" class="form-text text-danger"></small>
                </div>
                <div class="col btn-incluir-produto">
                    <label for="btnProdutoForm"></label>
                    <button id="btnProdutoForm" type="submit" class="btn btn-procurar">Incluir</button>
                </div>
            </div>
        </form>
    </section>
    <h3 class="mt-4 mb-4 titulos">Todos os produtos</h3>
    <table class="table">
        <thead class="cor-tabela-header">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Nome do Produto</th>
            <th scope="col">Quantidade</th>
            <th scope="col">Preço</th>
            <th scope="col">Remover</th>
            <th scope="col">Editar</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listaProdutos}" var="produto" varStatus="control">
            <tr>
                <td>${produto.id}</td>
                <td>${produto.nome}</td>
                <td>${produto.quantidade}</td>
                <td>R$ ${produto.preco}</td>
                <td><a class="cursor" href="javascript:removerProdutoLista(${produto.id});"><i class="fas fa-times cor-padrao-txt alinhamento-exclusao-produto"></i></a></td>
                <td><a
                        class="cursor"
                        data-toggle="modal"
                        data-target="#modalEditProduto"
                        data-whatever="@mdo">
                    <i class="fas fa-edit cor-padrao-txt alinhamento-exclusao-produto"></i>
                </a></td>

                <!-- TODO pensar em uma forma de realizar o update do produto -->
            </tr>

            <section id="modal">
                <div class="modal fade" id="modalEditProduto" tabindex="-1" aria-labelledby="editProdutoModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="editProdutoModalLabel">Atualizar produto</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form>
                                    <div class="form-group">
                                        <label for="recipient-nome-produto" class="col-form-label">Nome do produto</label>
                                        <input type="text" class="form-control" id="recipient-nome-produto" value="${produto.nome}">
                                    </div>
                                    <div class="form-group">
                                        <label for="recipient-quantidade-produto" class="col-form-label">Quantidade</label>
                                        <input type="text" class="form-control" id="recipient-quantidade-produto">
                                    </div>
                                    <div class="form-group">
                                        <label for="recipient-preco-produto" class="col-form-label">Preço</label>
                                        <input type="text" class="form-control" id="recipient-preco-produto">
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                <button type="button" class="btn btn-procurar-comprar">Salvar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </c:forEach>
        </tbody>
    </table>
</section>
</body>
</html>
