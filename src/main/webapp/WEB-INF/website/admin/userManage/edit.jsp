<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>edit user</title>
</head>
<body>
<div class="page-header">
    <h1>
        Manage User
        <small>
            <i class="icon-double-angle-right"></i>
            update user
        </small>
    </h1>
</div>
<form:form action="/admin/users" method="put" cssClass="form-horizontal">
    <%@ include file="form.jsp" %>
</form:form>
</body>
</html>
