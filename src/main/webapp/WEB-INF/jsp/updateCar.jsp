<%--
  Created by IntelliJ IDEA.
  User: toustsik
  Date: 15.06.2021
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Обновление</title>
</head>
<body>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<div class="container text-center" >
    <form  action="updateCar" method="post">
        <br/>
        <label class="sr-only" for="idInp">ID</label>
        <input id="idInp" name="idd" readonly ="true" class="form-control" placeholder="ID" value = "<c:out value="${idd}"/>"/>
        <br/>
        <label class="sr-only" for="nameInp">NAME</label>
        <input id="nameInp" name="name" class="form-control" placeholder="NAME"/>
        <br>
        <label class="sr-only" for="assessedValueInp">assessedValue</label>
        <input id="assessedValueInp" name="assessedValue" type="number" min=1 placeholder="ASSESSED_VALUE" class="form-control"/>
        <br>
        <label class="sr-only" for="categoryInp">category</label>
        <input id="categoryInp" name="category" type="text" maxlength="1" placeholder="CATEGORY" class="form-control"/>
        <br><br>
        <input name="action" type="submit" value="edit"/>
    </form>
</div>
</body>
</html>
