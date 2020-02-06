<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1 style = "padding: 5px; background-color: #c0c0c0;">Projektinterne Nachrichten
<i style="font-size:24px" class="fa">&#xf0e6;</i></h1>
     <div style = "padding: 5px; background-color: #eefafd;">
     		<c:forEach var="thisMessage" items="${nachrichten}">
     			<div><h4>Verfasser: <c:out value="${thisMessage.author.name}" /></h4> -  <c:out value="${thisMessage.message}" /></div>
     		</c:forEach>
     </div>
	 <div style = "padding: 5px; background-color: #c0c0c0;"> 
		 <form action="<c:url value='/projects/addMessage.do'/>" method="post">
		 		<input type="hidden" name="id" value="<c:out value='${currentProject.id}'/>" />
				<table style= "margin-left: 10px; margin-right: 10px; margin-bottom: 5px;">
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
