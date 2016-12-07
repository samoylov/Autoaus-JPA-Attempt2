<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>new Color</title>
    <%@include file="_styles.html" %>
</head>
<body>
<%@ include file="_header.jsp" %>

<h1>Color</h1>

<h2>New Color</h2>

<form:form modelAttribute="addColor" action="saveColor" method="post">
    <form:input path="name" placeholder="color name" autofocus="autofocus"/>
    <button>save</button>
</form:form>

<h2>Existing Colors</h2>

<form:form action="deleteColor" method="post">
    <select multiple="multiple" size="10" name="ids">
        <c:forEach var="color" items="${colors}">
            <option value="${color.id}">
                    ${color.name}
            </option>
        </c:forEach>
    </select>
    <br>
    <button>delete</button>
</form:form>
</body>
</html>
