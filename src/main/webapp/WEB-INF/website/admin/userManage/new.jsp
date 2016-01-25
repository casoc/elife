<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>create user</title>
</head>
<body>
<div class="page-header">
    <h1>
        Manage User
        <small>
            <i class="icon-double-angle-right"></i>
            create user
        </small>
    </h1>
</div>
<form action="/admin/users" method="post" class="form-horizontal">
    <%@ include file="form.jsp" %>
</form>
</body>
</html>
