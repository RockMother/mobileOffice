<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize var="logged" access="hasAnyRole({ 'ROLE_CLIENT', 'ROLE_MANAGER', 'ROLE_ADMIN'})"></sec:authorize>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mobile office</title>
    <link type="text/css" rel="stylesheet" href="/resources/main.css"/>
</head>
<body>
<div class="main-content">
    <c:import url="header.jsp"></c:import>
    <c:if test="${logged}">
        <c:import url="mainmenu.jsp"></c:import>
    </c:if>
    <div class="working-area">
        <div class="main-declaration"><p>Задание в JS20</p></div>
        <div class="secondary-declaration"><p>Мобильный офис</p></div>
    </div>
</div>
</body>
</html>
