<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="Model.ContatoBean"%>
    <%@ page import="java.util.ArrayList"%>
    <%
    	ArrayList<ContatoBean> lista = (ArrayList<ContatoBean>) request.getAttribute("contatos");
   		
    %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/style.css"/>
    <link rel="icon" href="Images/telephone.png"/>
	<title>Agenda - Contatos</title>
</head>
<body>
	<h1>Agenda de Contatos</h1>
	<a href="pages/novoContato.html" class="BotoesAcesso">Novo Contato</a>
	<table id="tabelaContatos">
		<thead>
			<tr>
				<th>Código</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>E-mail</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<% for(int i = 0; i < lista.size(); i++) { %>
				<tr>
					<td><%=lista.get(i).getCodigo()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getTelefone()%></td>
					<td><%=lista.get(i).getEmail()%></td>
					<td><a href="editarBD?con_codigo=<%=lista.get(i).getCodigo() %>" class="BotoesAcesso">Editar</a></td>
				</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>