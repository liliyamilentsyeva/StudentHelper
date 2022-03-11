<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Students list</title>
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
<h2 class="sub-header">Students list</h2>
<div class="table-responsive">
  <table class="table table-striped">
    <thead>
    <tr>
      <th>First name</th>
      <th>Second name</th>
      <th>Average mark</th>
      <th>Group number</th>
      <th></th>
    </tr>
    </thead>
    <c:forEach items="${studList}" var="stud">
      <tr>
        <td><a href="StudentGet?id=${stud.id}">${stud.firstName}</a></td>
        <td><a href="StudentGet?id=${stud.id}">${stud.secondName}</a></td>
        <td><a href="StudentGet?id=${stud.id}">${stud.avgMark}</a></td>
        <td><a href="StudentGet?id=${stud.id}">${stud.groupNumber}</a></td>
        <td><a href="StudentDelete?id=${stud.id}">Delete</a></td>
      </tr>
    </c:forEach>
  </table>
  <form action="StudentGet" method="post">
    <input type="submit" value="Add" name="button">
  </form>
</div>
</body>
</html>