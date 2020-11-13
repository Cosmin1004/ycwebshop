<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>young.culture</title>
    <style> <%@include file="/WEB-INF/css/style.css"%> </style>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">YoungCulture Web Shop</a>
        </div>
        <ul class="nav navbar-nav" style="position: center">
            <li class="active"><a href="#">All products</a></li>
            <li><a href="#">Automotive</a></li>
            <li><a href="#">Clothing and shoes</a></li>
            <li><a href="#">Computers</a></li>
            <li><a href="#">Phones</a></li>
            <li><a href="#">Electronics</a></li>
            <li><a href="#">Food</a></li>
            <li><a href="#">Health and beauty</a></li>
            <li><a href="#">Home and garden</a></li>
        </ul>
    </div>
</nav>

<div class="container" style="margin-top: 40px">
    <div class="table-responsive">
        <table class="table table-hover table-sm table-striped">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Category</th>
                    <th scope="col">Description</th>
                    <th scope="col">Price</th>
                </tr>
            </thead>
            <c:forEach var="product" items="${products}">
                <c:set var="categoryTemp1" value="${product.category}"/>
                <c:set var="categoryTemp2" value="${fn:replace(categoryTemp1, '_', ' ')}"/>
                <c:set var="category" value="${fn:toLowerCase(categoryTemp2)}"/>
                <tr>
                    <td>${product.name}</td>
                    <td style="text-transform: capitalize">${category}</td>
                    <td>${product.description}</td>
                    <td>${product.price }</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>

<jsp:include page="/footer.jsp"/>
</html>