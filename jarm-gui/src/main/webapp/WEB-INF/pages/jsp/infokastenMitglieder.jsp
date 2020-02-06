<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  


<c:if test="${imProjekt != null}">
	<div
		style="float: right; width: 15%; margin: 10px; color: black; background-color: #c0c0c0; border-color: #ff0000; border-style: solid; border-width: thin; text-align: center;">
		<h3>Mitglieder des Projekts</h3>
		<table>
			<c:forEach var="eintrag" items="${mitglieder}">
			  <tr>
			  	  <td><c:out value="${eintrag}"/></td>
			  </tr>
			</c:forEach>
		</table>
	</div>
</c:if>