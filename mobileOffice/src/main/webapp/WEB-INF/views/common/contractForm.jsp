<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize var="logged" access="hasAnyRole({ 'ROLE_CLIENT', 'ROLE_MANAGER', 'ROLE_ADMIN'})"></sec:authorize>
<div class="form-wrapper contract-edit">
  <form action="/contract/edit" method="post">
    <input type="hidden" value="${contract.id}" name="id">
    <div class="input-container">
      <div class="label">Number:</div>
      <div class="input-wrapper"><input type="text" value="${contract.number}" readonly disabled/></div>
    </div>
    <div class="input-container">
      <div class="label">Tariff:</div>
      <div class="input-wrapper">
        <select type="text" name="tariffId" value="${contract.number}" value="${contract.tariffId}">
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
      </div>
    </div>
    <div><button type="submit">Save</button></div>
  </form>
</div>