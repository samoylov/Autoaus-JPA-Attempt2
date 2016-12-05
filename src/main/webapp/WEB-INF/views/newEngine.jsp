<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>new Engine</title>
    <%@include file="_styles.html" %>
</head>
<body>
<%@include file="_header.jsp" %>

<h1>New Engine</h1>

<form:form action="saveEngine" method="post">
    <input name="name" placeholder="Engine name" autofocus="autofocus">
    <button>save</button>
</form:form>

<h2>Existing Engines</h2>

<form:form action="deleteEngine" method="post">
    <select size="10" name="id" >
        <c:forEach var="engine" items="${engines}">
            <option value="${engine.id}">
                    ${engine.name}
            </option>
        </c:forEach>
    </select>
    <br>
    <button>delete</button>
</form:form>


</body>
</html>
