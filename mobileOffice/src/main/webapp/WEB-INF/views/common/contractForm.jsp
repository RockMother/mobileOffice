<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize var="logged" access="hasAnyRole({ 'ROLE_CLIENT', 'ROLE_MANAGER', 'ROLE_ADMIN'})"></sec:authorize>
<sec:authorize var="loggedAsManager" access="hasRole('ROLE_MANAGER')"></sec:authorize>
<sec:authorize var="loggedAsClient" access="hasRole('ROLE_CLIENT')"></sec:authorize>
<div class="form-wrapper contract-edit">
  <form action="/contract/edit/" method="post">
    <input type="hidden" value="${user.id}" name="clientId">
    <input type="hidden" value="${contract.id}" name="id"/>
    <c:if test="${loggedAsManager}">
      <div class="input-container">
        <div class="label">Blocked:</div>
        <div class="input-wrapper"><input type="checkbox" name="blocked" value="true" <c:if test="${contract.isBlocked()}">checked</c:if>/></div>
      </div>
    </c:if>
    <div class="input-container">
      <div class="label">Number:</div>
      <div class="input-wrapper"><input type="text" value="${contract.number}" readonly disabled/></div>
    </div>
    <div class="input-container">
      <div class="label">Tariff:</div>
      <div class="input-wrapper">
        <select type="text" name="tariffId" value="${contract.number}" value="${contract.tariffId}"
        <c:if test="${loggedAsClient && contract.isBlocked()}">disabled</c:if> >
          <c:forEach items="${tariffs}" var="tariff">
            <option name="${tariff.name}" value="${tariff.id}"
                    <c:if test="${tariff.id == contract.tariffId}">selected</c:if> >
                ${tariff.name}
            </option>
          </c:forEach>
        </select>
      </div>
    </div>
    <div class="input-container">
      <div class="label">Tariff options:</div>
      <div class="multi-select-list input-wrapper">
        <select multiple id="avaliableOptions" <c:if test="${loggedAsClient && contract.isBlocked()}">disabled</c:if>>
          <c:forEach items="${contract.availableOptions}" var="option">
            <option name="${option.name}" value="${option.id}">${option.name}</option>
          </c:forEach>
        </select>
        <div class="multi-select-list-buttons">
          <button type="button"  onclick="addSelectedItems('avaliableOptions', 'selectedOptions')"
                  <c:if test="${loggedAsClient && contract.isBlocked()}">disabled</c:if> >Add</button>
          <button type="button" onclick="addSelectedItems('selectedOptions', 'avaliableOptions')"
                  <c:if test="${loggedAsClient && contract.isBlocked()}">disabled</c:if> >Remove</button>
        </div>
        <select multiple id="selectedOptions" name="selectedOptions" <c:if test="${loggedAsClient && contract.isBlocked()}">disabled</c:if>>
          <c:forEach items="${contract.selectedOptions}" var="option">
            <option name="${option.name}" value="${option.id}" selected>${option.name}</option>
          </c:forEach>
        </select>
      </div>
    </div>
    <div><button <c:if test="${loggedAsClient && contract.isBlocked()}">disabled</c:if> type="submit">Save</button></div>
  </form>
</div>