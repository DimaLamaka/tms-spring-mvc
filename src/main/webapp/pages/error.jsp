<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Error page</title>
</head>
<body>
<h2><s:message code="label.error"/></h2>
<s:message code="label.error.message"/> : ${message}<br><br>
<s:message code="label.error.details"/> : ${details}
</body>
</html>
