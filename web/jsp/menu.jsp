<%--
  Created by IntelliJ IDEA.
  User: enes
  Date: 05/07/18
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Menu | Contacts</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/add" method="get">
        <button type="submit">Add a new contact</button>
    </form>
    <form action="${pageContext.request.contextPath}/search" method="get">
        <button type="submit">Edit a contact</button>
    </form>
</body>
</html>
