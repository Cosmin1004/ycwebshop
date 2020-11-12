<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<html>
    <head>
        <title>young.culture</title>
        <style> <%@include file="/WEB-INF/css/style.css"%> </style>
    </head>
    <body>
        <table align="center" cellpadding="2" cellspacing="2" border="1">
            <tr>
                <th>Name</th>
                <th>Category</th>
                <th>Description</th>
                <th>Price</th>
            </tr>
            <c:forEach var="product" items="${products}">
                <c:set var = "categoryTemp1" value = "${product.category}"/>
                <c:set var = "categoryTemp2" value = "${fn:replace(categoryTemp1, '_', ' ')}" />
                <c:set var = "category" value = "${fn:toLowerCase(categoryTemp2)}" />
                <tr>
                    <td>${product.name}</td>
                    <td style="text-transform: capitalize">${category}</td>
                    <td>${product.description}</td>
                    <td>${product.price }</td>
                </tr>
            </c:forEach>
    </table>
    </body>

    <jsp:include page="/footer.jsp"/>
</html>