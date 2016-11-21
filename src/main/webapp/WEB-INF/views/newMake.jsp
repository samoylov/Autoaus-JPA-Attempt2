<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>new Make</title>
</head>
<body>

<%@include file="navigation.html" %>

<h1>Make</h1>

<h2>New Make</h2>

<form action="saveMake" method="post">
    <input name="name" placeholder="Make name" autofocus="autofocus">

    <select name="countryID">
        <c:forEach var="country" items="${countries}">
            <option value="${country.id}">
                    ${country.name}
            </option>
        </c:forEach>
    </select>

    <button>save</button>
</form>

<h2>Existing Makes</h2>

<form action="deleteMake" method="post">
    <select size="10" name="id" style="width: 170px;">
        <c:forEach var="make" items="${makes}">
            <option value="${make.id}">
                    ${make.name} (${make.country.name})
            </option>
        </c:forEach>
    </select>
    <br>
    <button>delete</button>
</form>

</body>
</html>
