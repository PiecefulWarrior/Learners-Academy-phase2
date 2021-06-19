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
        	<a href="newTeacher.jsp">Add New Teacher</a>
        	&nbsp;&nbsp;&nbsp;
        	
        </h2>
        
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Teachers</h2></caption>
            <tr>
                <th>ID</th>
                <th>Teacher Names</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="teach" items="${teachList}">
                <tr>
                    <td><c:out value="${teach.id}" /></td>
                    <td><c:out value="${teach.teacher_name}" /></td>
                    <td><c:out value="${teach.email}" /></td>
                    <td>
                    	
                    	<a href="deleteTeacher?id=<c:out value='${teach.id}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>
