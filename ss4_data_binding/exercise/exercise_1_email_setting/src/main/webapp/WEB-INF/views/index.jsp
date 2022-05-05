<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/5/2022
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>$Title$</title>
</head>
<body>
${msg}
<form:form action="/" modelAttribute="email" method="post">
    <h1>Setting</h1>
    Language:<form:select path="languages">
    <form:option value="english" label="English"/>
    <form:option value="vietnamese" label="Vietnamese"/>
    <form:option value="japanese" label="Japanese"/>
    <form:option value="chinese" label="Chinese"/>
</form:select>
    <br>

    Page Size: Show <form:select path="pageSize">
    <form:option value="5" label="5"/>
    <form:option value="10" label="10"/>
    <form:option value="15" label="15"/>
    <form:option value="20" label="20"/>
</form:select> emails per page <br>
    Spams filter <form:checkbox path="spamsFilter" value="true"/>Email spams filter <br>
    Signature: <form:textarea path="signature"/> <br>
    <input type="submit" value="Update">
</form:form>


</body>
</html>
