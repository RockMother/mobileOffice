<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="input-container">
    <div class="label">Name:</div>
    <div class="input-wrapper"><input required type='text' name='name'/></div>
</div>
<div class="input-container">
    <div class="label">Last Name:</div>
    <div class="input-wrapper"><input required type='text' name='lastName'/></div>
</div>
<div class="input-container">
    <div class="label">Birthday:</div>
    <div class="input-wrapper">
        <input type='date'required  name='birthday'/>
    </div>
</div>
<div class="input-container">
    <div class="label">Passport:</div>
    <div class="input-wrapper"><input required type='text' name='passport'/></div>
</div>
<div class="input-container">
    <div class="label">Address:</div>
    <div class="input-wrapper"><input required type='text' name='address'/></div>
</div>
<div class="input-container">
    <div class="label">Email:</div>
    <div class="input-wrapper"><input required type='text' name='email'/></div>
</div>
<div class="input-container">
    <div class="label">Phone number:</div>
    <div class="input-wrapper"><input required type='text' name='number'/></div>
</div>
<div class="input-container">
    <div class="label">Tariff:</div>
    <div class="input-wrapper">
        <select name='tariffId' required >
            <c:forEach items="${tariffs}" var="tariff">
                <option name="${tariff.name}" value="${tariff.id}">${tariff.name}</option>
            </c:forEach>
        </select>
    </div>
</div>
<input type="hidden" name='role' value="ROLE_CLIENT"/>
<div class="input-container">
    <div class="login-button"><input name="submit" type="submit" value="Create"/></div>
</div>
