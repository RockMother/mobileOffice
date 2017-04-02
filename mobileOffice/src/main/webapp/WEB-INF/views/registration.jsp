<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="/resources/main.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/form.css"/>
</head>
<body>
<div class="form-wrapper">
    <form class="form registration-form" action="/register" method='POST'>
        <div class="form-inner-wrapper">
            <div class="input-container">
                <div class="label">User:</div>
                <div class="input-wrapper"><input type='text' name='username' value=''></div>
            </div>
            <div class="input-container">
                <div class="label">Password:</div>
                <div class="input-wrapper"><input type='password' name='password'/></div>
            </div>
            <div class="input-container">
                <div class="label">Repeat password:</div>
                <div class="input-wrapper"><input type='password' name='repeatPassword'/></div>
            </div>
            <div class="input-container">
                <div class="label">Role:</div>
                <div class="input-wrapper">
                    <select name="role">
                        <option value="1">Client</option>
                        <option value="2">Manager</option>
                    </select>
                </div>
            </div>
            <div class="input-container">
                <div class="login-button"><input name="submit" type="submit" value="Login"/></div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
