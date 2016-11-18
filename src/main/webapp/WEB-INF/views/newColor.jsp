<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>new Color</title>
</head>
<body>

<%@include file="navigation.html" %>

<h1>Color</h1>

<h2>New Color</h2>

<form action="saveColor" method="post">
    <input name="name" placeholder="color name">
    <button>save</button>
</form>

<h2>Existing Colors</h2>

<form action="deleteColor" method="post">
    <select size="10" name="id" style="width: 170px;">
        <c:forEach var="color" items="${colors}">
            <option value="${color.id}">
                    ${color.name}
            </option>
        </c:forEach>
    </select>
    <br>
    <button>delete</button>
</form>
</body>
</html>
