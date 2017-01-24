<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>All Projects</title>
</head>
<body>
<table>
    <tr >
        <td>ID</td>
        <td>Name</td>
        <td>Manager</td>
        <td>Due Date</td>
    </tr>
    <c:forEach items="${allProjects}" var="project">
        <tr>
            <td><c:out value="${project.id}"/></td>
            <td><c:out value="${project.project_name}"/></td>
            <td><c:out value="${project.manager}"/></td>
            <td><c:out value="${project.due_date}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
