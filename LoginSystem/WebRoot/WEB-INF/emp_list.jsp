<%@page pageEncoding="utf-8" contentType = "text/html;charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head></head>
	<body style="font-size:30px;">
		Employee List
		<table>
			<tr>
				<td>id</td>
				<td>name</td>
				<td>salary</td>
				<td>age</td>			
			</tr>
			<c:forEach items="${emplist}" var="emp">
				<tr>
					<td>${emp.id}</td>
					<td>${emp.name}</td>
					<td>${emp.salary}</td>
					<td>${emp.age}</td>
				</tr>
			</c:forEach>
		</table>
		current page：${currentPage} /${totalPage}<br/>
		<a href="emp_list.do?page=1">The First Page</a>
		<c:choose>
			<c:when test="${currentPage>1}">
				<a href="emp_list.do?page=${currentPage-1}">Previous</a>
			</c:when>
		<c:otherwise>
			<a>Previous</a>
		</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${currentPage<totalPage}">
				<a href="emp_list.do?page=${currentPage+1}">Next</a>	
			</c:when>
			<c:otherwise>
				<a>Next</a>
			</c:otherwise>
		</c:choose>
		<a href="emp_list.do?page=${totalPage}">The Last Page</a>
		<form action="emp_list.do" method="get">
		<input type="text" name="page">
		<input type="submit" value="go">
		</form>
	</body>
</html>		