<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css">


<c:forEach var="userDTO" items="${userDTOs}">
    <div style="background-color: aqua">
            ${userDTO.name} ${userDTO.email} <a href="deleteUser/${userDTO.id}">delete</a>
    </div>
    <br>
</c:forEach>


<form:form modelAttribute="user" action="saveUser" method="post">
    <div id="form-main">
        <div id="form-div">
            <form class="form" id="form1">

                <form:input path="name" type="text"
                            class="validate[required,custom[onlyLetter],length[0,100]] feedback-input"
                            placeholder="Name" id="name"/>
                <label for="name">${exception}</label>
                <br>
                <form:input path="email" type="text"
                            class="validate[required,custom[email]] feedback-input"
                            id="email" placeholder="email"/>
                <br>
                <form:input path="password" type="text"
                            class="validate[required,custom[email]] feedback-input"
                            id="password" placeholder="password"/>
                <label for="password">${exception}</label>
                <br>
                <form:input path="phone" type="text"
                            class="validate[required,custom[password]] feedback-input"
                            id="phone" placeholder="phone"/>
                <br>
                <div class="submit">
                    <input type="submit" value="SEND" id="button-blue"/>
                    <div class="ease"></div>
                </div>

            </form>
        </div>
</form:form>