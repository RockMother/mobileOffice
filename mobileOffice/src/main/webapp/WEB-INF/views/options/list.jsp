<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize var="logged" access="hasAnyRole({ 'ROLE_CLIENT', 'ROLE_MANAGER', 'ROLE_ADMIN'})"></sec:authorize>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mobile office</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/main.css" />"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/cards.css" />"/>
</head>
<body>
<div class="main-content">
    <c:import url="../header.jsp"></c:import>
    <c:if test="${logged}">
        <c:import url="../mainmenu.jsp"></c:import>
    </c:if>
    <div class="working-area">
        <div class="tariffs cards">
            <c:forEach items="${options}" var="option">
                <div class="card">
                    <div class="card-caption"><a href="<c:url value="/options/edit?id=${option.id}" />">${option.name}</a></div>
                    <div class="card-body">
                        <div class="card-row">
                            <div class="label">Price:</div>
                            <div class="value">${option.initialPrice}</div>
                        </div>
                    </div>
                    <div class="footer-card"><a href="<c:url value="/options/delete?id=${option.id}" />">Remove</a></div>
                </div>
            </c:forEach>
            <div class="card">
                <div class="card-caption"><a href="<c:url value="/options/add" />">Add new option</a></div>
                <div class="card-body">
                    <div class="card-row">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
