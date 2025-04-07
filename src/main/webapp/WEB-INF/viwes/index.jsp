<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ToDo List</title>
</head>
<body>
<h1>ToDo List</h1>

<form action="/todos" method="post">
    <input type="text" name="title" placeholder="Enter a new task" required />
    <button type="submit">Add</button>
</form>

<ul>

    <c:forEach items="${todos}" var="todo">
        <li>
                ${todo.title}
            <c:if test="${todo.completed}"> (Completed)</c:if>
            <c:if test="${not todo.completed}"> (Pending)</c:if>
            <a href="/todos/update/${todo.id}">Edit</a>
            <a href="/todos/delete/${todo.id}">Delete</a>
        </li>
    </c:forEach>

</ul>
</body>
</html>
