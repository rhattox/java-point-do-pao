<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css" integrity="sha384-Bfad6CLCknfcloXFOyFnlgtENryhrpZCe29RTifKEixXQZ38WheV+i/6YWSzkz3V" crossorigin="anonymous"/>
        <link rel="stylesheet" href="./css/app.css"> 
        <script src="./js/app.js"></script>
        <title>Point do Pão</title>
    </head>
    <body>
        <div class="container cadastro-container">
            <section class="d-flex">
                <div class="img-container-cadastro">
                    <img class="img-size" src="./assets/logo_pdp1.jpg"/>
                </div>
                <div class="linha-vertical mt-3"></div>

                <div class="ml-5">
                    <h1 class="mt-3 cor-padrao-txt">Junte-se a nós!</h1>
                    <form class="mt-4" method="POST" action='UsuarioController' name="adicionarUsuario">
                        <div class="form-row">
                            <div class="col">
                                <label for="Nome">Nome</label>
                                <input id="nomeForm" type="text" class="form-control" placeholder="Nome" onblur="validaCampoTexto('nomeForm', 'nomeHelp', 'nome')">
                                <small id="nomeHelp" class="form-text text-danger"></small>
                            </div>
                            <div class="col">
                                <label for="Sobrenome">Sobrenome</label>
                                <input id="sobrenomeForm" type="text" class="form-control" placeholder="Sobrenome" onblur="validaCampoTexto('sobrenomeForm', 'sobrenomeHelp', 'sobrenome')">
                                <small id="sobrenomeHelp" class="form-text text-danger"></small>
                            </div>
                        </div>
                        <div class="form-row mt-2">
                            <div class="col-12">
                                <label for="Nome">Email</label>
                                <input id="emailForm" type="email" class="form-control" placeholder="Email" onblur="validaCampoTexto('emailForm', 'emailHelp', 'email')">
                                <small id="emailHelp" class="form-text text-danger"></small>
                            </div>                      
                        </div>
                        <div class="form-row mt-2">
                            <div class="col">
                                <label for="Nome">Senha</label>
                                <input id="senhaForm" type="password" class="form-control" placeholder="Senha" onblur="validaSenhas()">
                                <small id="senhaHelp" class="form-text text-danger"></small>
                            </div>
                            <div class="col">
                                <label for="Sobrenome">Confirmar senha</label>
                                <input id="confirmacaoSenhaForm" type="password" class="form-control" placeholder="Confirme a senha" onblur="validaSenhas()">
                                <small id="confirmacaoSenhaHelp" class="form-text text-danger"></small>
                            </div>
                        </div>
                    </form>
                    <div class="d-flex justify-content-end mt-4">
                        <button type="submit" class="btn btn-secondary mr-2" onclick="voltar()">
                            <i class="fas fa-angle-left"></i>
                            voltar
                        </button>        
                        <button type="submit" class="btn btn-procurar" onclick="validaForm('entrar')">Cadastrar</button>
                    </div>        
                </div>
            </section>           
        </div>
    </body>
</html>