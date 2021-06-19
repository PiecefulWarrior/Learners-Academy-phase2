<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="headers.jsp" />
<html>
<head>
    <title>Assign classes for subjects</title>
    	<style>
body {
  background-color: lightblue;
}
</style>
</head>
<body>
 
<div align="center">
    <h1>Assign subjects for classes</h1>
    <form action="list" method="post">
        Select a Class:&nbsp;
        <select name="classes">
            <c:forEach items="${listClasses}" var="cls">
                <option value="${cls.standard}">${cls.standard}</option>
            </c:forEach>
        </select>
        Select a Subject:&nbsp;
        <select name="subjects">
            <c:forEach items="${listSubjects}" var="sub">
                <option value="${sub.sub_name}">${sub.sub_name}</option>
            </c:forEach>
        </select>
        <br/><br/>
        <input type="submit" value="Assign" />
    </form>
</div>
</body>
</html>