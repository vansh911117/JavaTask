<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table align="center" border="1">
<c:forEach var="i" items="${data }">

<tr>
<form action="update">
         	<td>${i.getId()}<input type="hidden" name="id" value="${i.getId()}"/></td>
         	<td><input type="text" name="name" value="${i.getName()}"/></td>
         		<td><input type="text" name="course" value="${i.getCourse()}"/></td>
         	<td><input type="number" name="fees" value="${i.getFees()}"/></td>
         	<td><input type="submit" value="Update "/></td>
         	</form>
         	<td><a href="delete?id=${i.getId() }">Delete</a></td>
         	
         	</tr>

</c:forEach>

</table>