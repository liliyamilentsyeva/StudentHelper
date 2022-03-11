<html>
<head>
    <title>Group form</title>
</head>

<body>
<form action="Actions" method="post">
    <input type="submit" value="Groups" name="button">
    <input type="submit" value="Students" name="button">
    <input type="submit" value="Marks" name="button">
    <input type="submit" value="Professors" name="button">
    <input type="submit" value="Studies" name="button">
    <input type="submit" value="Users" name="button">
</form>
<div class="container">
    <form action="GroupEdit" method="post" class="form-signin">
        <h2>${msg}</h2>
        <input type="hidden" name="groupNumber" value="${group.groupNumber}">
        <label>Group number: </label>
        <input type="number" name="newGroupNumber" value="${group.groupNumber}"><br>
        <label>Average mark: </label>
        <input type="number" name="avgMark" value="${group.avgMark}"><br>
        <input type="submit" value="Back" name="button" class="btn btn-primary">
        <input type="submit" value="Update" name="button" class="btn btn-success">
        <input type="submit" value="Delete" name="button" class="btn btn-warning">
    </form>
</div>
</body>
</html>