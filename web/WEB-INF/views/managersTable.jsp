<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Саша
  Date: 13.01.2017
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Managers</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
<form method="post" action="/selectManagersByOffice" class="edit">
    <p>
        <label for="office">Office:</label>
        <input type="text" name="number" id="office" value="">
    </p>

    <p class="login-submit">
        <button type="submit">Поиск</button>
    </p>
</form>
<form method="post" action="/selectManagers" class="edit">
    <p class="login-submit">
        <button type="submit">All managers</button>
    </p>
</form>
<table class="simple-little-table" cellspacing='0'>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>age</th>
        <th>salary</th>
        <th>office</th>
    </tr>
    <c:forEach items="${managers}" var="managers">
        <tr>
            <td><c:out value="${managers.id}"/></td>
            <td><c:out value="${managers.name}"/></td>
            <td><c:out value="${managers.age}"/></td>
            <td><c:out value="${managers.salary}"/></td>
            <td><c:out value="${managers.office}"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
