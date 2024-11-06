<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Thêm người thuê phòng trọ</title>
  <!-- Thêm liên kết Bootstrap CSS -->
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container mt-5">
  <h1 class="text-center">Thêm người thuê phòng trọ</h1>
  <form action="rental-rooms?action=add" method="post">
    <div class="form-group">
      <label for="tenantName">Nhập tên người thuê trọ</label>
      <input type="text" id="tenantName" name="tenantName" class="form-control" pattern="^[A-Za-z\s]{5,50}$" required
             title="Tên người thuê trọ: Không chứa kí tự số và kí tự đặc biệt, độ dài cho phép từ 5 đến 50 kí tự.">
    </div>
    <div class="form-group">
      <label for="phoneNumber">Nhập số điện thoại</label>
      <input type="text" id="phoneNumber" name="phoneNumber" class="form-control" pattern="^\d{10}$" required
             title="Số điện thoại: Số điện thoại phải là các ký tự số và có độ dài là 10 ký tự số regex">
    </div>
    <div class="form-group">
      <label for="starDate">Nhập ngày thuê</label>
      <input type="text" id="starDate" name="starDate" class="form-control" pattern="^\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$" required
             title="Ngày bắt đầu thuê: định dạng yyyy-mm-dd, không cho phép nhập ngày quá khứ">
    </div>
    <div class="form-group">
      <label for="paymentId">Hình thức thanh toán</label>
      <select name="paymentId" id="paymentId" class="form-control">
        <c:forEach items="${payments}" var="payment">
          <option value="${payment.id}">${payment.name}</option>
        </c:forEach>
      </select>
    </div>
    <div class="form-group">
      <label for="notes">Ghi chú</label>
      <input type="text" id="notes" name="notes" class="form-control" pattern="^.{1,200}$" required
             title="Ghi chú: Cho phép nhập không quá 200 kí tự">
    </div>
    <button type="submit" class="btn btn-primary btn-block">Thêm</button>
  </form>
</div>

<!-- Thêm jQuery và Bootstrap JS để hỗ trợ tính năng tương tác của Bootstrap -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
