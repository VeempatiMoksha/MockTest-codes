<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a Task</title>
</head>
    <form action="CreateTaskServlet" method="post">
        <label for="title">Task Title:</label>
        <input type="text" id="title" name="title" required><br><br>

        <label for="description">Task Description:</label>
        <textarea id="description" name="description" required></textarea><br><br>

        <label for="dueDate">Due Date:</label>
        <input type="date" id="dueDate" name="dueDate" required><br><br>

        <label for="priority">Priority:</label>
        <select id="priority" name="priority" required>
            <option value="High">High</option>
            <option value="Medium">Medium</option>
            <option value="Low">Low</option>
        </select><br><br>

        <button type="submit" id="createTask">Create Task</button>
    </form>
</body>
</html>
