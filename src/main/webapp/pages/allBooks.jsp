<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All books</title>
</head>
<body>
<form action="/springmvc/book" method="get">
    Search : <input name="filter" type="text">
    <input type="submit" value="Search">
</form>
<form action="/springmvc/book/form" method="get">
    <input type="submit" value="Add book"/>
</form><br><br>
<table border="1">
    <tr>
    <th>Id</th>
    <th>Title</th>
    <th>Author</th>
    <th>Genre</th>
    <th>Date of production</th>
    </tr>
        <c:forEach var="book" items="${books}">
    <tr>
        <td>${book.id}</td>
        <td>${book.title}</td>
        <td>${book.author}</td>
        <td>${book.genre}</td>
        <td>${book.dateOfProduction}</td>
    </tr>
        </c:forEach>

</table>

</body>
</html>
