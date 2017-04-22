

<%@page import="controle.Trabalho"%>
<%@page import="java.util.List"%>
<%@page import="controle.ListaDeTrabalhos"%>
<%@page import="Dal.ModuloConexao"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JSP Page</title>
<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<script src="Bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="Bootstrap/js/jquery.js" type="text/javascript"></script>
<script src="js/trabalhos.js" type="text/javascript"></script>
<link href="css/trabalhos.css" rel="stylesheet" type="text/css" />
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
        <a class="navbar-brand" href="#">FEBAC</a>
    </div>
    <div class="collapse navbar-collapse" id="navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><b>Ajuda</b></a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user"></span><b> Usuário</b></a>
          <ul class="dropdown-menu">
             <li><a href="#">Perfil</a></li>
            <li><a href="#">Sair</a></li>
        </ul>
    </li>
</ul>
</div><!-- /.navbar-collapse -->
</div><!-- /.container-fluid -->
</nav>
	
	<div class="container">
	<div class="panel panel-default">
   <div class="panel-heading">
        <h1 class="panel-title">TCC's e Monografias</h1>
    </div>
        <div class="panel-body">
				<div class="form-horizontal">

					<form action="./trabalhos" method="GET">
						<!-- Pesquisa -->
						<div class="col-sm-3">
							<label for="select">Pesquisa</label>
							<div class="form-group ">
								<select class="form-control" name="modalidade" >
									<option value="TCC">TCC</option>
									<option value="Monografia">Monografia</option>
								</select>
							</div>
						</div>

						<div class="col-sm-3">
							<label for="select">Curso</label>
							<div class="form-group ">
								<select class="form-control" name="curso">
									<option value="Sistemas para Internet">Sistemas para Internet</option>
									<option value="Enfermagem">Enfermagem</option>
									<option value="Administracao">Administração</option>
									<option value="Farmacia">Farmacia</option>
									<option value="Marketing">Marketing</option>
								</select>
							</div>
						</div>


						<div class="radio-inline">
							<input type="radio" name="pesquisaPor" value="titulo" checked>Titulo
						</div>

						<div class="radio-inline">
							<input type="radio" name="pesquisaPor" value="autor">Autor
						</div>

						<div class="input-group">
							<div class="input-group-btn">
								<button class="btn btn-sm btn-info" type="reset" >
									<span class="glyphicon glyphicon-erase"></span>
								</button>
							</div>
							<!-- input text -->
							<input class="form-control input-sm" type="text" name="txtBusca" id="txtBusca" >
							<div class="input-group-btn">
								<button class="btn btn-sm btn-info" name="opcao" value="Buscar">Buscar</button>
							</div>
						</div>

					</form>
				</div>
			</div>
		</div>
		</div>
		
		<div class="container">
			<form action="./trabalhos" method="get">
				<table class="table table-responsive table-striped table-hover table-bordered table-condensed">
					<thead>
						<th><span class="glyphicon glyphicon-trash"></span></th>
						<th class="text-center">Registro</th>
						<th class="text-center">Titulo</th>
						<th class="text-center">Autor</th>
						<th class="text-center">Curso</th>
						<th class="text-center">Tipo</th>
						<th><span class="glyphicon glyphicon-edit "></span></th>
					</thead>
					<tbody>

	
    				<%
    				
				
					List<Trabalho> lista = (List<Trabalho>) request.getAttribute("lista");
					
					if(lista != null){
    				for(Trabalho item: lista){ 
    				%>  				
						<tr class="text-center">
							<td><input type="checkbox" name="check"value="<%=item.getId() %>"></td>
							<td><%=item.getRegistro()%></td>
							<td><%=item.getTitulo() %></td>
							<td><%=item.getAutor() %></td>
							<td><%=item.getCurso() %></td>
							<td><%=item.getTipo() %></td>							
							<td><button class="btn btn-link"><a href="">Editar</a></button></td>							
						</tr>
					<%}
    				}else{
    					out.print("null");
    				}
    				%>

					</tbody>
				</table>
				<input class="btn btn-sm btn-danger" type="submit" name="opcao"
					value="Remover" />
			</form>
		</div>
	
	
<script src="Bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="Bootstrap/js/jquery.js" type="text/javascript"></script>
</body>
</html>
