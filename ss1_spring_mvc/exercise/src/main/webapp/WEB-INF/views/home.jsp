<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 4/29/2022
  Time: 2:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

</head>
<body>
<div class="d-flex justify-content-center">
    <form action="/result">
        <h1 class="text-center">Ứng dụng chuyển đổi tiền tệ</h1>
        <div>
            VNĐ:
            <input class="form-control" type="text" name="vnd">
            USD:
            <input class="form-control" type="text" name="usd">
        </div>
        <div class="d-flex justify-content-center">
            <input class="form-control btn btn-info" type="submit" value="Chuyển đổi">

        </div>
    </form>
</div>
<div class="d-flex justify-content-center">
    <h3>Kết quả: ${result1} ${result2}</h3>
</div>

</body>
</html>
