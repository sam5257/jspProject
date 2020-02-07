<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Employee</title>
</head>
<jsp:include page="menu.jsp" />
<body>
	<h3 style="color: red;">Update Employee</h3>

	<div id="addEmployee">
		<form:form action="/update" method="post" modelAttribute="e">
			<p>
				<label> Employee Id</label>
				<form:input path="empId" value="${employee.empId}"/>
			</p>
			<p>
				<label> Name</label>
				<form:input path="empName" value="${employee.empName}"/>
			</p>			
			<input type="SUBMIT" value="Submit" />
		</form:form>
	</div>
</body>
</html>