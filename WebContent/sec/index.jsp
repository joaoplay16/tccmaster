
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSP Page</title>
    <link href="../Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script src="../Bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="../Bootstrap/js/jquery.js" type="text/javascript"></script>
    <link href="../css/index.css" rel="stylesheet" type="text/css"/>
</head>
<body>

    <nav class="navbar navbar-inverse">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-1" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="http://febac.edu.br" target="_blank">FEBAC</a>
    </div>
    <div class="collapse navbar-collapse" id="navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Ajuda</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
          <span class="glyphicon glyphicon-user">
          </span><b> ${sessionScope.usuario.getNome()}</b>
          <ul class="dropdown-menu">
             <li><a href="#">Perfil</a></li>
            <li><a href="../login?acao=Sair">Sair</a></li>
        </ul>
    </li>
</ul>
</div><!-- /.navbar-collapse -->
</div><!-- /.container-fluid -->
</nav>


<div class="col-md-3 col-sm-3 col-lg-2  sidebar">    
        <ul class="nav nav-pills nav-stacked">
            <li ><a href="../trabalhos?txtBusca=" target="_blank"><i class="glyphicon glyphicon-file"></i> Trabalhos</a></li>
            <li><a href="#"><i class=" glyphicon glyphicon-list-alt"></i> Normas ABNT</a></li>
            <li><a href="#"><i class="glyphicon glyphicon-time"></i> Histórico</a></li>
        </ul>    
</div>

<div class="row">
<div class="col-md-8  col-sm-7 col-lg-7">
    <div class="row">
      <div class="col-lg-12">
        <h3 class="page-header">Cadastro de Artigos e Monografias</h3>
      </div>
        </div>

<div class="panel panel-default">
   <div class="panel-heading">
        <h2 class="panel-title">Dados cadastrais</h2>
    </div>
        <div class="panel-body">
            <div class="form-group">
                <form  action="../ServletIndex" method="GET">
					
					<row>
						<div class="col-md-3">
							<label for="modalidade" class="control-label ">Modalidade</label>
		                    <select class="form-control" name="modalidade" >
									<option value="TCC">TCC</option>
									<option value="Monografia">Monografia</option>
							</select>
						</div>
						<div class="col-md-9">
							<label for="titulo" class="control-label">Titulo</label>
				            <input class="form-control" type="text" id="titulo" name="titulo" value="" autofocus>
						</div>
					</row>


                    <row>
                   		<div class="col-md-12">
		                    <label for="autor" class="control-label">Autor</label>
		                    <input class="form-control" type="text" id="autor" name="autor" value="">
                    	</div>
					<row>
					
					<row>
	                   	<div class="col-md-12">
							<label for="select">Curso</label>
							<div class="form-group ">
								<select class="form-control" name="curso">
									<option value="Sistemas para Internet">Sistemas para Internet</option>
									<option value="Enfermagem">Enfermagem</option>
									<option value="Administracao">Administração</option>
									<option value="Farmacia">Farmacia</option>
								</select>
							</div>
						</div>
						
					</row>
					<br>
					
					<row>
		                <div class="col-md-12">
		                    <div class="btn-group">
		                        <input class="btn btn-md btn-success" type="submit" name="acao" value="Salvar">
		                        <input class="btn btn-md btn-default" type="reset" name="acao" value="Limpar">
		                    </div><br><br>
	                    </div>
					</row>					
				
                </form>
            </div>
        </div>
   </div>
</div>   
</div>
<div class="row">
    <div class="container text-center">
        <footer>
            <div style="position: relative !important;">Desenvolvido por <a href="#" target="_blank">Status200</a><br/>
            <a href="#" target="_blank" style="color: #333;">
             &copy; 2017. Todos os direitos reservados 
             </a>
             </div>
        </footer>
    </div>
</div>

<script src="../Bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../Bootstrap/js/jquery.js" type="text/javascript"/></script>
</body>  
</html>
