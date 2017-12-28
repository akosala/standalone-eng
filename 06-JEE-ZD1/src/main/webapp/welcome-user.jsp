<%--
  Created by IntelliJ IDEA.
  User: akosala
  Date: 02.12.17
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Hellooooo ${name}!
Hello ${sessionScope.sessionName}!<br>

Salary${salary}!
salary ${sessionScope.sessionSalary}!<br>
<c:set var="salary1" scope="request" value="${(salary*0.2)+salary}"/>
<c:out value="${salary1}" default="some default value" />

</body>
</html>
