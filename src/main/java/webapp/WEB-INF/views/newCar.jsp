<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>new Car</title>
    <%@include file="_styles.html" %>
</head>
<body>
<%@include file="_header.jsp" %>

<h1>Car</h1>

<h2>New Car</h2>

<form:form action="saveCar" method="post">

    <select name="carModelID">
        <c:forEach var="carModel" items="${carModels}">
            <option value="${carModel.id}">
                    ${carModel.make.name} ${carModel.name}
            </option>
        </c:forEach>
    </select>

    <select name="engineID">
        <c:forEach var="engine" items="${engines}">
            <option value="${engine.id}">
                    ${engine.name}
            </option>
        </c:forEach>
    </select>

    <select name="transmissionID">
        <c:forEach var="transmission" items="${transmissions}">
            <option value="${transmission.id}">
                    ${transmission.name}
            </option>
        </c:forEach>
    </select>

    <select name="colorID">
        <c:forEach var="color" items="${colors}">
            <option value="${color.id}">
                    ${color.name}
            </option>
        </c:forEach>
    </select>

    <input name="price" placeholder="price" autofocus="autofocus">

    <button>save</button>
</form:form>

<h2>Existing Cars</h2>

<form:form action="deleteCar" method="post">
    <select size="10" name="id">
        <c:forEach var="car" items="${cars}">
            <option value="${car.id}">
                    ${car.carModel.make.name}
                    ${car.carModel.name},
                    ${car.engine.name},
                    ${car.transmission.name},
                    ${car.color.name},
                    ${car.price} USD
            </option>
        </c:forEach>
    </select>
    <br>
    <button>delete</button>
</form:form>

</body>
</html>
