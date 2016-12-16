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

<form id="newColorForm" method="post">
<input id="name" name="name" placeholder="color name" autofocus="autofocus"/>
<br>
<button id="saveColorButton">save</button>
<br>
<label id="error"></label>
</form>

<h2>Existing Colors</h2>


<select size="10" id="colorList" multiple="multiple">
</select>
<br>
<button onclick="deleteColor()">deleteColor</button>

<script src="/js/color.js"></script>
</body>
</html>
