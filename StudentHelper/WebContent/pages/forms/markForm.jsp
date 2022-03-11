<html>
<head>
    <title>Mark form</title>
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
<div>
    <form action="MarkEdit" method="post">
        <h2>${msg}</h2>
        <input type="hidden" name="id" value="${mark.id}">
        <label>Study ID: </label>
        <input type="text" name="studyID" value="${mark.studyId}"><br>
        <label>Student ID: </label>
        <input type="text" name="studentID" value="${mark.studentId}"><br>
        <label>Date: </label>
        <input type="date" name="markDate" value="${mark.date}"><br>
        <label>Professor ID: </label>
        <input type="text" name="professorID" value="${mark.professorId}"><br>
        <label>Mark: </label>
        <input type="number" name="mark" value="${mark.mark}"><br>
        <label>Comments: </label>
        <input type="text" name="comments" value="${mark.comments}"><br>
        <input type="submit" value="Back" name="button">
        <input type="submit" value="Update" name="button">
        <input type="submit" value="Delete" name="button">
    </form>
</div>
</body>
</html>