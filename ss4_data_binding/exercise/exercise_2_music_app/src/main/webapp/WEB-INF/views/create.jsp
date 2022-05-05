<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="productForm" action="/save" method="post">

    Tên bài hát:
    <form:input path="musicName"/>
    <br>
    Nghệ sĩ thể hiện
    <form:input path="musicArtist"/>
    <br>
    Thể loại nhạc
    <form:input path="musicGenre"/>
    <br>
    Đường dẫn file bài hát
    <form:input path="musicLink"/>
    <br>
    <button type="submit"> LƯU</button>
</form:form>
</body>
</html>