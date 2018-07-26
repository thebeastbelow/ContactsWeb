<%--
  Created by IntelliJ IDEA.
  User: enes
  Date: 05/07/18
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Edit Contact | Contacts</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/edit" method="post">
        <input type="hidden" name="id" value="${id}">
        <table>
            <tr>
                <td>
                    <label for="name">Name:</label>
                </td>
                <td>
                    <input type="text" name="name" id="name" value="${contactData[0]}">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="surname">Surname:</label>
                </td>
                <td>
                    <input type="text" name="surname" id="surname" value="${contactData[1]}">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="tel_number">Number:</label>
                </td>
                <td>
                    <input type="text" name="tel_number" id="tel_number" value="${contactData[2]}">
                </td>
            </tr>
            <tr>
                <td>
                </td>
                <td>
                    <button type="submit">Save Changes</button>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
