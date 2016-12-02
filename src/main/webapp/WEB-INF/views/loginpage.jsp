<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<html>
<head>
    <title>Login Page</title>
    <%@include file="_styles.html" %>
</head>
<body>
<%@ include file="_header.html" %>

<h1>Login</h1>

<sf:form action="loginprocesing" method="post">
    <input name="username" type="text" placeholder="login"/>
    <input name="password" type="password" placeholder="password"/>
    <button>login</button>
</sf:form>

</body>
</html>
