<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Studies list</title>
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
<h2 class="sub-header">Studies list</h2>
<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Hours</th>
            <th>Professor ID</th>
            <th>Average mark</th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${studyList}" var="study">
            <tr>
                <td><a href="StudyGet?id=${study.id}">${study.name}</a></td>
                <td><a href="StudyGet?id=${study.id}">${study.hours}</a></td>
                <td><a href="StudyGet?id=${study.id}">${study.professorId}</a></td>
                <td><a href="StudyGet?id=${study.id}">${study.avgMark}</a></td>
                <td><a href="StudyDelete?id=${study.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <form action="StudyGet" method="post">
        <input type="submit" value="Add" name="button">
    </form>
</div>
</body>
</html>