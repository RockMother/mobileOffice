<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize var="logged" access="hasAnyRole({ 'ROLE_CLIENT', 'ROLE_MANAGER', 'ROLE_ADMIN'})"></sec:authorize>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mobile office</title>
    <link type="text/css" rel="stylesheet" href="/resources/css/main.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/form.css"/>
    <script src="/resources/js/multiple-select-list.js"></script>
</head>
<body>
<div class="main-content">
    <c:import url="../header.jsp"></c:import>
    <c:if test="${logged}">
        <c:import url="../mainmenu.jsp"></c:import>
    </c:if>
    <div class="form-wrapper options-form">
        <form action=<c:if test="${addNew}">"/options/add"
        </c:if>
        <c:if test="${!addNew}">"/options/edit"</c:if> method="post">
        <div class="form-inner-wrapper">
            <c:if test="${!addNew}">
                <input type="hidden" name="id" value="${option.id}"/>
            </c:if>
            <div class="input-container">
                <div class="label">Name:</div>
                <div class="input-wrapper"><input type='text' name='name' value="${option.name}"/></div>
            </div>
            <div class="input-container">
                <div class="label">Initial price:</div>
                <div class="input-wrapper"><input type='number' name='initialPrice' value="${option.initialPrice}"/>
                </div>
            </div>
            <c:if test="${!addNew}">
                <div class="input-container">
                    <div class="label">Required options:</div>
                    <div class="multi-select-list input-wrapper">
                        <select multiple id="avaliableRequiredOptions">
                            <c:forEach items="${availableRequiredOptions}" var="option">
                                <option name="${option.name}" value="${option.id}">${option.name}</option>
                            </c:forEach>
                        </select>

                        <div class="multi-select-list-buttons">
                            <button type="button"
                                    onclick="addSelectedItems('avaliableRequiredOptions', 'selectedRequiredOptions')">
                                Add
                            </button>
                            <button type="button"
                                    onclick="addSelectedItems('selectedRequiredOptions', 'avaliableRequiredOptions')">
                                Remove
                            </button>
                        </div>
                        <select multiple id="selectedRequiredOptions" name="selectedRequiredOptions">
                            <c:forEach items="${selectedRequiredOptions}" var="option">
                                <option name="${option.name}" value="${option.id}" selected>${option.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="input-container">
                    <div class="label">Incompatible options:</div>
                    <div class="multi-select-list input-wrapper">
                        <select multiple id="avaliableIncompatibleOptions">
                            <c:forEach items="${avaliableIncompatibleOptions}" var="option">
                                <option name="${option.name}" value="${option.id}">${option.name}</option>
                            </c:forEach>
                        </select>

                        <div class="multi-select-list-buttons">
                            <button type="button"
                                    onclick="addSelectedItems('avaliableIncompatibleOptions', 'selectedIncompatibleOptions')">
                                Add
                            </button>
                            <button type="button"
                                    onclick="addSelectedItems('selectedIncompatibleOptions', 'avaliableIncompatibleOptions')">
                                Remove
                            </button>
                        </div>
                        <select multiple id="selectedIncompatibleOptions" name="selectedIncompatibleOptions">
                            <c:forEach items="${selectedIncompatibleOptions}" var="option">
                                <option name="${option.name}" value="${option.id}" selected>${option.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </c:if>
            <div>
                <button type="submit">Save</button>
            </div>
        </div>
        </form>
    </div>
</div>
</body>
</html>
