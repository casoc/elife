<html>
<head>
    <title>Users List</title>
</head>
<body>
<div>
    <h1>Users List:</h1>
    <table>
        <thead>
        <tr>
            <th>User Name</th>
            <th>Authorities</th>
            <th>Enabled</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
        <tr>
            <td>${user.username}</td>
            <td>
                <ul>
                    <#list user.authorities as authority>
                    <li>${authority.authority}</li>
                    </#list>
                </ul>
            </td>
            <td>${user.enabled?string}</td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>