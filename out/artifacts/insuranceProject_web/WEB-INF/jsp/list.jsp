<%--
  Created by IntelliJ IDEA.
  User: volha
  Date: 5/28/2021
  Time: 9:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>list</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
    <c:url value="/css/style.css" var="cssUrl"/>
    <link href="${cssUrl}" rel="stylesheet"/>

</head>
<body>
<div class="container">
    <c:import url="/WEB-INF/jsp/menu.jsp"/>


    <table class="table table-bordered">

        <tr>
            <th>№</th>
            <th>id</th>
            <th>name</th>
            <th>as_val</th>
            <th>category</th>
            <th>
                <form action="list" method="post">
                    int_rate
                    <input name="action" type="submit" value="up"/>
                    <input name="action" type="submit" value="dn"/>
                </form>
            </th>
            <th>edit</th>
            <th>delete</th>
        </tr>

        <c:forEach var="elem" items="${list1}" varStatus="status">
            <tr>
                <td><c:out value="${status.count}"/></td>
                <td><c:out value="${elem.id}"/></td>
                <td><c:out value="${elem.name}"/></td>
                <td><c:out value="${elem.assessedValue}"/></td>
                <td><c:out value="${elem.category}"/></td>
                <td><c:out value="${elem.interestRate}"/></td>
                <td>
                    <form action="list" method="post">
                        <input name="action" type="submit" value="edit"/>
                        <input hidden name="id" value="${elem.id}">
                    </form>
                </td>
                <td>
                    <form action="list" method="post">
                        <input name="action" type="submit" value="delete"/>
                        <input hidden name="id" value="${elem.id}">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>