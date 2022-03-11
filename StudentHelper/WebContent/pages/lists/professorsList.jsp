<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Professors list</title>
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
  <h2>Professors list</h2>
  <div>
    <table class="table table-striped">
      <thead>
        <tr>
       	  <th>First name</th>
       	  <th>Father name</th>
       	  <th>Second name</th>
       	  <th>Birth date</th>
       	  <th>Average mark</th>
      	  <th></th>
        </tr>
      </thead>
      <c:forEach items="${professorList}" var="professor">
         <tr>
       	   <td><a href="ProfessorGet?id=${professor.id}">${professor.firstName}</a></td>
       	   <td><a href="ProfessorGet?id=${professor.id}">${professor.fatherName}</a></td>
           <td><a href="ProfessorGet?id=${professor.id}">${professor.secondName}</a></td>
           <td><a href="ProfessorGet?id=${professor.id}">${professor.birthDate}</a></td>
           <td><a href="ProfessorGet?id=${professor.id}">${professor.avgMark}</a></td>
           <td><a href="ProfessorDelete?id=${professor.id}">Delete</a></td>
         </tr>
      </c:forEach>
    </table>
      <form action="ProfessorGet" method="post">
          <input type="submit" value="Add" name="button">
      </form>
  </div>
</body>
</html>