<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>user detail</title>
</head>
<body>
<div class="page-header">
    <h1>
        Manage User
        <small>
            <i class="icon-double-angle-right"></i>
            user detail
        </small>
    </h1>
</div>
<div class="form-group">
    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> User Name </label>

    <div class="col-sm-9">
        <input type="text" id="form-field-1" class="col-xs-10 col-sm-5" value="<c:out value='${user.username}'/>" disabled>
    </div>
</div>

<div class="form-group">
    <label class="col-sm-3 control-label no-padding-right" for="enabled">Enabled</label>
    <label class="col-sm-9">
        <c:choose>
            <c:when test="${!user.enabled}">
                <input id="enabled" name="enabled" class="ace ace-switch ace-switch-6" type="checkbox" disabled>
            </c:when>
            <c:otherwise>
                <input id="enabled" name="enabled" class="ace ace-switch ace-switch-6" type="checkbox" checked disabled>
            </c:otherwise>
        </c:choose>
        <span class="lbl"></span>
    </label>
</div>

<div>
    <a href="/admin/users">back index</a>
</div>

</body>
</html>