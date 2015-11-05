<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<div>
    welcome <sec:authentication property="name"/>!!
    <span><a href="/j_spring_security_logout">login out</a></span>
</div>
<sec:authorize access="hasRole('ROLE_SUPER')">
    <a href="admin/admin.jsp">manage page</a>
</sec:authorize>
</body>
</html>
