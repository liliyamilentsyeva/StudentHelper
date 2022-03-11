<html>
<head>
    <title>User form</title>
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
    <form action="UserEdit" method="post" class="form-signin">
        <h2>${msg}</h2>
        <input type="hidden" name="user" value="${user.user}">
        <label>User: </label>
        <input type="text" name="newUser" value="${user.user}"><br>
        <label>Password: </label>
        <input type="text" name="password" value="${user.password}"><br>
        <label>Role: </label>
        <input type="text" name="role" value="${user.role}"><br>
        <input type="submit" value="Back" name="button" class="btn btn-primary">
        <input type="submit" value="Update" name="button" class="btn btn-success">
        <input type="submit" value="Delete" name="button" class="btn btn-warning">
    </form>
</div>
</body>
</html>