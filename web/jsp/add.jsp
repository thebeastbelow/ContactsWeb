<%--
  Created by IntelliJ IDEA.
  User: enes
  Date: 05/07/18
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add Contact | Contacts</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/add" method="post">
        <table>
            <tr>
                <td>
                    <label for="name">Name:</label>
                </td>
                <td>
                    <input type="text" name="name" id="name">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="surname">Surname:</label>
                </td>
                <td>
                    <input type="text" name="surname" id="surname">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="tel_number">Number:</label>
                </td>
                <td>
                    <input type="text" name="tel_number" id="tel_number">
                </td>
            </tr>
            <tr>
                <td>
                </td>
                <td>
                    <button type="submit">Add</button>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
