<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Users List</title>
</head>
<body>
<div class="page-header">
    <h1>
        Manage User
        <small>
            <i class="icon-double-angle-right"></i>
            users list
        </small>
    </h1>
</div>
<!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->

        <div class="row">
            <div class="col-xs-12">
                <div class="table-responsive">
                    <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>User Name</th>
                            <th>Enabled</th>
                            <th></th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach items="${users}" var="user">
                            <tr>
                                <td><c:out value="${user.username}"/></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${user.enabled}">
                                            <span class="label label-sm label-success">enabled</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="label label-sm label-danger">disabled</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
                                        <button class="btn btn-xs btn-success" onclick="jumpTo('show', '${user.username}')">
                                            <i class="icon-info-sign bigger-120"></i>
                                        </button>

                                        <button class="btn btn-xs btn-info" onclick="jumpTo('edit', '${user.username}')">
                                            <i class="icon-edit bigger-120"></i>
                                        </button>

                                        <button class="btn btn-xs btn-danger" onclick="jumpTo('delete', '${user.username}')">
                                            <i class="icon-trash bigger-120"></i>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- /.table-responsive -->
            </div>
            <!-- /span -->
        </div>
        <!-- /row -->
        <!-- PAGE CONTENT ENDS -->
    </div>
    <!-- /.col -->
</div>
<!-- /.row -->
<a href="/admin/user/new">Create new user</a><br/>
<a href="/admin/users.pdf">Download Users PDF</a>
<script>
    function jumpTo(target, username) {
        if (target == 'show') {
            window.location = '/admin/user/' + username;
        } else if (target == 'edit') {
            window.location = '/admin/user/' + username + '/edit';
        } else {
            if(confirm("Are you sure delete it?")) {
                window.location = '/admin/user/' + username + '/delete';
            }
        }
    }
</script>
</body>
</html>