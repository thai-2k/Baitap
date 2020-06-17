<%--
  Created by IntelliJ IDEA.
  User: chien
  Date: 6/5/2020
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${sessionScope.chien == null}">
    <jsp:forward page="login.jsp"></jsp:forward>
</c:if>
<jsp:useBean id="chien" class="com.example.entity.User" scope="session"/>
<jsp:useBean id="product" class="com.example.entity.Product" scope="session"/>

<h2>Welcome: <jsp:getProperty name="chien" property="password"/></h2>
<h2>Product Create: <jsp:getProperty name="product" property="id"/></h2>
<h2>Product Create: <jsp:getProperty name="product" property="name"/></h2>
<h2>Product Create: <jsp:getProperty name="product" property="pro_desc"/></h2>



</body>
</html>
