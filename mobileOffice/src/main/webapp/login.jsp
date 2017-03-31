<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kisc
  Date: 3/30/2017
  Time: 12:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form name='loginForm' action="j_spring_security_check" method='POST'>
  <table>
    <tr>
      <td>User:</td>
      <td><input type='text' name='username' value=''></td>
    </tr>
    <tr>
      <td>Password:</td>
      <td><input type='password' name='password' /></td>
    </tr>
    <tr>
      <td colspan='2'><input name="submit" type="submit" value="submit" /></td>
    </tr>
  </table>
</form>
</body>
</html>

