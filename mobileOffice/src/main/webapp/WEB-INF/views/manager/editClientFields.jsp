<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="input-container">
  <div class="label">Name:</div>
  <div class="input-wrapper"><input type='text' name='name' value="${user.name}"/></div>
</div>
<div class="input-container">
  <div class="label">Last Name:</div>
  <div class="input-wrapper"><input type='text' name='lastName' value="${user.lastName}"/></div>
</div>
<div class="input-container">
  <div class="label">Birthday:</div>
  <div class="input-wrapper">
    <input type='date' name='birthday' value="${user.birthday}"/>
  </div>
</div>
<div class="input-container">
  <div class="label">Passport:</div>
  <div class="input-wrapper"><input type='text' name='passport' value="${user.passport}"/></div>
</div>
<div class="input-container">
  <div class="label">Address:</div>
  <div class="input-wrapper"><input type='text' name='address' value="${user.address}"/></div>
</div>
<div class="input-container">
  <div class="label">Email:</div>
  <div class="input-wrapper"><input type='text' name='email' value="${user.email}"/></div>
</div>
<c:if test="${not empty contracts}">
  <div class="input-container">
    <div class="label">Contracts:</div>
    <div class="input-wrapper">
      <c:forEach items="${contracts}" var="contract">
        <div class="input-container">
          <div class="label">Number:</div>
          <div class="input-wrapper"><input type='text' name='number' value="${contract.number}"/></div>
        </div>
        <div class="input-container">
          <div class="label">Tariff:</div>
          <div class="input-wrapper"><input type='text' value="${contract.name}"/></div>
        </div>
      </c:forEach>
    </div>
  </div></c:if>

