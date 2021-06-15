<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: toustsik
  Date: 14.06.2021
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>новый</title>

</head>
<body>
<div class="container text-center">
    <c:import url="/WEB-INF/jsp/menu.jsp"/>

    <form action="newcaradd1" method="post">
        <label class="sr-only" for="nameInp">NAME</label>
        <input id="nameInp" name="name" class="form-control" placeholder="NAME"/>
        <br>
        <label class="sr-only" for="assessedValueInp">assessedValue</label>
        <input id="assessedValueInp" name="assessedValue" type="number" min=1 placeholder="ASSESSED_VALUE" class="form-control"/>
        <br>
        <label class="sr-only" for="categoryInp">category</label>
        <input id="categoryInp" name="category" type="text" maxlength="1" placeholder="CATEGORY" class="form-control"/>
        <br><br>
        <input name="action" type="submit" value="add" class="bullet-button"/>
    </form>
</div>
<div>
    <c:if test="${added==1}">
        Запись добавлена успешно:
        <table class="table table-bordered">
            <tr>
                <th>№</th>
                <th>id</th>
                <th>name</th>
                <th>as_val</th>
                <th>category</th>
                <th>int_rate</th>
            </tr>

            <c:forEach var="elem" items="${list2}" varStatus="status">
                <tr>
                    <td><c:out value="${status.count}"/></td>
                    <td><c:out value="${elem.id}"/></td>
                    <td><c:out value="${elem.name}"/></td>
                    <td><c:out value="${elem.assessedValue}"/></td>
                    <td><c:out value="${elem.category}"/></td>
                    <td><c:out value="${elem.interestRate}"/></td>
                </tr>
            </c:forEach>
        </table>

    </c:if>
</div>
</body>
</html>
