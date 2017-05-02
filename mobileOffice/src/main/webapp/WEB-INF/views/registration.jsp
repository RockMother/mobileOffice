<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<sec:authorize var="loggedAsManager" access="hasRole('ROLE_MANAGER')"></sec:authorize>
<sec:authorize var="loggedAsAdmin" access="hasRole('ROLE_ADMIN')"></sec:authorize>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/main.css" />"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/form.css" />"/>
    <script src="/resources/js/repeat-password-validation.js"></script>
</head>
<body>
<div class="form-wrapper center-content">
    <form class="form registration-form <c:if test="${loggedAsManager}">new-client</c:if>" action="<c:url value="/register"/>" method='POST' onsubmit="mobileOffice.validatePassword()">
        <div class="form-inner-wrapper">
            <c:import url="common/userFields.jsp"/>
            <c:if test="${loggedAsAdmin}">
                <input type="hidden" name='role' value="ROLE_MANAGER"/>
            </c:if>
            <div class="input-container">
                <div class="login-button"><input name="submit" type="submit" value="Register"/></div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
