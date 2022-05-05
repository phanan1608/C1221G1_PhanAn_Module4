<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/5/2022
  Time: 7:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Thông tin</h2>
Họ và tên: ${health.name} <br>
Năm sinh: ${health.yearOfBirth} <br>
Giới tính: ${health.gender} <br>
Quốc tịch:${health.nationality}<br>
Số CMND: ${health.idCard}<br>
Di chuyển bằng:${health.vehicle}<br>
Số phương tiện: ${health.vehicleNumber}<br>
Số ghế${health.seatNumber}<br>
Ngày khởi hành: ${health.startDate}<br>
Ngày kết thúc: ${health.endDate}<br>
    <button class="btn btn-info"><a href="/home"> Update information</a></button>

</body>
</html>
