<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
    <title>new Car Model</title>
    <%@include file="_styles.html" %>
</head>
<body>
<%@include file="_header.html" %>

<h1>Car Model</h1>

<h2>New Car Model</h2>

<sf:form modelAttribute="carModel" action="saveCarModel" method="post">
    <sf:select path="make" name="makeID" items="${makes}" itemValue="id" itemLabel="name"/>
    <sf:input path="name"/>
    <button>save</button>
</sf:form>

<h2>Existing Car Models</h2>

<form action="deleteCarModel" method="post">
    <select size="10" name="id">
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
