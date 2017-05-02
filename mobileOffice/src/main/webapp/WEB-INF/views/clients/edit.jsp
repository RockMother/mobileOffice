<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize var="logged" access="hasAnyRole({ 'ROLE_CLIENT', 'ROLE_MANAGER', 'ROLE_ADMIN'})"></sec:authorize>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mobile office</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/main.css" />"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/form.css" />"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/contracts.css" />"/>
    <script src="/resources/js/multiple-select-list.js"></script>
    <script src="/resources/js/repeat-password-validation.js"></script>
</head>
<body>
<div class="main-content">
    <c:import url="../header.jsp"></c:import>
    <c:if test="${logged}">
        <c:import url="../mainmenu.jsp"></c:import>
    </c:if>
    <div class="form-wrapper new-client-form">
        <c:if test="${empty user}">
            <form action="<c:url value="/clients/add" method="post" onsubmit="mobileOffice.validatePassword()" />">
            <c:import url="../common/userFields.jsp"/>
            <c:import url="../manager/clientFields.jsp"/>
            </form>
        </c:if>
        <c:if test="${not empty user}">
            <div class="client-fields-wrapper">
            <c:import url="../manager/editClientFields.jsp"/>
            </div>
        </c:if>
        <c:if test="${not empty contracts}">
            <h3>Contracts</h3>
            <div class="contracts">
                <c:forEach items="${contracts}" var="contract">
                    <%@include file="../common/contractForm.jsp"%>
                </c:forEach>
            </div>
        </c:if>
    </div>
</div>
</body>
</html>
