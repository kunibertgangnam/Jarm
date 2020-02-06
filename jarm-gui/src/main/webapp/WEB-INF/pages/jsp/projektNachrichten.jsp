<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1 style= "position:absolute; display:table-cell; vertical-align:middle; width:100%; bottom: 401px; background-color: #c0c0c0;">Projektinterne Nachrichten</h1>
     <div style= "position:absolute; display:table-cell; vertical-align:middle; width:500%; bottom: 400px;">
			<c:out value="${nachrichten}"></c:out>
     </div>
	 <div style = "position:absolute; display:table-cell; vertical-align:middle; width:100%; bottom: 50px; background-color: #c0c0c0;"> 
		 <form action="<c:url value='/projects/addMessage.do'/>" method="post">
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
