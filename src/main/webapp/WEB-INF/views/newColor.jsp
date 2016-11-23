<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<html>
<head>
    <title>new Color</title>
</head>
<body>

<%@ include file="navigation.html" %>

<h1>Color</h1>

<h2>New Color</h2>

<sf:form modelAttribute="addColor" action="saveColor" method="post">
    <sf:input path="name" placeholder="color name" autofocus="autofocus"/>
    <button>save</button>
</sf:form>

<h2>Existing Colors</h2>

<form action="deleteColor" method="post">
    <select multiple="multiple" size="10" name="ids">
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
