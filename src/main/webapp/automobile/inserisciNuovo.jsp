<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci Nuova Automobile</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/jqueryUI/jquery-ui.min.css" />
<style>
.ui-autocomplete-loading {
	background: white url("img/anim_16x16.gif") right center no-repeat;
}
</style>
</head>
<body>

	<div class="container">

		<%@ include file="../header.jsp"%>
		

		<div class="page-header">
			<h3>Pagina di Inserimento Auto</h3>
		</div>
		
		<c:forEach var="messaggioItem" items="${messaggiErrore}">
			<div class="alert alert-danger" role="alert">
			  ${messaggioItem}
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
		</c:forEach>
		

		<form id="insertForm" class="form-horizontal" action="ExecuteInsertAutomobileServlet"
			method="post">
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="marcaInput">Marca:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="marcaInput"
						name="marcaInput" value="${automobileDTO.marca}">
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="modelloInput">Modello:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="modelloInput"
						name="modelloInput" value="${automobileDTO.modello}">
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="cilindrataInput">Cilindrata:</label>
				<div class="col-sm-4">
					<input class="form-control" type="number" id="cilindrataInput"
						name="cilindrataInput" value="${automobileDTO.cilindrata}">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="targaInput">Targa:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="targaInput"
						name="targaInput" value="${automobileDTO.targa}">
				</div>
			</div>
		
			<div class="form-group">
				<label class="control-label col-sm-2" for="garageId">Garage:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="garageInputId"
						name="garageInput" value="${automobileDTO.garage.nome}">
					<input type="hidden" name="garageId" id="garageId" value="${automobileDTO.garage.id}">
				</div>
			</div>


			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Effettua
						Inserimento</button>
				</div>
			</div>
			
			<%-- FUNZIONE JQUERY UI CON AJAX PER AUTOCOMPLETE --%>
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
			
	<script type="text/javascript">

		$( document ).ready( function () {
			$( "#insertForm" ).validate( {
				rules: {
					marcaInput: "required",
					modelloInput: "required",
					cilindrataInput: "required",
					targaInput: {
						    required: true,
						    minlength: 7,
						    maxlength: 7
					},
					garageInput: "required"
					
				},
				messages: {
					marcaInput: "Inserisci una marca",
					modelloInput: "Inserisci una modello",
					cilindrataInput: "Inserisci una cilindrata",
					targaInput: {
					    required: "Inserisci una targa italiana valida  (es. AB123ZX)",
					    minlength: "La targa deve essere di 7 caratteri",
					    maxlength: "La targa deve essere di 7 caratteri"
					},
					garageInput: "Seleziona un garage"
				},
				errorElement: "em",
				errorPlacement: function ( error, element ) {
					// Add the `help-block` class to the error element
					error.addClass( "help-block" );
					element.parents( ".col-sm-5" ).addClass( "has-feedback" );
					if ( element.prop( "type" ) === "checkbox" ) {
						error.insertAfter( element.parent( "label" ) );
					} else {
						error.insertAfter( element );
					}
					if ( !element.next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element );
					}
				},
				success: function ( label, element ) {
					// Add the span element, if doesn't exists, and apply the icon classes to it.
					if ( !$( element ).next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-ok form-control-feedback'></span>" ).insertAfter( $( element ) );
					}
				},
				highlight: function ( element, errorClass, validClass ) {
					$( element ).parents( ".col-sm-5" ).addClass( "has-error" ).removeClass( "has-success" );
					$( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" );
				},
				unhighlight: function ( element, errorClass, validClass ) {
					$( element ).parents( ".col-sm-5" ).addClass( "has-success" ).removeClass( "has-error" );
					$( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" );
				}
			} );
		} );
	</script>
			
			
			
		</form>

	</div>
	<!-- /.container -->



</body>


</html>