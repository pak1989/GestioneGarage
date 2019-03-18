<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jqueryUI/jquery-ui.min.css" />
<style>
.ui-autocomplete-loading {
	background: white url("img/anim_16x16.gif") right center no-repeat;
}
</style>
</head>
<body>

<div class="container">

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Pagina di Ricerca</h3>
	</div>
	  	<form class="form-horizontal" action="ExecuteSearchAutomobileServlet" method="post">
	      	<div class="form-group">
				<label class="control-label col-sm-2" for="marcaInputId">Marca:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="marcaInputId"
						name="marcaInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="modelloInputId">Modello:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="modelloInputId"
						name="modelloInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cilindrataInputId">Cilindrata:</label>
				<div class="col-sm-4">
					<input class="form-control" type="number" id="cilindrataInputId"
						name="cilindrataInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="garageId">Garage:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="garageInputId"
						name="garageInput">
					<input type="hidden" name="garageId" id="garageId">
				</div>
			</div>		
  			
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Effetua Ricerca</button>
		        <a href="PrepareInsertAutomobileServlet" class="btn btn-primary btn-md">Inserisci Nuovo Elemento</a>
		      </div>
		    </div>		
			
			<script>
				$( "#garageInputId" ).autocomplete({
					 source: function(request, response) {
					        $.ajax({
					            url: "SearchGarageAjaxServlet",
					            datatype: "json",
					            data: {
					                term: request.term,   
					            },
					            success: function(data) {
					                response($.map(data, function(item) {
					                    return {
						                    label: item.label,
						                    value: item.value
					                    }
					                }))
					            }
					        })
					    },
					//quando seleziono la voce nel campo deve valorizzarsi la descrizione
				    focus: function(event, ui) {
				        $("#garageInputId").val(ui.item.label)
				        return false
				    },
				    minLength: 2,
				    //quando seleziono la voce nel campo hidden deve valorizzarsi l'id
				    select: function( event, ui ) {
				    	$('#garageId').val(ui.item.value);
				    	console.log($('#garageId').val())
				        return false;
				    },
				});
			</script>
		</form>
  			
		    <div class="form-group">        
		      <div class="col-sm-offset-4 col-sm-10">
		        <a href="PrepareTestSpringDataAutomobileServlet" class="btn btn-warning btn-md btn-block">Test Spring Data</a>
		      </div>
		    </div>
		</form>
		
    </div><!-- /.container -->



</body>
</html>