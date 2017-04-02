<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<sec:authorize var="loggedIn" access="hasRole('ROLE_CLIENT')"></sec:authorize>

<div class="main-toolbar">
    <div class="logo">Mobile operator</div>
    <div class="right-toolbar">
        <c:choose>
            <c:when test="${loggedIn}">
                <a href="logout">Logout</a>
            </c:when>
            <c:otherwise>
                <div class="login-wrapper">
                    <a href="login">Login</a>
                </div>
                <div class="Registration-wrapper">
                    <a href="registration">Registration</a>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</div>