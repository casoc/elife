<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>edit user</title>
</head>
<body>
  <form:form action="/users" method="put">
      <%@ include file="form.jsp"%>
  </form:form>
</body>
</html>
