<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <a class="navbar-brand" href="#">
                    <img src="./assets/logo_pdp.jpg" width="351" height="59.4" class="d-inline-block align-top" alt="">
                </a>
                <div id="statusUsuarioLogado" class="align-self-end">
                    <i class="fas fa-user-circle fa-lg"></i>
                    <span>Bem vindo, ${sessionScope['nome']}.</span>
                    <span class="mr-3">Deseja sair? <a class="font-normal" href="#">sign out</a>.</span>
                </div>
                    <div id="statusUsuarioDeslogado" class="align-self-end">
                    <a href="javascript:navegarParaPagina('acesso','entrar');"  class="mr-2">Entrar</a>
                    <button class="btn btn-procurar alinhamento-conteudo-dir" onclick="navegarParaPagina('acesso','cadastrar')">Cadastrar</button>
                </div>
            </nav>
            <hr class="mb-0" style="border-top: 2px solid #b34c1b;">

            <nav class="navbar navbar-expand-sm barra-botoes">
                <section>
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Produtos</a>
                        </li>
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

            <section id="produtos" class="alinhamento-conteudo-esq">
                <h3 class="mt-4 mb-4 titulos">Nossos Produtos</h3>
                <div class="card mb-3">
                    <img class="card-img-top" src="./assets/produtos/pao_frances.jpg" alt="">
                    <div class="card-body">
                        <h5 class="card-title">Pão Francês</h5>
                        <p class="card-text">O queridinho do café da manhã.</p>
                        <button class="btn btn-procurar d-flex ml-auto">Adicionar</button>
                    </div>
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