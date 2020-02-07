<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="false"%>

<html>
<head>
<title>Show Employees</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<h3 style="color: red;"> All Employees</h3>
	<table width=50% border=1">
       <tr>
           <th>EmpId</th>
           <th>Employee Name</th>
           <th>Action</th>
                 </tr>
	<c:forEach items="${employees}" var="value">
            <tr>
                <td>${value.empId}</td>
                <td>${value.empName}</td>
                <td><form action="/delete?id=${value.empId}"  method="post"><input type="submit" value="Delete"/></form></td>
            </tr>
            </c:forEach>
	</table>
</body>
</html>