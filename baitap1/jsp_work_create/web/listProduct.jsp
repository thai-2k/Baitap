<%--
  Created by IntelliJ IDEA.
  User: chien
  Date: 6/5/2020
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Prodcut</title>
</head>
<body>
<jsp:useBean id="chien" class="com.example.entity.Product" scope="session"/>

<jsp:setProperty name="chien" property="id"/>
<sql:setDataSource var="myDatasource" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://127.0.0.1:3306/t1808a1" user="root" password="" />
<sql:query var="result"  dataSource="${myDatasource}">
    SELECT * FROM product;
</sql:query>
<table>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>desc</td></tr>

    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td><c:out value="${row.id}"/></td>
            <td><c:out value="${row.name}"/></td>
             <td><c:out value="${row.pro_desc}"/></td></tr>


    </c:forEach>
</table>

</body>
</html>
