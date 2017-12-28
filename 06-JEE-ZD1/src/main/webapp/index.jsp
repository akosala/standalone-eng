<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<html>
<body>
<h2>Hello World!</h2>


<%@ include file="menu.jsp"%>
<%--<%@ include file="add-user1.jsp"%>--%>
<%@ include file="logged-tab.jsp"%>
<%
    LocalDateTime currentTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
%>
<div>
    <%=currentTime.format(formatter)%>
</div>
</body>
</html>
