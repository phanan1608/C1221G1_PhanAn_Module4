<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/5/2022
  Time: 6:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<div class="container text-center">
    <h2>TỜ KHAI Y TẾ</h2>
    <h3>TÀI LIỆU QUAN TRỌNG</h3>
    <h4 style="color: red">Khuyến cáo:</h4>
    <form:form action="/save" method="post" modelAttribute="health">
        <div>
            <span>Họ tên (ghi chữ IN HOA)<span style="color: red">(*)</span></span> <br>
            <form:input class="form-control" type="text" path="name"/>
        </div>
        <div class="d-flex float-left col-4">
            <span>Năm sinh<span style="color: red">(*)</span></span> <br>
            <form:input class="form-control" type="number" path="yearOfBirth"/>
        </div>
        <div class="d-flex float-left col-4">
            <span>Giới tính<span style="color: red">(*)</span></span> <br>
            <form:select class="form-control "  path="gender">
                <option value="none">--Chọn--</option>
                <option value="nam">Nam</option>
                <option value="nu">Nữ</option>
            </form:select>
        </div>
        <div class="d-flex col-4">
            <span>Quốc Tịch<span style="color: red">(*)</span></span> <br>
            <form:select class="form-control" path="nationality">
                <option value="none">--Chọn--</option>
                <option value="vn">Việt Nam</option>
                <option value="my">Mỹ</option>
                <option value="my">Nhật Bản</option>
                <option value="my">Hàn Quốc</option>
            </form:select>
        </div>

        <div>
            <span>Số hộ chiếu hoặc số cmnd hoặc giấy tờ tuỳ thân<span style="color: red">(*)</span></span>
            <form:input class="form-control" type="number" path="idCard"/>
        </div>
        <div>
            <span>Thông tin đi lại<span style="color: red">(*)</span></span>
            <div>
                <form:radiobutton path="vehicle" value="tauBay"/> Tàu bay
                <form:radiobutton path="vehicle" value="tauThuyen"/> Tàu thuyền
                <form:radiobutton path="vehicle" value="oto"/> Ô tô
                <form:radiobutton path="vehicle" value="khac"/> Khác (ghi rõ)
            </div>
        </div>
        <div>
            <div>
                <span>Sô hiệu phương tiện</span> <br>
                <form:input class="form-control" type="text" path="vehicleNumber"/>
            </div>
            <div>
                <span>Số ghế</span> <br>
                <form:input class="form-control" type="text" path="seatNumber"/>
            </div>
        </div>
        <div>
            <div>
                <span>Ngày khởi hành</span> <br>
                <form:input class="form-control" type="date" path="startDate"/>
            </div>
            <div>
                <span>Ngày kết thúc</span> <br>
                <form:input class="form-control" type="date" path="endDate"/>
            </div>
        </div>
        <input type="submit" value="Gửi tờ khai">
    </form:form>
</div>


</body>
</html>
