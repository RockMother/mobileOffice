<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<sec:authorize var="loggedIn" access="hasRole('ROLE_CLIENT')"></sec:authorize>

<div class="main-toolbar">
    <div class="logo">Mobile operator</div>
    <div class="right-toolbar">
        <c:choose>
            <c:when test="${loggedIn}">
                <c:import url="user-info.jsp"></c:import>
            </c:when>
            <c:otherwise>
                <a href="login">Login</a>
            </c:otherwise>
        </c:choose>
    </div>
</div>