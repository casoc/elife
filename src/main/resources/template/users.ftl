<html>
<head>
    <title>Users Report</title>
</head>
<body>
<h3>Users List</h3>

<div>
    <table>
        <thead>
        <tr>
            <td>Name</td>
            <td>Authority</td>
            <td>Enable</td>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
        <tr>
            <td>${user.name}</td>
            <td>${user.authority.authority}</td>
            <td>${user.enable}</td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>