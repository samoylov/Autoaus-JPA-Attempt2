<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>new Country</title>
</head>
<body>

<%@include file="navigation.html" %>

<h1>Country</h1>

<h2>New Country</h2>
<form action="saveCountry" method="post">
    <input name="name" placeholder="country name">
    <br>
    <button>save</button>
</form>

<h2>Existing Countries</h2>
<form action="deleteCountry" method="post">
    <select size="10" name="id" style="width: 170px;">
        <c:forEach var="country" items="${countries}">
            <option value="${country.id}">
                    ${country.name}
            </option>
        </c:forEach>
    </select>
    <br>
    <button>delete</button>
</form>

</body>
</html>
