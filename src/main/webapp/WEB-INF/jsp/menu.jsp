<%--
  Created by IntelliJ IDEA.
  User: toustsik
  Date: 04.06.2021
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <c:url value="/hello" var="hello"/>
    <c:url value="/list" var="list"/>
    <c:url value="/newcaradd1" var="newcar"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <ul class="nav justify-content-center">
        <li class="nav-item">
            <a id="welcome" class="nav-link disabled" href="${hello}">первая</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${list}">список</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${newcar}">добавить</a>
        </li>
        <li class="nav-item">
            <c:url value="/" var="back"/>
            <a class="nav-link" href="${back}">главная</a>
        </li>
    </ul>
</div>

