<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>young.culture</title>
    <style> <%@include file="/WEB-INF/css/style.css"%> </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="centerCustom">
        <div class="btn-group">
            <form action="${pageContext.request.contextPath}/product" method="get">
                <button type="submit" class="btn btn-primary" name="categoryButton"
                        value="all">ALL
                </button>
                <button type="submit" class="btn btn-primary" name="categoryButton"
                        value="automotive">Automotive
                </button>
                <button type="submit" class="btn btn-primary" name="categoryButton"
                        value="clothingAndShoes">Clothing and shoes
                </button>
                <button type="submit" class="btn btn-primary" name="categoryButton"
                        value="computers">Computers
                </button>
                <button type="submit" class="btn btn-primary" name="categoryButton"
                        value="phones">Phones
                </button>
                <button type="submit" class="btn btn-primary" name="categoryButton"
                        value="electornics">Electronics
                </button>
                <button type="submit" class="btn btn-primary" name="categoryButton"
                        value="food">Food
                </button>
                <button type="submit" class="btn btn-primary" name="categoryButton"
                        value="healthAndBeauty">Health and beauty
                </button>
                <button type="submit" class="btn btn-primary" name="categoryButton"
                        value="homeAndGarden">Home and garden
                </button>
            </form>
        </div>
    </div>
</nav>

<div class="container" style="margin-top: 40px">
    <c:if test="${fn:length(products) > 0}">
        <div class="table-responsive">
            <table class="table table-hover table-sm table-striped">
                <thead class="theadCustom">
                <tr>
                    <th scope="col">Name</th>
                    <c:if test="${rendered == true}">
                        <th scope="col">Category</th>
                    </c:if>
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
                        <c:if test="${rendered == true}">
                            <td style="text-transform: capitalize">${category}</td>
                        </c:if>
                        <td>${product.description}</td>
                        <td>${product.price }</td>
                        <td>
                            <form class="centerCustom" action="${pageContext.request.contextPath}/product"
                                  method="post">
                                <button type="submit" class="btn btn-success"
                                        name="productNameFromButton"
                                        value="${product.name}">Add to cart
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:if>
    <c:if test="${fn:length(products) == 0}">
        <img class="imageCustom" alt="No product found..."
             src="${pageContext.request.contextPath}/img/noProducts.png"/>
    </c:if>
</div>
</body>

<jsp:include page="/footer.jsp"/>
</html>