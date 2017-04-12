<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize var="logged" access="hasAnyRole({ 'ROLE_CLIENT', 'ROLE_MANAGER', 'ROLE_ADMIN'})"></sec:authorize>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Mobile office</title>
  <link type="text/css" rel="stylesheet" href="/resources/css/main.css"/>
  <link type="text/css" rel="stylesheet" href="/resources/css/cards.css"/>
</head>
<body>
<div class="main-content">
  <c:import url="../header.jsp"></c:import>
  <c:if test="${logged}">
    <c:import url="../mainmenu.jsp"></c:import>
  </c:if>
  <div class="working-area">
    <div class="contracts cards">
      <c:forEach items="${contracts}" var="contract">
        <div class="card">
          <div class="card-caption"><a href="/contract/edit?id=${contract.id}">${contract.number}</a></div>
          <div class="card-body">
            <div class="card-row">
              <div class="label">Tariff:</div>
              <div class="value">${contract.name}</div>
            </div>
          </div>
          <div class="footer-card">
            <c:if test="${contract.isBlocked && contract.isAdminBlocker}">
              <div>Blocked by manager</div>
            </c:if>
            <c:if test="${contract.isBlocked && !contract.isAdminBlocker}">
              <a href="/contract/unblock?id=${contract.id}">Unblock</a>
            </c:if>
            <c:if test="${!contract.isBlocked}">
              <a href="/contract/block?id=${contract.id}">Block</a>
            </c:if>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
</div>
</body>
</html>
