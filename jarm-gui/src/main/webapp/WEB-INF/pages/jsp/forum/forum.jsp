<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Test Forum </title>
  </head>
  <body>
  <h1 style= "background-color: #c0c0c0">Projektinternes Forum</h1>
     <div style= "margin-left: 10px; margin-right: 10px;">
		<table>
			<c:forEach var="entry" items="${nachrichten}">
			  <tr>
			  	  <td><font color=red><c:out value="${entry.key}"/></font>:</td>
			  	  <td> <c:out value="${entry.value}"/></td>
			  </tr>
			</c:forEach>
		</table>
     </div>
	 <div style = "position:absolute; bottom: 0; background-color: gray;"> 
		 <form action="<c:url value='/forum.do'/>" method="post">
				<table style= "margin-left: 10px; margin-right: 10px; margin-bottom: 80px;">
					<tr>
						<td style="width:99%">
							<input type = "text" name = "nachricht" placeholder="Eine Nachricht schreiben..." style="width:100%">
						</td>
						<td>
							<input type = "submit" value = "Senden">
						</td>
					</tr>
				</table>
		 </form>
	 </div>
  </body>
</html>
