<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1 style= "background-color: #c0c0c0">Projektinterne Nachrichten</h1>
     <div style= "margin-left: 10px; margin-right: 10px;">
			<c:out value="${nachrichten}"></c:out>
     </div>
	 <div style = "position:absolute; bottom: 0; background-color: gray;"> 
		 <form action="<c:url value='/projects/addMessage.do'/>" method="post">
				<table style= "margin-left: 10px; margin-right: 10px; margin-bottom: 80px;">
					<tr>
						<td style="width:99%">
							<input type = "text" name = "message" placeholder="Eine Nachricht schreiben..." style="width:100%">
						</td>
						<td>
							<input type = "submit" value = "Senden">
						</td>
					</tr>
				</table>
		 </form>
	 </div>
