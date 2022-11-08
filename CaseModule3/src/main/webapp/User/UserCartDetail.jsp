<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: VuHongLinh
  Date: 04/11/2022
  Time: 11:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container mt-3">
    <h2>Contextual Classes</h2>
    <p>Contextual classes can be used to color the table, table rows or table cells. The classes that can be used are: .table-primary, .table-success, .table-info, .table-warning, .table-danger, .table-active, .table-secondary, .table-light and .table-dark:</p>
    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Type</th>
            <th>IMG</th>
            <th>Name</th>
            <th>price</th>
            <th>Buy Amount</th>
            <th>TotalPrice</th>
        </tr>
        </thead>
        <tbody>
        <div
                class="bg-image"
                style="
    background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTt_vQzSh8E29nBwD9zFKozNcqWm577QlBwlA&usqp=CAU');
    height: 100vh;
  "
        >
            <form action="/CartServlet" method="post">
                <c:forEach items="${productList}" var="product" varStatus="loop">
                    <tr class="table-white">
                        <td><input name="productId" value="${product.id}" readonly></td>
                        <td>${product.type}</td>
                        <td><img src="${product.img}" height="200" width="250"></td>
                        <td>${product.name}</td>
                        <td>${product.price}</td>
                      <c:forEach items="${cartDetails}" var="cart">
                          <c:if test="${cart.id_product == product.id}">
                              <td>${cart.amount}</td>
                          </c:if>
                      </c:forEach>
                        <td>${prices.get(loop.index)}</td>
                    </tr>
                </c:forEach>

            </form>

        </tbody>
    </table>
    <td>${totalPrice}</td>
</div>