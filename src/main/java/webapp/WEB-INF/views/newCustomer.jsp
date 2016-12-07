<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>new Customer</title>
    <%@include file="_styles.html" %>
</head>
<body>
<%@include file="_header.jsp" %>

<h1>Customer</h1>

<h2>New Customer</h2>

<form:form action="saveCustomer" method="post">
    <input name="firstName" placeholder="first name" autofocus="autofocus">
    <br>
    <input name="lastName" placeholder="last name">
    <br>
    <input name="address" placeholder="address">
    <br>
    <input name="email" type="email" placeholder="email">
    <br>
    <button>save</button>
</form:form>

<h2>Existing Customers</h2>

<form:form action="deleteCustomer" method="post">
    <select size="10" name="id">
        <c:forEach var="customer" items="${customers}">
            <option value="${customer.id}">
                    ${customer.firstName}, ${customer.lastName}
            </option>
        </c:forEach>
    </select>
    <br>
    <button>delete</button>
</form:form>

</body>
</html>
