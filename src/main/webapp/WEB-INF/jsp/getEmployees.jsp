<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="false"%>

<html>
<head>
<title>Show Employees</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	
	<table width=50% border=1 ">
       <tr>
           <th>EmpId</th>
           <th>Employee Name</th>
                 </tr>
	<c:forEach items="${employees}" var="value">
            <tr>
                <td>${value.empId}</td>
                <td>${value.empName}</td>
            </tr>
            </c:forEach>
	</table>
</body>
</html>