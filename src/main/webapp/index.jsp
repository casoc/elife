<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<body>
<h2>Hello World!</h2>
<sec:authorize access="hasRole('ROLE_SUPER')">
    <a href="admin/admin.jsp">manage page</a>
</sec:authorize>
</body>
</html>
