<%-- 
    Document   : j
    Created on : 30/03/2017, 19:23:09
    Author     : FEBAC
    --%>

    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Autenticação</title>
        <link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="Bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="Bootstrap/js/jquery.js" type="text/javascript"></script>
        <link href="css/signin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    
<nav class="navbar navbar-inverse navbar-fixed">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="#">FEBAC</a>
</div>
    <div class="collapse navbar-collapse" id="navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Ajuda</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user"></span> Milena</a>
          <ul class="dropdown-menu">
             <li><a href="#">Perfil</a></li>
            <li><a href="#">Sair</a></li>
        </ul>
    </li>
</ul>
</div><!-- /.navbar-collapse -->
</div><!-- /.container-fluid -->
</nav>

     <div class="view">
        <!--Intro content-->
        <div class="full-bg-img flex-center">
           <div class="container">
            <form class="form-signin" action="./login" method="POST">
                <h2 class="form-signin-heading">Login</h2>
                <label for="usuario" class="sr-only">Usuário</label>
                <input class="form-control" type="text" name="usuario" placeholder="Usuário">
                <label for="senha" class="sr-only">Senha</label>
                <input class="form-control" type="password" name="senha" placeholder="Senha">
                <div class="checkbox">
                  <label>
                  <input type="checkbox" value="remember-me"> <b>Lembrar senha</b>
                </label>
            </div>
            <input type="submit" class="btn btn-lg btn-primary btn-block" name="acao" value="Entrar"/>
        </form>
    </div>
</div>
</div>


<script src="Bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="Bootstrap/js/jquery.js" type="text/javascript"></script>
</body>
</html>
