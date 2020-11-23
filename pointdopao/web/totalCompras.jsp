<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
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
    <title>Point do pão</title>
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
        <c:if test = "${autenticado == false}">
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
                <li class="nav-item">
                    <a class="nav-link" href="javascript:navegarParaPagina('acesso','gestao');">Produtos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Vendas</a>
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
    <h3 class="mt-4 mb-4 titulos">Total de vendas </h3>
    <table class="table">
        <thead class="cor-tabela-header">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Nome do Produto</th>
            <th scope="col">Quantidade</th>
            <th scope="col">Preço</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listaProdutos}" var="produto" varStatus="status">
            <tr>
                <td>${produto.id}</td>
                <td>${produto.nome}</td>
                <td>${produto.quantidade}</td>
                <td>R$ ${produto.preco}</td>             
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <% 
        String url = "jdbc:postgresql://localhost:12002/pointdopao";
        String user = "admin";
        String senha = "admin";
        String select = "select imagem from produto where id=1";
        try{
            /* TODO output your page here. You may use following sample code. */
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(url,user,senha);
            PreparedStatement stm = c.prepareStatement(select);
            //stm.setInt(1,1);
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                
                byte[] rb = new byte[30000];
                int read = 0;
                InputStream readImg = rs.getBinaryStream(1);
                OutputStream os = response.getOutputStream();
                while ((read = readImg.read(rb)) != -1) {
                    os.write(rb,0,read);
                }
                os.flush();
                os.close();
            }
            //out.print("Deu certo");
            
            rs.close();
            stm.close();
            c.close();
        }
        catch(IOException | ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    %>
</section>

</body>
</html>
