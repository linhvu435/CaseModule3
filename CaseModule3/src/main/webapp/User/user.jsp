<%--
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
<div
        class="bg-image"
        style="
    background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfwEhfVrPM_jJZDGwc920oVWGrtFzSFW9GfA&usqp=CAU ');
    background-size: cover;

  "
>
<div class="container mt-3">
    <h2></h2>
    <p></p>
    <table class="table">
    <a href="/LogOutServlet">Log Out</a><br>
        <thead>
        <form action="/CartServlet">
            <button type="submit">Cart</button>
        </form>

        <tr>
            <th>Id</th>
            <th>Type</th>
            <th>IMG</th>
            <th>Name</th>
            <th>price</th>
            <th>Amount</th>
            <th>Buy</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items = "${product}" var="pd">
            <form action="/CartServlet" method="post">
            <tr class="table-white">
                <td><input name="productId" value="${pd.id}" readonly></td>
                <td>${pd.type}</td>
                <td><img src="${pd.img}" height="200" width="250"></td>
                <td>${pd.name}</td>
                <td>${pd.price}</td>
                <td>${pd.amount}</td>
                <td>
                    <input placeholder="amount" name="number" >
                    <button type="submit">Buy</button>
                </td>
<%--                <td><a class="btn btn-danger" href=""><input type="text" placeholder="Number"></a></td>--%>
<%--                <td><a type="button" class="btn btn-danger" href="">Buy</a></td>--%>
            </tr>
            </form>
        </c:forEach>

        </tbody>
    </table>
</div>