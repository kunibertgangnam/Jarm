<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

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
	 
