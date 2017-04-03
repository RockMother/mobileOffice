<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<sec:authorize var="loggedAsManager" access="hasRole('ROLE_MANAGER')"></sec:authorize>
<sec:authorize var="loggedAsAdmin" access="hasRole('ROLE_ADMIN')"></sec:authorize>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="/resources/main.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/form.css"/>
</head>
<body>
<div class="form-wrapper">
    <form class="form registration-form" action="/register" method='POST'>
        <div class="form-inner-wrapper">
            <div class="input-container">
                <div class="label">User:</div>
                <div class="input-wrapper"><input type='text' name='username' value=''></div>
            </div>
            <div class="input-container">
                <div class="label">Password:</div>
                <div class="input-wrapper"><input type='password' name='password'/></div>
            </div>
            <div class="input-container">
                <div class="label">Repeat password:</div>
                <div class="input-wrapper"><input type='password' name='repeatPassword'/></div>
            </div>
            <c:if test="${loggedAsAdmin}">
                <input type="hidden" name='role' value="ROLE_MANAGER"/>
            </c:if>
            <c:if test="${loggedAsManager}">
                <input type="hidden" name='role' value="ROLE_CLIENT"/>
            </c:if>
            <div class="input-container">
                <div class="login-button"><input name="submit" type="submit" value="Register"/></div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
