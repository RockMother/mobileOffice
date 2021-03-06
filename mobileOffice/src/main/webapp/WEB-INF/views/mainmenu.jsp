<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<sec:authorize var="logged" access="hasAnyRole({ 'ROLE_CLIENT', 'ROLE_MANAGER', 'ROLE_ADMIN'})"></sec:authorize>
<sec:authorize var="canRegister" access="hasAnyRole({'ROLE_MANAGER', 'ROLE_ADMIN'})"></sec:authorize>
<sec:authorize var="loggedAsManager" access="hasRole('ROLE_MANAGER')"></sec:authorize>
<sec:authorize var="loggedAsAdmin" access="hasRole('ROLE_ADMIN')"></sec:authorize>
<sec:authorize var="loggedAsClient" access="hasRole('ROLE_CLIENT')"></sec:authorize>
<div class="main-menu">
    <c:if test="${loggedAsAdmin}">
        <div class="menu-item"><a href="<c:url value="/registration" />">Add new manager</a></div>
        <div class="menu-item" style="display: none"><a href="<c:url value="/error" />">Check exception</a></div>
    </c:if>
    <c:if test="${loggedAsClient}">
        <div class="menu-item"><a href="<c:url value="/profile" />">Profile</a></div>
    </c:if>
    <c:if test="${loggedAsManager}">
        <div class="menu-item"><a href="<c:url value="/clients" />">Clients</a></div>
        <div class="menu-item"><a href="<c:url value="/tariffs" />">Tariffs</a></div>
        <div class="menu-item"><a href="<c:url value="/options" />">Options</a></div>
        <div class="menu-item"><a href="<c:url value="/clients/search" />">Search by number</a></div>
    </c:if>
</div>
