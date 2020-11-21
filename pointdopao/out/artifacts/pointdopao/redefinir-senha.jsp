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
        <div class="container container-cadastro-mt">
            <section class="d-flex">

                <div class="linha-vertical mt-3"></div>

                <div class="ml-5">
                    <h1 class="mt-3 cor-padrao-txt">Troque sua senha!</h1>
                    <form class="mt-4" method="POST" action='redefinir' name="redefinirSenha" onsubmit="return validaFormCadastro()">
                        <div class="form-row">

                            <div class="col-12">
                                <label for="Email">Email</label>
                                <input id="emailResetForm" name="emailResetForm" type="email" class="form-control" placeholder="Email" onblur="validaCampoTexto('emailResetForm', 'emailHelpReset', 'email')">
                                <small id="emailHelpReset" class="form-text text-danger"></small>
                            </div>                      

                        </div>
                        <div class="form-row mt-2">
                            <div class="col-12">
                                <label for="NovaSenha">Nova Senha</label>
                                <input id="novaSenhaResetForm" name="senhaResetForm" type="password" class="form-control" placeholder="Nova Senha" onblur="validaSenhasRedefinicao()">
                                <small id="novaSenhaHelpReset" class="form-text text-danger"></small>
                            </div>                      
                        </div>
                        <div class="form-row mt-2">
                            <div class="col-12">
                                <label for="ConfirmacaoNovaSenha">Confirmar Nova Senha</label>
                                <input id="confirmacaoNovaSenhaResetForm" name="confirmacaoNovaSenhaResetForm" type="password" class="form-control" placeholder="Confirmar Nova Senha" onblur="validaSenhasRedefinicao()">
                                <small id="confirmacaoNovaSenhaHelpReset" class="form-text text-danger"></small>
                            </div>                      
                        </div>

                        <div class="d-flex justify-content-end mt-4">
                            <button type="button" class="btn btn-secondary mr-2" onclick="voltar()">
                                <i class="fas fa-angle-left"></i>
                                voltar
                            </button>        
                            <button type="submit" class="btn btn-procurar">Redefinir</button>
                        </div> 
                    </form>        
                </div>
            </section>           
        </div>
    </body>
</html>