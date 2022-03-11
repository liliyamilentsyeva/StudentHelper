<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Marks list</title>
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
<h2>Marks list</h2>
<div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Study ID</th>
            <th>Student ID</th>
            <th>Date</th>
            <th>Professor ID</th>
            <th>Mark</th>
            <th>Comments</th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${markList}" var="mark">
            <tr>
                <td><a href="MarkGet?id=${mark.id}">${mark.studyId}</a></td>
                <td><a href="MarkGet?id=${mark.id}">${mark.studentId}</a></td>
                <td><a href="MarkGet?id=${mark.id}">${mark.date}</a></td>
                <td><a href="MarkGet?id=${mark.id}">${mark.professorId}</a></td>
                <td><a href="MarkGet?id=${mark.id}">${mark.mark}</a></td>
                <td><a href="MarkGet?id=${mark.id}">${mark.comments}</a></td>
                <td><a href="MarkDelete?id=${mark.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <form action="MarkGet" method="post">
        <input type="submit" value="Add" name="button">
    </form>
</div>
</body>
</html>