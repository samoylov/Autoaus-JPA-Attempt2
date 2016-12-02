<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>new Transmission</title>
    <%@include file="_styles.html" %>
</head>
<body>
<%@include file="_header.jsp" %>

<h1>Transmission</h1>

<h2>New Transmission</h2>

<form action="saveTransmission" method="post">
    <input name="name" placeholder="Transmission name" autofocus="autofocus">
    <button>save</button>
</form>

<h2>Existing Transmissions</h2>

<form action="deleteTransmission" method="post">
    <select size="10" name="id" >
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
