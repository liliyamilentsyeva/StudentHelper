<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Users list</title>
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
  <h2 class="sub-header">Users list</h2>
  <div class="table-responsive">
    <table class="table table-striped">
      <thead>
        <tr>
       	  <th>User</th>
       	  <th>Password</th>
       	  <th>Role</th>
      	  <th></th>
        </tr>
      </thead>
      <c:forEach items="${userList}" var="user">
         <tr>
       	   <td><a href="UserGet?user=${user.user}">${user.user}</a></td>
       	   <td><a href="UserGet?user=${user.user}">${user.password}</a></td>
           <td><a href="UserGet?user=${user.user}">${user.role}</a></td>
           <td><a href="UserDelete?user=${user.user}">Delete</a></td>
         </tr>
      </c:forEach>
    </table>
      <form action="UserGet" method="post">
          <input type="submit" value="Add" name="button">
      </form>
  </div>
</body>
</html>