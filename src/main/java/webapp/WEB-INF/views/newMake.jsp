<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>new Make</title>
    <%@include file="_styles.html" %>
</head>
<body>
<%@include file="_header.jsp" %>

<h1>Make</h1>

<h2>New Make</h2>

<form:form action="saveMake" method="post">
    <input name="name" placeholder="Make name" autofocus="autofocus">

    <select name="countryID">
        <c:forEach var="country" items="${countries}">
            <option value="${country.id}">
                    ${country.name}
            </option>
        </c:forEach>
    </select>

    <button>save</button>
</form:form>

<h2>Existing Makes</h2>

<form:form action="deleteMake" method="post">
    <select size="10" name="id" >
        <c:forEach var="make" items="${makes}">
            <option value="${make.id}">
                    ${make.name} (${make.country.name})
            </option>
        </c:forEach>
    </select>
    <br>
    <button>delete</button>
</form:form>

</body>
</html>
