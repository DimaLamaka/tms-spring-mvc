<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save book</title>
</head>
<body>
<form:form action="/springmvc/book/save" method="post" modelAttribute="book">
    Title : <form:input path="title"/><br>
    Author : <form:select path="author">
    <form:options items="${authors}"/>
</form:select><br>
    Genre : <form:select path="genre">
    <form:options items="${Genres}"/>
</form:select><br>
    Date of production : <form:input path="dateOfProduction"/><br>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>
