<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <div>
            <h3 class="mt-3 cor-padrao-txt">Local de Entrega</h3>
            <form class="mt-4 p-0" method="POST" action='cadastrar' name="adicionarUsuario"
                  onsubmit="return validaFormCadastro()">
                <div class="form-row">
                    <div class="form-group col-7">
                        <label for="enderecoCheckoutForm">Endereço</label>
                        <input id="enderecoCheckoutForm" name="enderecoCheckoutForm" type="text" class="form-control"
                               placeholder="Endereço"
                               onblur="validaCampoTexto('enderecoCheckoutForm', 'enderecoCheckoutHelp', 'endereço')">
                        <small id="enderecoCheckoutHelp" class="form-text text-danger"></small>
                    </div>
                    <div class="form-group col-3">
                        <label for="numeroCheckoutForm">Nº</label>
                        <input id="numeroCheckoutForm" name="numeroCheckoutForm" type="text" class="form-control"
                               placeholder="Número"
                               onblur="validaCampoTexto('numeroCheckoutForm', 'numeroCheckoutHelp', 'número')">
                        <small id="numeroCheckoutHelp" class="form-text text-danger"></small>
                    </div>
                </div>
                <div class="form-row mt-2">
                    <div class="form-group col-10">
                        <label for="cpCheckoutForm">Complemento</label>
                        <input id="cpCheckoutForm" name="cpCheckoutForm" type="text" class="form-control"
                               placeholder="Complemento">
                    </div>
                </div>
                <div class="form-row mt-2">
                    <div class="form-group col-5">
                        <label for="bairroCheckoutForm">Bairro</label>
                        <input id="bairroCheckoutForm" name="bairroCheckoutForm" type="text" class="form-control"
                               placeholder="Bairro"
                               onblur="validaCampoTexto('bairroCheckoutForm', 'bairroCheckoutHelp', 'bairro')">
                        <small id="bairroCheckoutHelp" class="form-text text-danger"></small>
                    </div>
                    <div class="form-group col-2">
                        <label for="estadoCheckoutForm">Estado</label>
                        <input id="estadoCheckoutForm" name="estadoCheckoutForm" type="text" class="form-control"
                               placeholder="Sigla"
                               onblur="validaCampoTexto('estadoCheckoutForm', 'estadoCheckoutHelp', 'estado')">
                        <small id="estadoCheckoutHelp" class="form-text text-danger"></small>
                    </div>
                    <div class="form-group col-3">
                        <label for="cepCheckoutForm">CEP</label>
                        <input id="cepCheckoutForm" name="cepCheckoutForm" type="text" class="form-control"
                               placeholder="CEP" onblur="validaCampoTexto('cepCheckoutForm', 'cepCheckoutHelp', 'CEP')">
                        <small id="cepCheckoutHelp" class="form-text text-danger"></small>
                    </div>
                </div>
            </form>
        </div>

        <div class="linha-vertical mt-3 mr-5"></div>

        <div id="total-a-pagar" class="largura-compras">
            <h3 class="mt-3 cor-padrao-txt">Compras</h3>
            <h5 class="mt-4">Produtos</h5>
            <form class="mt-4 p-0" method="POST" action='cadastrar' name="adicionarUsuario"
                  onsubmit="return validaFormCadastro()">
                <div class="form-row compras-title-row">
                    <div class="form-group col-6">
                        <label id="nomeProdutoCompraTitle"><b>Nome</b></label>
                    </div>
                    <div class="form-group col-2">
                        <label id="qtdProdutoCompraTitle"><b>Qtd</b></label>
                    </div>
                    <div class="form-group col-3">
                        <label id="precoProdutoCompraTitle"><b>Preço</b></label>
                    </div>
                </div>
                <jsp:useBean id="carrinhoLista" scope="request" type="java.util.List"/>
                <c:forEach items="${carrinhoLista}" var="produto" varStatus="control">
                    <div class="form-row compras-title-row">
                        <div class="form-group col-6">
                            <label id="nomeProdutoCompra">${produto.nome}</label>
                        </div>
                        <div class="form-group col-2">
                            <label id="qtdProdutoCompra">${produto.quantidade}</label>
                        </div>
                        <div class="form-group col-3">
                            <label id="precoProdutoCompra">${produto.preco}</label>
                        </div>
                        <div class="form-group">
                            <label id="cancelarProdutoCompra" onclick="removerProdutoListaCompra(${control.index})">X</label>
                        </div>
                    </div>
                </c:forEach>

                <div class="d-flex justify-content-end mt-4 col-10 pr-0">
                    <button type="button" class="btn btn-secondary mr-2" onclick="navegarParaHome()">
                        <i class="fas fa-angle-left"></i>
                        Voltar
                    </button>
                    <button type="submit" class="btn btn-procurar">Comprar</button>
                </div>
            </form>
        </div>
    </section>
</div>
</body>
</html>
