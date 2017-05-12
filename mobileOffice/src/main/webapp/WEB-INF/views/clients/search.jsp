<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize var="logged" access="hasAnyRole({ 'ROLE_CLIENT', 'ROLE_MANAGER', 'ROLE_ADMIN'})"></sec:authorize>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="hideCreateNew" value="true"/>
<html>
<head>
    <title>Mobile office</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/main.css" />"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/form.css" />"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/cards.css" />"/>
</head>
<body>
<div class="main-content">
    <c:import url="../header.jsp"></c:import>
    <c:if test="${logged}">
        <c:import url="../mainmenu.jsp"></c:import>
    </c:if>
    <div class="working-area">
        <div class="form-wrapper search-client-form">
            <form action="<c:url value="/clients/search" />" method="post">
                <div class="input-container">
                    <div class="label">Number:</div>
                    <div class="input-wrapper"><input type='text' name='number'></div>
                </div>
                <div><button type="submit">Search</button></div>
            </form>
        </div>
        <c:if test="${not empty clients}">
            <%@include file="clientCards.jsp"%>
        </c:if>
        <c:if test="${empty clients}">
            <div><h3>Nothing to show</h3></div>
        </c:if>
        <div style="flex: 1"></div>
    </div>
</div>
</body>
</html>
