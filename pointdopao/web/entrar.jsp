<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css" integrity="sha384-Bfad6CLCknfcloXFOyFnlgtENryhrpZCe29RTifKEixXQZ38WheV+i/6YWSzkz3V" crossorigin="anonymous"/>
        <link rel="stylesheet" type="text/css" href="./css/app.css"/> 
        <script src="./js/app.js"></script>
        <title>Point do Pão</title>
    </head>
    <body onload="alertLoginSuccess(${success})">
        <div class="container container-login-mt">
            <section class="d-flex">
                <div class="img-container-login">
                    <img class="img-size" src="./assets/logo_pdp1.jpg" onclick="navegarParaPagina('/pointdopao')"/>
                </div>
            </section>
            <div>
                <form method="POST" action='entrar' onsubmit="return validarLogin()" name="adicionarUsuario">          
                    <section>
                        <div class="input-group col-4 mx-auto">
                            <div class="input-group-prepend">
                                <div class="input-group-text">@</div>
                            </div>
                            <input type="text" class="form-control" name="emailLoginForm" placeholder="Email">
                        </div>

                        <div class="input-group col-4 mx-auto mt-4">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><i class="fas fa-key"></i></span>
                            </div>
                            <input type="password" class="form-control" name="senhaLoginForm" placeholder="Senha">
                        </div>
                    </section>
                    <div class="d-flex flex-row-reverse mx-auto mt-2 col-4">
                        <span>Esqueci minha <a class="font-normal" href="javascript:navegarParaPagina('acesso','redefinir');">senha</a>.</span>
                    </div>
                    <div class="d-flex flex-row-reverse mx-auto mt-3 col-4">
                        <button type="submit" class="btn btn-procurar btn-block">
                            Entrar
                        </button> 
                    </div>
                </form>

                <div class="d-flex flex-row-reverse mx-auto mt-4 col-4">
                    <span>Ainda não é nosso cliente?</span> 
                </div>
                <div class="d-flex flex-row-reverse mx-auto mt-1 col-4">
                    <span> Junte-se a <a class="font-normal" href="javascript:navegarParaPagina('acesso','cadastrar');">nós</a>.</span>
                </div>
            </div>
        </div>
    </body>
</html>
