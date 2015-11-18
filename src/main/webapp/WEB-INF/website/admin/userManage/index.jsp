<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
  <head>
    <title>Users List</title>
  </head>
  <body>
  <table>
    <thead>
    <tr>
      <th>User Name</th>
      <th>Enabled</th>
      <th colspan="2"></th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${users}" var="user">
    <tr>
      <td><c:out value="${user.username}"/></td>
      <td><c:out value="${user.enabled}"/></td>
      <td><a href="/user/<c:out value='${user.id}/edit'/>">Edit</a></td>
      <td><a href="/user/<c:out value='${user.id}/delete'/>">Destroy</a></td>
    </tr>
    </c:forEach>
    </tbody>
  </table>
  <a href="/admin/user/new">Create new user</a>
  </body>
</html>