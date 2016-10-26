<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@page import="java.util.*,java.text.*,entity.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<%@include file="header.jsp" %><!-- 插指令 -->
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Employee List
					</h1>
					<form action="search.do" method="post">
						<p id="find"><input type="submit" name="searchB" value="search"><input name="search" ></p>
					</form>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								Name
							</td>
							<td>
								Salary
							</td>
							<td>
								Age
							</td>
							<td>
								Operation
							</td>
						</tr>
								<c:forEach items="${employees}" var="e" varStatus="i">
								<tr class="row${i.index%2+1}">
									<td>
										${e.id}
									</td>
									<td>
										${e.name}
									</td>
									<td>
										${e.salary}
									</td>
									<td>
										${e.age}
									</td>
									<td>
										<a href="del.do?id=${e.id} onclick="return confirm('Do you want to delete ${e.name}?');">delete</a>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="load.do?id=${e.id}">update</a>
									</td>
								</tr>
								</c:forEach>
								
											
					</table>
					<p>
						<input type="button" class="button" value="Add Employee" onclick="location='addEmp.jsp'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>