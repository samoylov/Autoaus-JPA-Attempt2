<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>new Country</title>
    <%@include file="_styles.html" %>
</head>
<body>
<%@include file="_header.jsp" %>

<h1>Country</h1>

<h2>New Country</h2>
<form:form action="saveCountry" method="post">
    <input name="name" placeholder="country name" autofocus="autofocus">
    <button>save</button>
</form:form>

<h2>Existing Countries</h2>
<form:form action="deleteCountry" method="post">
    <select size="10" name="id" >
        <c:forEach var="country" items="${countries}">
            <option value="${country.id}">
                    ${country.name}
            </option>
        </c:forEach>
    </select>
    <br>
    <button>delete</button>
</form:form>

</body>
</html>
