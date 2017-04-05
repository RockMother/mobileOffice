<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize var="logged" access="hasAnyRole({ 'ROLE_CLIENT', 'ROLE_MANAGER', 'ROLE_ADMIN'})"></sec:authorize>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mobile office</title>
    <link type="text/css" rel="stylesheet" href="/resources/main.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/cards.css"/>
</head>
<body>
<div class="main-content">
    <c:import url="../header.jsp"></c:import>
    <c:if test="${logged}">
        <c:import url="../mainmenu.jsp"></c:import>
    </c:if>
    <div class="working-area">
        <div class="cards">
            <c:forEach items="${clients}" var="client">
                <div class="card">
                    <div class="card-caption"><a
                            href="/clients/edit?id=${client.id}">${client.lastName} ${client.name}</a></div>
                    <div class="card-body">
                        <div class="card-row">
                            <div class="label">Address:</div>
                            <div class="value">${client.address}</div>
                        </div>
                        <div class="card-row">
                            <div class="label">Passport:</div>
                            <div class="value">${client.passport}</div>
                        </div>
                        <div class="card-row">
                            <div class="label">Birthday:</div>
                            <div class="value">${client.birthday}</div>
                        </div>
                        <div class="card-row">
                            <div class="label">Email:</div>
                            <div class="value">${client.email}</div>
                        </div>
                        <div class="card-row">
                            <div class="label">Contracts:</div>
                            <div class="value list">
                                <c:if test="${client.contractsById != null && client.contractsById.size() > 0}">
                                    <c:forEach items="${client.contractsById}" var="contract">
                                        <div class="sub-value">
                                                ${contract.number}
                                        </div>
                                    </c:forEach>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
