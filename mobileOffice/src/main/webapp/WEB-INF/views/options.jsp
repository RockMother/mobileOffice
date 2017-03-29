<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head></head>
<body>
    <table>
        <thead>
        <th>
            <tr>
                <td>ID</td>
                <td>Price</td>
                <td>Initial price</td>
            </tr>
        </th>
        </thead>
        <tbody>
            <c:forEach var="option" items="${options}">
                <tr>
                    <td><c:out value="${option.id}"/></td>
                    <td><c:out value="${option.price}"/></td>
                    <td><c:out value="${option.intialPrice}"/></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>