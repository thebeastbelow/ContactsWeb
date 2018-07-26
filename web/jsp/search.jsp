<%--
  Created by IntelliJ IDEA.
  User: enes
  Date: 05/07/18
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Search | Contacts</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/search" method="post">
        <table>
            <tr>
                <td>
                    <label for="name">Contact Name:</label>
                </td>
                <td>
                    <input type="text" name="name" id="name">
                </td>
            </tr>
            <tr>
                <td>
                </td>
                <td>
                    <button type="submit">Search</button>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
