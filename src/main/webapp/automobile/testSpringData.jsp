<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca</title>
</head>
<body>

	<div class="container">

		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Test per query Spring Data per Automobile</h3>
		</div>
		
		
		<%-- CERCA PER NOME FINDBYNOME --%>
		<form class="form-inline" action="ExecuteTestSpringDataAutomobileServlet" method="post">
			<div class="form-group mx-sm-3 mb-2">
				<input
					type="text" class="form-control" id="queryInput" name="queryInput"
					placeholder="findByMarca">
			</div>
			<input type="hidden" name="codop" value="findByMarca">
			<button type="submit" class="btn btn-primary mb-2">Esegui Test!!!</button>
		</form>
		
		
		<%-- CERCA PER ETA MAGGIORE DI -  FINDBYETAGREATERTHAN --%>
		<form class="form-inline" action="ExecuteTestSpringDataAutomobileServlet" method="post">
			<div class="form-group mx-sm-3 mb-2">
				<input
					type="text" class="form-control" id="queryInput2" name="queryInput"
					placeholder="findByCilindrataGreaterThan">
			</div>
			<input type="hidden" name="codop" value="findByCilindrataGreaterThan">
			<button type="submit" class="btn btn-primary mb-2">Esegui Test!!!</button>
		</form>
		
		
		<%-- CERCA PER NOME ED ETA FINDBYNOMEANDETA --%>
		<form class="form-inline" action="ExecuteTestSpringDataAutomobileServlet" method="post">
			<div class="form-group mx-sm-3 mb-2">
				<input
					type="text" class="form-control" id="queryInput3" name="queryInput"
					placeholder="modello">
				<input
					type="text" class="form-control" id="queryInput4" name="queryInputCilindrata"
					placeholder="cilindrata">
			</div>
			<input type="hidden" name="codop" value="findByModelloAndCilindrata">
			<button type="submit" class="btn btn-primary mb-2">Esegui Test!!!</button>
		</form>
		
		
		<%-- CERCA PER  ETA ORDINANDO NOME DESC - FINDBYETAORDERBYNOMEDESC --%>
		<form class="form-inline" action="ExecuteTestSpringDataAutomobileServlet" method="post">
			<div class="form-group mx-sm-3 mb-2">
				<input
					type="text" class="form-control" id="queryInput5" name="queryInputCilindrata"
					placeholder="cilindrata ordertby marca desc">
			</div>
			<input type="hidden" name="codop" value="findByCilindrataOrderByMarcaDesc">
			<button type="submit" class="btn btn-primary mb-2">Esegui Test!!!</button>
		</form>
		
		
		<%-- CERCA  PER NOEM CHE INIZIA CON - FINDBYNOMESTARTSWITH --%>
		<form class="form-inline" action="ExecuteTestSpringDataAutomobileServlet" method="post">
			<div class="form-group mx-sm-3 mb-2">
				<input
					type="text" class="form-control" id="queryInput6" name="queryInput"
					placeholder="marca">
			</div>
			<input type="hidden" name="codop" value="findByMarcaStartsWith">
			<button type="submit" class="btn btn-primary mb-2">Esegui Test!!!</button>
		</form>

		<%-- CERCA  PER NOEM CHE INIZIA CON - FINDBYNOMESTARTSWITH --%>
		<form class="form-inline" action="ExecuteTestSpringDataAutomobileServlet" method="post">
			<div class="form-group mx-sm-3 mb-2">
				<input
					type="text" class="form-control" id="queryInput7" name="queryInput"
					placeholder="id garage">
			</div>
			<input type="hidden" name="codop" value="findByGarageId">
			<button type="submit" class="btn btn-primary mb-2">Esegui Test!!!</button>
		</form>


	</div>
	<!-- /.container -->



</body>
</html>