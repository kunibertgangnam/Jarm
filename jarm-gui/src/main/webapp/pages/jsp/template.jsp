<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Jarm</title>
  </head>
  <body> 
<div id="oben">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <span class="navbar-brand mb-0 h1">Jarm</span>
	  <div class="collapse navbar-collapse" id="navbarNavDropdown">
		<ul class="nav nav-tabs">
		  <li class="nav-item active">
			<a class="nav-link" href="<c:url value='/home.do'/>">Home <span class="sr-only">(current)</span></a>
		  </li>
		  <c:if test="${eingeloggt == null}">
			  <li class="nav-item">
				<a class="nav-link" href="<c:url value='/login.do'/>">Login</a>
			  </li>
			  <li class="nav-item">
				<a class="nav-link" href="<c:url value='/registrieren.do'/>">Registrieren</a>
			  </li>
		  </c:if>
		  <c:if test="${eingeloggt != null}">
			  <li class="nav-item">
				<a class="nav-link" href="<c:url value='/login.do?logout=true"'/>">Ausloggen</a>
			  </li>
		  </c:if>
		</ul>
		</div>
	</nav>
</div>

<div id="inhalt">
    <c:import url="${url}"></c:import>
</div>
</body>
</html>