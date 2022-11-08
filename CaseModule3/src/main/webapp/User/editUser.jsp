<%--
  Created by IntelliJ IDEA.
  User: VuHongLinh
  Date: 05/11/2022
  Time: 6:16 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <form action="/editAccountServlet" method="post">
        <table>
            <h1>Edit Product</h1>
            <tr>
                <td>Nhập id</td>
                <td><input name="id" value="${a.id}" readonly ></td>
            </tr>
            <tr>
                <td>Nhập Username</td>
                <td><input name="username" value="${a.username}"></td>
            </tr>
            <tr>
                <td>Nhập PassWord</td>
                <td><input name="password" value="${a.password}"></td>
            </tr>
            <tr>
                <td>Nhập Address</td>
                <td><input name="address" value="${a.address}"></td>
            </tr>
            <tr>
                <td>Nhập Birthday</td>
                <td><input name="birthday" value="${a.birthday}" readonly></td>
            </tr>
            <tr>
                <td>Nhập PhoneNumber</td>
                <td><input name="phonenumber" value="${a.phonenumber}"></td>
            </tr>
            <tr>
                <td>Nhập id_role</td>
                <td><input name="id_role" value="${a.id_role}"></td>
            </tr>
            <button type="submit">Submit</button>
        </table>
    </form>

</head>
<body>
<div
        class="bg-image"
        style="
        background-image:url('https://as2.ftcdn.net/v2/jpg/01/93/97/35/1000_F_193973590_XMJT3vKAMsXLgiQvm0uVaSMltwz3pIfD.jpg');
     background-size: cover;

 "
>
</body>
</html>
