<%--
  Created by IntelliJ IDEA.
  User: akosala
  Date: 16.12.17
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Statystyki</title>
</head>
<body>
LIST SIZE: <c:out value="${listSize}"/>    <%--wyswietlanie--%>
<table border="1" width="100%">

    <tr>
        <th>Id</th>
        <th>Imie</th>
        <th>Nazwisko</th>
        <th>Login</th>
        <th>Wiek</th>
        <th>Plec</th>
    </tr>

    <c:forEach var="user" items="${list}">
        <tr <c:if test="${user.gender.toString() == 'MEN'}">style="color: blue;"</c:if>>
<%--if else w domu rozne kolory--%>

            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.surname}"/></td>
            <td><c:out value="${user.login}"/></td>
            <td><c:out value="${user.age}"/></td>
            <td><c:out value="${user.gender}"/></td>

        </tr>

    </c:forEach>

</table>

</body>
</html>