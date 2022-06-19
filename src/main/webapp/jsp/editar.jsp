<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">  
    <link rel="stylesheet" href="styles/style.css"/>
    <link rel="icon" href="Images/telephone.png"/>
<title>Agenda - Editar</title>
</head>
<body>
 <h1>Editar Contato</h1>
    <form name="formContato" action="">
    	<table>
    		<tr>
    			<td><input type="text" name="codigo" class="caixaEntrada" id="caixaCodigo" value="<%out.print(request.getAttribute("codigo")); %>" readonly></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="nome" class="caixaEntrada" value="<%out.print(request.getAttribute("nome")); %>"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="telefone" class="caixaEntrada" id="caixaTelefone" value="<%out.print(request.getAttribute("telefone")); %>"></td>
    		</tr>
    		<tr>
    			<td><input type="email" name="email" class="caixaEntrada" value="<%out.print(request.getAttribute("email")); %>"></td>
    		</tr>
    	</table>	
    	<input type="button" value="Salvar" class="BotoesAcesso" onclick="validar()">
    </form>
	<script src="scripts/validador.js"></script>
</body>
</html>