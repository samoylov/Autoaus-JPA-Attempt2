<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>new Order</title>
    <%@include file="styles.html" %>
</head>
<body>
<%@include file="navigation.html" %>

<h1>Orders</h1>

<h2>New Order</h2>

<form action="saveOrder" method="post">

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
</form>

<h2>Existing Orders</h2>

<form action="deleteOrder" method="post">
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
</form>

</body>
</html>
