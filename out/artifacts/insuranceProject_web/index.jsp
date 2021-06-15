<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<fmt:setBundle basename="properties.resourse.properties" var="rb"/>
<html>
<head>
    <title>
        приветствие
    </title>

    <c:url value="css/style.css" var="cssUrl" scope="application"/>
    <link href="${cssUrl}" rel="stylesheet"/>
    <div>
        <br>
        <c:url value="/img/image.png" var="imgUrl"/>
        <img src="${imgUrl}" class="imgSize center"/>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </div>
    <div>
        <br>
    </div>
    <br>

</head>

<body>
<div class="container">
    <c:import url="WEB-INF/jsp/menu.jsp"/>

</div>

</body>
</html>