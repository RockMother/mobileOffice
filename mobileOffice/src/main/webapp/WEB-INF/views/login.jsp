<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login to mobile office</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/main.css" />"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/form.css" />"/>
</head>
<body>
<div class="form-wrapper center-content">
    <form class="form login-form <c:if test="${param.error != null}">error</c:if>" name='loginForm' action="j_spring_security_check" method='POST'>
        <div class="form-inner-wrapper">
            <div class="input-container">
                <div class="label">User:</div>
                <div class="input-wrapper"><input type='text' name='username' value=''></div>
            </div>
            <div class="input-container">
                <div class="label">Password:</div>
                <div class="input-wrapper"><input type='password' name='password'/></div>
            </div>
            <c:if test="${param.error != null}">
                <div id="error">
                    Wrong credentials
                </div>
            </c:if>
            <div class="input-container">
                <div class="login-button"><input name="submit" type="submit" value="Login"/></div>
            </div>
        </div>
    </form>
</div>
</body>
</html>

