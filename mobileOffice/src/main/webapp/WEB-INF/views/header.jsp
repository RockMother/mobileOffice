<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize var="logged" access="hasAnyRole({ 'ROLE_CLIENT', 'ROLE_MANAGER', 'ROLE_ADMIN'})"></sec:authorize>
<sec:authorize var="canRegister" access="hasAnyRole({'ROLE_MANAGER', 'ROLE_ADMIN'})"></sec:authorize>
<sec:authorize var="loggedAsManager" access="hasRole('ROLE_MANAGER')"></sec:authorize>
<sec:authorize var="loggedAsAdmin" access="hasRole('ROLE_ADMIN')"></sec:authorize>

<div class="main-toolbar">
    <div class="logo">Mobile operator</div>
    <div class="right-toolbar">
        <c:choose>
            <c:when test="${logged}">
                <a href="/logout">Logout</a>
            </c:when>
            <c:otherwise>
                <div class="login-wrapper">
                    <a href="login">Login</a>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</div>