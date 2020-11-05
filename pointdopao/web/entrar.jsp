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
    <body>
        <div class="container container-login-mt">
            <section class="d-flex">
                <div class="img-container-login">
                    <img class="img-size" src="./assets/logo_pdp1.jpg"/>
                </div>
            </section>
            <div>
                <form method="POST" action='UsuarioController' name="adicionarUsuario">          
                    <section>
                        <div class="input-group col-4 mx-auto">
                            <div class="input-group-prepend">
                                <div class="input-group-text">@</div>
                            </div>
                            <input type="text" class="form-control" id="emailLoginForm" placeholder="Email">
                        </div>

                        <div class="input-group col-4 mx-auto mt-4">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><i class="fas fa-key"></i></span>
                            </div>
                            <input type="text" class="form-control" id="senhaLoginForm" placeholder="Senha">
                        </div>
                    </section>
                </form>
                
                <div class="d-flex flex-row-reverse mx-auto mt-2 col-4">
                    <span>Esqueci minha <a class="font-normal" href="#">senha</a>.</span>
                </div>
                <div class="d-flex flex-row-reverse mx-auto mt-3 col-4">
                    <button class="btn btn-procurar btn-block">
                        Entrar
                    </button> 
                </div>
                <div class="d-flex flex-row-reverse mx-auto mt-4 col-4">
                    <span>Ainda não é nosso cliente?</span> 
                </div>
                <div class="d-flex flex-row-reverse mx-auto mt-1 col-4">
                    <span> Junte-se a <a class="font-normal" href="#">nós</a>.</span>
                </div>
            </div>
        </div>
    </body>
</html>
