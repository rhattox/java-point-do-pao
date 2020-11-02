<%-- 
    Document   : adicionar
    Created on : Nov 2, 2020, 5:48:00 PM
    Author     : bcovies
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form method="POST" action='UsuarioController' name="adicionarUsuario">
            <p>Nome</p> <input type="text" name="nome" value="${usuario.nome}" />
            <p>Sobrenome</p> <input type="text" name="sobrenome" value="${usuario.sobrenome}" />
            <p>Email</p> <input type="text" name="email" value="${usuario.email}" />
            <p>Senha</p> <input type="text" name="senha" value="${usuario.senha}" />

            <input type="submit" value="Submit" />
        </form>

    </body>
</html>


