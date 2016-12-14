<%--
  Created by IntelliJ IDEA.
  User: kosty
  Date: 12/12/2016
  Time: 7:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Home Page</title>
    <%@include file="_styles.html" %>
</head>
<body>
<%@ include file="_header.jsp" %>
<h1 id="header">404 page. Hello</h1>

<script>
    $("#header").onmouseover(function () {
        document.getElementById('header').style.backgroundColor = 'red';
    });
    $("#header").onmouseout(function () {
        document.getElementById('header').style.backgroundColor = 'white';
    });
</script>

</body>
</html>
