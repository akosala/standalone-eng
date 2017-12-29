<%--
  Created by IntelliJ IDEA.
  User: akosala
  Date: 02.12.17
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> [login.jsp]</title>
</head>
<body>
<h1>Zaloguj:</h1>
<form method="post" action="/login">
    <label for="j_username">Login:</label>
    <input type="text" id="j_username" name="j_username"/><br/>
    <label for="j_password">Password:</label>
    <input type="password" id="j_password" name="j_password"/><br/>
    <input type="submit" value="login" />
</form>
</body>
</html>
