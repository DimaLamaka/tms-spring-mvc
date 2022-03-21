<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>All books</title>
</head>
<body>
<h1>
    <s:message code="label.all.books"/>
</h1>
<form action="/springmvc/book" method="get">
    <s:message code="label.search"/>: <input name="filter" type="text">
    <input type="submit"
           value="<s:message code="label.search"/>"/>
</form>
<form action="/springmvc/book/form" method="get">
    <input type="submit"
           value="<s:message code="label.button.add.book"/>"/>
</form>
<br><br>
<table border="1">
    <tr>
        <th><s:message code="label.book.id"/></th>
        <th><s:message code="label.book.title"/></th>
        <th><s:message code="label.book.author"/></th>
        <th><s:message code="label.book.genre"/></th>
        <th><s:message code="label.book.production.date"/></th>
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
