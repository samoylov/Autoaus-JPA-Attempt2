<h3 class="text-muted">Autohaus</h3>
<nav>
    <a href="/">Home</a> |
    <a href="/newColor">Color</a> |
    <a href="/newEngine">Engine</a> |
    <a href="/newTransmission">Transmission</a> |
    <a href="/newCustomer">Customer</a> |
    <a href="/newCountry">Country</a> |
    <a href="/newMake">Make</a> |
    <a href="/newCarModel">Car Model</a> |
    <a href="/newCar">Car</a> |
    <a href="/newOrder">Orders</a>
</nav>

<%-- JQuery --%>
<script src="/js/jquery.min.js"></script>

<%-- Security --%>
<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />

<%-- user authentication --%>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<sec:authentication property="name"/>

<sec:authorize access="isAuthenticated()">

    <form:form action="logout" method="post">
        <button>logout</button>
    </form:form>
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
    <br>
    <a href="loginpage">login</a>
    <br>
    <a href="registration">registration</a>
    <br>
</sec:authorize>


<sec:authorize access="hasRole('ROLE_ADMIN')">

    <a href="admin">admin page</a>

</sec:authorize>



<sec:authorize access="isAuthenticated()">
    <a href="profile">profile</a>
</sec:authorize>

<%-- / user authentication --%>


