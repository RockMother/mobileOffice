<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize var="logged" access="hasAnyRole({ 'ROLE_CLIENT', 'ROLE_MANAGER', 'ROLE_ADMIN'})"></sec:authorize>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mobile office</title>
    <link type="text/css" rel="stylesheet" href="/resources/main.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/form.css"/>
</head>
<body>
<div class="main-content">
    <c:import url="../header.jsp"></c:import>
    <c:if test="${logged}">
        <c:import url="../mainmenu.jsp"></c:import>
    </c:if>
    <div class="form-wrapper tariffs-form">
        <form action=<c:if test="${addNew}">"/tariffs/add"</c:if><c:if test="${!addNew}">"/tariffs/edit"</c:if> method="post">
            <div class="form-inner-wrapper">
                <div class="input-container">
                    <div class="label">Name:</div>
                    <div class="input-wrapper"><input type='text' name='name' value="${tariffs.name}"/></div>
                </div>
                <div class="input-container">
                    <div class="label">Price:</div>
                    <div class="input-wrapper"><input type='number' name='price' value="${tariffs.price}"/></div>
                </div>
                <button type="submit"><c:if test="${addNew}">Create</c:if><c:if test="${!addNew}">Edit</c:if></button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
