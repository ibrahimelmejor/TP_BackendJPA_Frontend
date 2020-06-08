<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<table>
    <form action = "/ajoutEmployee" method = "post">
        <tr>
            <td>
                <label>Nom employé</label>
            </td>
            <td>
                <input type = "text" name = "nomEmploye" value = <%=request.getParameter("employeeName") %>>
            </td>
        </tr>
        <tr>
            <td>
                <label>Nom départment</label>
            </td>
            <td>
                <input type = "text" name = "nomDepartement" value = <%=request.getParameter("employeeId") %>>
            </td>
        </tr>
        <tr>
            <td colspan = "2">
                <input type = "submit" value = "Envoyer">
            </td>
            <td></td>
        </tr>
    </form>
</table>
</body>
</html>