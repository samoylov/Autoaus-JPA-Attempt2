<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>new Engine</title>
</head>
<body>

<%@include file="navigation.html"%>

<h1>New Engine</h1>

<form action="saveEngine" method="post">
    <input name="name" placeholder="Engine name">
    <br>
    <button>save</button>
</form>

<h2>Existing Engines</h2>

<form action="deleteEngine" method="post">
    <select size="10" name="id" style="width: 170px;">
        <c:forEach var="engine" items="${engines}">
            <option value="${engine.id}">
                    ${engine.name}
            </option>
        </c:forEach>
    </select>
    <br>
    <button>delete</button>
</form>


</body>
</html>
