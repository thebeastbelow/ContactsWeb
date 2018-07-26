<%--
  Created by IntelliJ IDEA.
  User: enes
  Date: 05/07/18
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search Results | Contacts</title>
</head>
<body>
    <table>
        <tr>
            <td>
                Id
            </td>
            <td>
                Name
            </td>
            <td>
                Surname
            </td>
            <td>
                Tel Number
            </td>
        </tr>

        <c:forEach items="${searchResults}" var="result">
            <tr>
                <td>
                    ${result.key}
                </td>
                <td>
                    ${result.value[0]}
                </td>
                <td>
                    ${result.value[1]}
                </td>
                <td>
                    ${result.value[2]}
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/edit?id=${result.key}">Edit</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
