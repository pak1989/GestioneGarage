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
						<a href="PrepareModificaAutomobileServlet?idAutomobile=${automobileSingola.id}" class="btn btn-info">Modifica</a>
						<a href="PrepareEliminaAutomobileServlet?idAutomobile=${automobileSingola.id}" class="btn btn-danger">Elimina</a>
					</dd>
			</dl>
			<hr>
			<dl class="row">
				<dt class="col-sm-3 text-right">Marca</dt>
				<dd class="col-sm-9">${automobileSingola.marca}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Modello</dt>
				<dd class="col-sm-9">${automobileSingola.modello}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cilindrata</dt>
				<dd class="col-sm-9">${automobileSingola.cilindrata}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Targa</dt>
				<dd class="col-sm-9">${automobileSingola.targa}</dd>
			</dl>
						
			<hr>
			<dl class="row">
				<dt class="col-sm-3 text-right">Garage</dt>
				<dd class="col-sm-9"><a href="PrepareDettaglioGarageServlet?idGarage=${automobileSingola.garage.id}" class="btn btn-info">Dettagli</a>  ${automobileSingola.garage.nome} - ${automobileSingola.garage.descrizione} - ${automobileSingola.garage.indirizzo}</dd>
			</dl>
			
		</div>

	</div>

</body>
</html>