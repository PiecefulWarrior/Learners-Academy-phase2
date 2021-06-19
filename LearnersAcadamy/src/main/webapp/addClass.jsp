<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="headers.jsp" />  
<html>
<head>
	<title>Learners Management Application</title>
	<style>
body {
  background-color: lightblue;
}
</style>
</head>
<body>
	<center>
		<h1>Learners Acadamy
		
		</h1>
        <h2>
        	<a href="newClass.jsp">Add New Class</a>
        	&nbsp;&nbsp;&nbsp;
        	
        </h2>
        
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Classes</h2></caption>
            <tr>
                <th>ID</th>
                <th>Class Names</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="cls" items="${classList}">
                <tr>
                    <td><c:out value="${cls.id}" /></td>
                    <td><c:out value="${cls.standard}" /></td>
                    <td>
                    	
                    	<a href="deleteClass?id=<c:out value='${cls.id}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>
