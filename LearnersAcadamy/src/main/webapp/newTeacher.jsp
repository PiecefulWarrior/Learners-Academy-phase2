<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="headers.jsp" />  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update teachers master list</title>
<style>
body {
  background-color: lightblue;
}
</style>
</head>
<body>

<form action="addTeachers">

Enter Name: <input type="text" name="teacher">
<br></br>
Enter Email: <input type="text" name="mail">
<br></br>
<input type="submit" value="Add Teacher">
  
</form>

</body>
</html>