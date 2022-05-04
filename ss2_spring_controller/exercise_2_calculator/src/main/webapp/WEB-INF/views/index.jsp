<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/4/2022
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Calculator</h2>
  <form action="/display">
    <input type="number" name="num1">
    <input type="number" name="num2">
    <input type="submit" name="operator" value="+">
    <input type="submit" name="operator" value="-">
    <input type="submit" name="operator" value="*">
    <input type="submit" name="operator" value="/">
  </form>
  <h3>Result: ${result}</h3>
  </body>
</html>
