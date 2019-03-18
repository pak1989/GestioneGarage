<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettaglio Automobile</title>
</head>
<body>

	<div class="container">

		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Dettaglio</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Azioni</dt>
					<dd class="col-sm-9">
						<a href="PrepareModificaGarageServlet?idGarage=${garageSingolo.id}" class="btn btn-info">Modifica</a>
						<a href="PrepareEliminaGarageServlet?idGarage=${garageSingolo.id}" class="btn btn-danger">Elimina</a>
					</dd>
			</dl>
			<hr>
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9">${garageSingolo.nome}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Descrizione</dt>
				<dd class="col-sm-9">${garageSingolo.descrizione}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Indirizzo</dt>
				<dd class="col-sm-9">${garageSingolo.indirizzo}</dd>
			</dl>
						
			<hr>
			<c:forEach items="${garageSingolo.automobili}" var="elemAuto">
				<dl class="row">
					<dt class="col-sm-3 text-right">Auto id ${elemAuto.id}</dt>
					<dd class="col-sm-9"><a href="PrepareDettaglioAutomobileServlet?idAutomobile=${elemAuto.id}" class="btn btn-info">Dettagli</a>  ${elemAuto.marca} ${elemAuto.modello}</dd>
				</dl>
			</c:forEach>
		
		</div>

	</div>

</body>
</html>