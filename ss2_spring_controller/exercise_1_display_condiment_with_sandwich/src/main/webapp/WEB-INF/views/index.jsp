<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/4/2022
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/display">
    <label>
        <input type="checkbox" name="condiment" value="lettuce">
        Lettuce
    </label>
    <label>
        <input type="checkbox" name="condiment" value="tomato">
        Tomato
    </label>
    <label>
        <input type="checkbox" name="condiment" value="mustard">
        Mustard
    </label>
    <label>
        <input type="checkbox" name="condiment" value="sprouts">
        Sprouts
    </label>
    <input type="submit" value="Save">
</form>

<c:forEach var="condiment" items="${condiments}">
    ${condiment}
</c:forEach>
</body>

</html>
