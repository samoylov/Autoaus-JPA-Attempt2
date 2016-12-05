<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>new Order</title>
    <%@include file="_styles.html" %>
</head>
<body>
<%@include file="_header.jsp" %>

<h1>Orders</h1>

<h2>New Order</h2>

<form:form action="saveOrder" method="post">

    <select name="customerID" autofocus="autofocus">
        <c:forEach var="customer" items="${customers}">
            <option value="${customer.id}">
                    ${customer.firstName}
                    ${customer.lastName}
            </option>
        </c:forEach>
    </select>

    <select name="carID">
        <c:forEach var="car" items="${cars}">
            <option value="${car.id}">
                    ${car}
            </option>
        </c:forEach>
    </select>

    <button>save</button>
</form:form>

<h2>Existing Orders</h2>

<form:form action="deleteOrder" method="post">
    <%--<input type="hidden"--%>
           <%--name="${_csrf.parameterName}"--%>
           <%--value="${_csrf.token}" />--%>
    <select size="10" name="id">
        <c:forEach var="anOrder" items="${orders}">
            <option value="${anOrder.id}">
                    ${anOrder.customer.firstName}
                    ${anOrder.customer.lastName} -
                    ${anOrder.car}
            </option>
        </c:forEach>
    </select>
    <br>
    <button>delete</button>
</form:form>

</body>
</html>
