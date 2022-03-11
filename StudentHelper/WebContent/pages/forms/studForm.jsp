<html>
<head>
  <title>Student form</title>
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
	<form action="StudentEdit" method="post" class="form-signin">
	  <h2>${msg}</h2>
      <input type="hidden" name="id" value="${stud.id}">
	  <label>First name: </label>
	  <input type="text" name="firstName" value="${stud.firstName}"><br>
	  <label>Second name: </label>
	  <input type="text" name="secondName" value="${stud.secondName}"><br>
	  <label>Average mark: </label>
	  <input type="number" name="avgMark" value="${stud.avgMark}"><br>
      <label>Group number: </label>
      <input type="text" name="groupNumber" value="${stud.groupNumber}"><br>
	  <input type="submit" value="Back" name="button" class="btn btn-primary">
	  <input type="submit" value="Update" name="button" class="btn btn-success">
	  <input type="submit" value="Delete" name="button" class="btn btn-warning">
	</form>
  </div>
</body>
</html>