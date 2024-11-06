<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/6/2024
  Time: 10:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search Name</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<form action="rental-rooms?action=search" method="post" class="container mt-5">
  <div class="form-group">
    <label for="name">Nhập tên cần tìm:</label>
    <input type="text" name="name" id="name" class="form-control" placeholder="Nhập tên cần tìm">
  </div>
  <button type="submit" class="btn btn-primary">Tìm</button>
</form>

<table class="table table-bordered table-striped table-hover">
  <tr>
    <th>Stt</th>
    <th>Mã phòng trọ</th>
    <th>Tên người thuê</th>
    <th>Số điện thoại</th>
    <th>Ngày bắt đầu thuê</th>
    <th>Hình thức tanh toán</th>
    <th>Ghi chú</th>
  </tr>
  </tr>
  <c:forEach items="${result}" var="result" varStatus="status">
    <tr>
      <td>${status.count}</td>
      <td>${result.id}</td>
      <td>${result.tenantName}</td>
      <td>${result.phoneNumber}</td>
      <td>${result.starDate}</td>
      <td>${result.paymentType}</td>
      <td>${result.notes}</td>
    </tr>
  </c:forEach>
</table>
<p><a href="rental-rooms">Quay lại trang chủ</a></p>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
