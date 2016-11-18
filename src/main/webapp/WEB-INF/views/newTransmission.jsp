<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>new Transmission</title>
</head>
<body>

<%@include file="navigation.html"%>

<h1>Transmission</h1>

<h2>New Transmission</h2>

<form action="saveTransmission" method="post">
    <input name="name" placeholder="Transmission name">
    <br>
    <button>save</button>
</form>

<h2>Existing Transmissions</h2>

<form action="deleteTransmission" method="post">
    <select size="10" name="id" style="width: 170px;">
        <c:forEach var="transmission" items="${transmissions}">
            <option value="${transmission.id}">
                    ${transmission.name}
            </option>
        </c:forEach>
    </select>
    <br>
    <button>delete</button>
</form>


</body>
</html>
