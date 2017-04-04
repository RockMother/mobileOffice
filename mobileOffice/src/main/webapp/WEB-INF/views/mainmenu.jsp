<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<sec:authorize var="logged" access="hasAnyRole({ 'ROLE_CLIENT', 'ROLE_MANAGER', 'ROLE_ADMIN'})"></sec:authorize>
<sec:authorize var="canRegister" access="hasAnyRole({'ROLE_MANAGER', 'ROLE_ADMIN'})"></sec:authorize>
<sec:authorize var="loggedAsManager" access="hasRole('ROLE_MANAGER')"></sec:authorize>
<sec:authorize var="loggedAsAdmin" access="hasRole('ROLE_ADMIN')"></sec:authorize>
<div class="main-menu">
    <c:if test="${loggedAsAdmin}">
        <div class="menu-item"><a href="/register">Add new manager</a></div>
    </c:if>
    <c:if test="${loggedAsManager}">
        <div class="menu-item"><a href="/tariffs">Tariffs</a></div>
    </c:if>
</div>