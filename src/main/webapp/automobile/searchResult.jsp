<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Risultati Ricerca</title>
</head>
<body>

	<div class="container">

		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Pagina dei Risultati</h3>
		</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Marca</th>
					<th>Modello</th>
					<th>Cilindrata</th>
					<th>Targa</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listaAutomobile }" var="automobileItem">
					<tr>
						<td>${automobileItem.id}</td>
						<td>${automobileItem.marca}</td>
						<td>${automobileItem.modello}</td>
						<td>${automobileItem.cilindrata}</td>
						<td>${automobileItem.targa}</td>
						<td><a
							href="PrepareDettaglioAutomobileServlet?idAutomobile=${automobileItem.id}"
							class="btn btn-info">Dettaglio</a> <a
							href="PrepareModificaAutomobileServlet?idAutomobile=${automobileItem.id}"
							class="btn btn-info">Modifica</a></td>
					</tr>
				</c:forEach>


			</tbody>

		</table>

	</div>
</body>
</html>