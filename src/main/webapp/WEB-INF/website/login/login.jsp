<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!-- 需要加上isELIgnore="false"才能解析EL表达式 -->
<html>
<head>
    <title>User Login</title>
</head>
<body>
<c:if test="${param.login_error != null}">
  <div style="color: red;" id="errorMessage">
    <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
  </div>
</c:if>
<form name="f" action="<c:url value='j_spring_security_check'/>" method="POST">
    <table>
        <tr>
            <td>User name:</td>
            <td>
                <input type='text' name='j_username'
                       value='<c:if test="${param.login_error != null}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>'/>
            </td>
        </tr>
        <tr>
            <td>password:</td>
            <td><input type='password' name='j_password'></td>
        </tr>
        <tr>
            <td>
                <input type="checkbox" name="_spring_security_remember_me"></td>
            <td>remember me
            </td>
        </tr>
        <tr>
            <td colspan='2' align="center">
                <input name="submit" type="submit">
                <input name="reset" type="reset">
            </td>
        </tr>
    </table>
</form>
</body>
</html>