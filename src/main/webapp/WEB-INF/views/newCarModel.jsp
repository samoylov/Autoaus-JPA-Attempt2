<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>new Car Model</title>
</head>
<body>

<%@include file="navigation.html" %>

<h1>Car Model</h1>

<h2>New Car Model</h2>

<form action="saveCarModel" method="post">
    <input name="name" placeholder="Car Model name">

    <select name="makeID" style="min-width: 170px;">
        <c:forEach var="make" items="${makes}">
            <option value="${make.id}">
                    ${make.name}
            </option>
        </c:forEach>
    </select>

    <button>save</button>
</form>

<h2>Existing Car Models</h2>

<form action="deleteCarModel" method="post">
    <select size="10" name="id" style="width: 170px;">
        <c:forEach var="carmodel" items="${carmodels}">
            <option value="${carmodel.id}">
                    ${carmodel.make.name} ${carmodel.name}
            </option>
        </c:forEach>
    </select>
    <br>
    <button>delete</button>
</form>

</body>
</html>
