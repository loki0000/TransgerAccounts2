
<%@ page import="on.javafeizhao.abo.OperationalData" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="on.javafeizhao.servlet.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/16
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <title>转账</title>
    <link rel="stylesheet" type="text/css" href="css/payPage.css"/>
    <script src="js/payPage.js"></script>
</head>
<body>

    <div id="box">
        <table border="1">
            <tr>
                <td style="color: black">name</td>
                <td style="color: black">Gender</td>
                <td style="color: black">Money</td>
            </tr>
            <%
                OperationalData od=new OperationalData();
                List<User> list =od.getComplete();
                session.setAttribute("list",list);
            %>
            <c:forEach begin="0" end="2" var="i">
            <tr>
                <td>${sessionScope.list[i].username}</td>
                <td>${sessionScope.list[i].gender}</td>
                <td>${sessionScope.list[i].money}<span style="color: red">￥</span></td>
                <td ><a href="##" onclick="show()">转账</a></td>
            </tr>
            </c:forEach>
        </table>
    </div>

    <div id="popub">

    </div>

    <div id="pay" align="center">
        <img src="image/ico.png" onclick="hide()"/><br/>
        <form action="/demo/pay" method="post">
        转出账户：<input type="text" name="username"/><br/>
        转入账户：<input type="text" name="username2"/><br/>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;金额：<input type="text" name="money"/><br/>
        <input type="submit" value="转账"/><br/>
        </form>
    </div>

</body>
</html>
