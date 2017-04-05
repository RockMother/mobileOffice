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
                <c:if test="${!addNew}">
                <input type="hidden" name="id" value="${tariff.id}"/>
                </c:if>
                <div class="input-container">
                    <div class="label">Name:</div>
                    <div class="input-wrapper"><input type='text' name='name' value="${tariff.name}"/></div>
                </div>
                <div class="input-container">
                    <div class="label">Price:</div>
                    <div class="input-wrapper"><input type='number' name='price' value="${tariff.price}"/></div>
                </div>
                <div class="input-container">
                    <div class="label">Options:</div>
                    <div class="multi-select-list input-wrapper">
                        <select multiple id="avaliableOptions">
                            <c:forEach items="${options}" var="option">
                            <option name="${option.name}" value="${option.id}">${option.name}</option>
                            </c:forEach>
                        </select>
                        <div class="multi-select-list-buttons">
                            <button type="button" onclick="addSelectedItems('avaliableOptions', 'selectedOptions')">Add</button>
                            <button type="button" onclick="addSelectedItems('selectedOptions', 'avaliableOptions')">Remove</button>
                        </div>
                        <select multiple id="selectedOptions" name="selectedOptions">
                            <c:forEach items="${selectedOptions}" var="option">
                                <option name="${option.name}" value="${option.id}">${option.name}</option>
                            </c:forEach>
                        </select>
                        <script>
                            function addSelectedItems(source, target){
                                var sourceList = document.getElementById(source);
                                var targetList = document.getElementById(target);
                                var selectedValues = sourceList.value || [];
                                if (!(selectedValues instanceof Array)){
                                    selectedValues = [selectedValues];
                                }
                                for (var i = 0; i < sourceList.children.length; i++) {
                                    var childNode = sourceList.children[i];
                                    if (selectedValues.indexOf(childNode.value) !== -1){
                                        sourceList.removeChild(childNode);
                                        targetList.appendChild(childNode);
                                    }
                                }
                            }
                        </script>
                    </div>
                </div>
                <div>
                    <button type="submit">Save</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
