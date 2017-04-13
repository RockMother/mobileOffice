<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<sec:authorize var="loggedAsManager" access="hasRole('ROLE_MANAGER')"></sec:authorize>
<sec:authorize var="loggedAsAdmin" access="hasRole('ROLE_ADMIN')"></sec:authorize>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="/resources/css/main.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/form.css"/>
</head>
<body>
<div class="form-wrapper center-content">
    <form class="form registration-form <c:if test="${loggedAsManager}">new-client</c:if>" action="/register" method='POST'>
        <div class="form-inner-wrapper">
            <c:import url="common/userFields.jsp"/>
            <c:if test="${loggedAsManager}">
                <div class="input-container">
                    <div class="label">Name:</div>
                    <div class="input-wrapper"><input type='text' name='name'/></div>
                </div>
                <div class="input-container">
                    <div class="label">Last Name:</div>
                    <div class="input-wrapper"><input type='text' name='lastName'/></div>
                </div>
                <div class="input-container">
                    <div class="label">Birthday:</div>
                    <div class="input-wrapper">
                        <input type='date' name='birthday'/>
                    </div>
                </div>
                <div class="input-container">
                    <div class="label">Passport:</div>
                    <div class="input-wrapper"><input type='text' name='passport'/></div>
                </div>
                <div class="input-container">
                    <div class="label">Address:</div>
                    <div class="input-wrapper"><input type='text' name='address'/></div>
                </div>
                <div class="input-container">
                    <div class="label">Email:</div>
                    <div class="input-wrapper"><input type='text' name='email'/></div>
                </div>
            </c:if>
            <c:if test="${loggedAsAdmin}">
                <input type="hidden" name='role' value="ROLE_MANAGER"/>
            </c:if>
            <c:if test="${loggedAsManager}">
                <c:import url="manager/clientFields.jsp"/>
            </c:if>
            <div class="input-container">
                <div class="login-button"><input name="submit" type="submit" value="Register"/></div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
