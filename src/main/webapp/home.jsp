<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accedi</title>
</head>
<body>

<div class="container">
 <%@ include file="header.jsp" %>

	<div class="jumbotron">
      <div class="container">
<!--         <h1 class="display-4">Gestione Garage</h1> -->
        <p> <img alt="" style="height:200px" src="http://biblus.acca.it/wp-content/uploads/2018/02/garage-interrato.jpg"> <a class="btn btn-outline-primary btn-lg" href="${pageContext.request.contextPath}/PrepareSearchGarageServlet" role="button">Gestione Garage &raquo;</a></p>
      </div>
      
    </div>
    <div class="jumbotron">
      <div class="container">
<!--         <h1 class="display-4">Gestione Automobile</h1> -->
        <p> <img alt="" style="height:200px" src="https://www.ferrajoliauto.it/wpa/uploads/fiat-500.jpg">  <a class="btn btn-outline-primary btn-lg" href="${pageContext.request.contextPath}/PrepareSearchAutomobileServlet" role="button">Gestione Automobile &raquo;</a></p>
      </div>
      
    </div>



	 <%@ include file="footer.jsp" %>
</div>

</body>
</html>