<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Groups list</title>
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
<h2>Groups list</h2>
<div>
  <table>
    <thead>
    <tr>
      <th>Group number</th>
      <th>Average mark</th>
      <th></th>
    </tr>
    </thead>
    <c:forEach items="${groupList}" var="group">
      <tr>
        <td><a href="GroupGet?groupNumber=${group.groupNumber}">${group.groupNumber}</a></td>
        <td><a href="GroupGet?groupNumber=${group.groupNumber}">${group.avgMark}</a></td>
        <td><a href="GroupDelete?groupNumber=${group.groupNumber}">Delete</a></td>
      </tr>
    </c:forEach>
  </table>
  <form action="GroupGet" method="post">
    <input type="submit" value="Add" name="button">
  </form>
</div>
</body>
</html>