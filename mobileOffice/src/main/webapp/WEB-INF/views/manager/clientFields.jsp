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
<input type="hidden" name='role' value="ROLE_CLIENT"/>
<div class="input-container">
    <div class="login-button"><input name="submit" type="submit" value="Create"/></div>
</div>
