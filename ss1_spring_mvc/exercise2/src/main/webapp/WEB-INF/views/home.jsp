<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 4/29/2022
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

</head>
<body>
<div>
    <h1 class="text-center">Ứng dụng từ điển</h1>
</div>
<div class="d-flex justify-content-center">
    <form method="get" action="/result">
        <div class="d-flex justify-content-start ">
            <div class="form-outline">
                <input id="name_search" type="search" name="keyword" placeholder="Keyword" class="form-control"/>
            </div>
            <input type="hidden" name="action" value="search">
            <div class="form-outline">
                <button id="search-button" type="submit" class="btn btn-primary">
                    <svg class="bi bi-search" fill="currentColor" height="16" viewBox="0 0 16 16" width="16"
                         xmlns="http://www.w3.org/2000/svg">
                        <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                    </svg>
                    Search
                </button>
            </div>

        </div>
    </form>
</div>
<div class="d-flex justify-content-center">
    <h3>Kết quả: ${result}</h3>
</div>

</body>
</html>
