<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Registration Page
<form:form action="registrationProcess" modelAttribute="UserDTO" method="Post">
<center>
<br/>
<br/><br/><br/>
<br/>
<table>

<tr><td>User Name : </td><td><input type="text" name = "userName" />  </td></tr>
<tr><td>Email : </td><td><input type="text" name = "email" />  </td></tr>
<tr><td>Password : </td><td><input type="text" name = "password" />  </td></tr>
<tr><td><input type="submit" name = "registation" value="Registration" >  </td></tr>
</table>
</center>
</form:form>

 
</body>
</html>