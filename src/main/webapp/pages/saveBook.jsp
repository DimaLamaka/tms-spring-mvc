<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Save book</title>
</head>
<body>
<h2><s:message code="label.book.save"/> </h2>
<form:form action="/springmvc/book/save" method="post" modelAttribute="book">
    <s:message code="label.book.title"/> : <form:input path="title"/>
    <form:errors path="title"/>
    <br>
    <s:message code="label.book.author"/> : <form:select path="author">
    <form:options items="${authors}"/>
</form:select><br>
    <s:message code="label.book.genre"/> : <form:select path="genre">
    <form:options items="${Genres}"/>
</form:select><br>
    <s:message code="label.book.production.date"/> : <form:input path="dateOfProduction"/><br>
    <input type="submit"
           value="<s:message code="label.button.add.book"/>"/>
</form:form>
</body>
</html>
