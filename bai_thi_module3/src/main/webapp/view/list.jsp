<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/6/2024
  Time: 9:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show List All</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<h1> Danh sách phòng trọ</h1>
<p><a href="rental-rooms?action=add">Tạo mới</a></p>
<p><a href="rental-rooms?action=search">Tìm kiếm theo tên người thuê</a></p>
<table class="table table-bordered table-striped table-hover">
  <tr>
    <th>Stt</th>
    <th>Mã phòng trọ</th>
    <th>Tên người thuê</th>
    <th>Số điện thoại</th>
    <th>Ngày bắt đầu thuê</th>
    <th>Hình thức tanh toán</th>
    <th>Ghi chú</th>
    <th>Xoá</th>
  </tr>
  <c:forEach items="${rentalRoomsList}" var="rental" varStatus="status">
    <tr>
      <td>${status.count}</td>
      <td>${rental.id}</td>
      <td>${rental.tenantName}</td>
      <td>${rental.phoneNumber}</td>
      <td>${rental.starDate}</td>
      <td>${rental.paymentType}</td>
      <td>${rental.notes}</td>
      <td>
        <button onclick="deleteRental(${rental.id},'${rental.tenantName}')" type="button" class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#deleteModal">
          Xoá
        </button>
      </td>
    </tr>
  </c:forEach>
</table>

<!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <form action="rental-rooms?action=delete" method="post">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="deleteModalLabel">Xoá sản phẩm</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <input hidden="hidden" type="text" name="id" id="id" size="5">
        <span>Bạn có muốn xoá sản phẩm </span><span id="name"></span><span> không?</span>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
        <button type="submit" class="btn btn-primary">Xoá</button>
      </div>
    </div>
    </form>
  </div>
</div>

<script>
  function deleteRental(id, name){
    document.getElementById("id").value = id;
    document.getElementById("name").innerText = name;
  }
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
