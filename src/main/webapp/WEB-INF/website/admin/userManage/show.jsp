<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>show user</title>
</head>
<body>
    <div class="field">
        <label for="username">User Name:</label>
        <input type="text" name="username" id="username" value="<c:out value='${user.username}'/>" readonly/>
    </div>
    <div class="field">
        <label for="enabled">Enabled:</label>
        <input type="text" name="enabled" id="enabled" value="<c:out value='${user.enabled}'/>" readonly/>
    </div>
    <div><a href="/admin/users">back index</a></div>
</body>
</html>