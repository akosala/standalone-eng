<html>
<body>
<h2>Hello World!</h2>
<form method="post" action="/hash-password"></form>
<c:if test="${okMessage != null}">
    <div style="color: green;">${okMessage}</div>
</c:if>
<%--<%@ include file="menu.jsp"%>--%>
<%--<%@ include file="add-user1.jsp"%>--%>
</body>
</html>
