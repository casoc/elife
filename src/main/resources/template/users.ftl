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
