<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>young.culture</title>
    <style> <%@include file="/WEB-INF/css/style.css"%> </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

    <script language="JavaScript">
        function afterAddToCart(product) {
            alert("Product " + product + " was added to the cart " +
                "(cart.txt from your Desktop) !");
        }
    </script>
</head>

<body>

<nav class="navbar navbar-inverse">
    <div class="center">
        <div class="btn-group">
            <form action="${pageContext.request.contextPath}/product" method="get">
                <button type="submit" class="btn btn-info" name="category"
                        value="all">ALL
                </button>
                <button type="submit" class="btn btn-primary" name="category"
                        value="automotive">Automotive
                </button>
                <button type="submit" class="btn btn-primary" name="category"
                        value="clothingAndShoes">Clothing and shoes
                </button>
                <button type="submit" class="btn btn-primary" name="category"
                        value="computers">Computers
                </button>
                <button type="submit" class="btn btn-primary" name="category"
                        value="phones">Phones
                </button>
                <button type="submit" class="btn btn-primary" name="category"
                        value="electronics">Electronics
                </button>
                <button type="submit" class="btn btn-primary" name="category"
                        value="food">Food
                </button>
                <button type="submit" class="btn btn-primary" name="category"
                        value="healthAndBeauty">Health and beauty
                </button>
                <button type="submit" class="btn btn-primary" name="category"
                        value="homeAndGarden">Home and garden
                </button>
            </form>
        </div>
    </div>
</nav>

<div id="wrapper">
    <div class="container" style="padding-bottom: 100px;">
        <c:if test="${fn:length(products) == 0}">
            <img class="image" alt="No product found..."
                 src="${pageContext.request.contextPath}/Images/noProducts.png"/>
        </c:if>
        <c:if test="${fn:length(products) > 0}">
            <img class="center" style="margin-bottom: 5px"
                 src="${pageContext.request.contextPath}/Images/youngCulture.jpg"
                 alt="YoungCulture">
            <div class="table-responsive">
                <table class="table table-hover table-sm table-striped">
                    <thead class="thead">
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
                        <c:set var="currency" value="Lei"/>
                        <c:if test="${product.category == 'AUTOMOTIVE'}">
                            <c:set var="currency" value="$"/>
                        </c:if>
                        <tr>
                            <td><b>${product.name}</b></td>
                            <c:if test="${rendered == true}">
                                <td style="text-transform: capitalize">${category}</td>
                            </c:if>
                            <td>${product.description}</td>
                            <td style="color: red; width: 100px;">${product.price} ${currency}</td>
                            <td>
                                <form class="center" action="${pageContext.request.contextPath}/product"
                                      method="post">
                                    <button type="submit" class="btn btn-success"
                                            onclick="afterAddToCart('${product.name}')"
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

    </div>
    <jsp:include page="/footer.jsp"/>
</div>

</body>
</html>