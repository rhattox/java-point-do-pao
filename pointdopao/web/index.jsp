<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <title>Point do Pão</title>
    </head>
    <style>
        a:link, a:visited {
            text-decoration: none;
            font-size: larger;
            color: #ac4d21;
        }
        a:hover {
            text-decoration: underline; 
            color: #f89d16;
        }
        a:active {
            text-decoration: none
        }
        .navbar, .barra-botoes {
            justify-content: space-between !important;
        }
        .btn-procurar {
            color: #b34c1b;
            border-color: #b34c1b;
        }
        .btn-procurar:hover {
            color: #fff;
            background-color: #b34c1b;
            border-color: #b34c1b;
        }
        .footer-bg {
            background-color: #4e230c;
        }
        .footer-copyright {
            color: white;
        }
    </style>
    <body>
        <section id="cabecalho">
            <nav class="navbar">
                <a class="navbar-brand" href="#">
                    <img src="./assets/logo_pdp.jpg" width="351" height="59.4" class="d-inline-block align-top" alt="">
                </a>
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
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-procurar my-2 my-sm-0" type="submit">Search</button>
                    </form>
                    <a class="navbar-brand ml-4" href="#">
                        <img src="./assets/carrinho.svg" width="30" height="30" class="d-inline-block align-top" alt="">
                    </a>
                </section>
            </nav>
            <hr class="mt-0" style="border-bottom: 2px solid #b34c1b;">
        </section>

        <section id="conteudo">

        </section>
        <section id="rodape">
            <footer class="fixed-bottom footer-bg">
                <div class="footer-copyright text-center py-3">© 2020 Copyright:
                    <a href="https://github.com/bcovies/pointdopao">Github.com</a>
                </div>
            </footer>
        </section>
    </body>
</html>