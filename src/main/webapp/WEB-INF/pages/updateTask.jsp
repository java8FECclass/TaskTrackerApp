<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- This line of code imports the JSTL core lib to perform C: refs -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- The next line of code imports the necessary tags for form:form  -->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- This Titles The Page -->
<title>Update Task</title>
<!-- Adds the style sheet to make button red -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />

</head>

<body>
	<div class="container">
		<div class="card">
			<div class="card-block">
				<h4 class="card-title">Task Info</h4>
				<p class="card-text">TaskId: ${task.taskId}</p>
				<p class="card-text">TaskDescription: ${task.taskDescription}</p>
				<p class="card-text">Assigned To: ${task.assignedTo}</p>
				<p class="card-text">Status: ${task.status}</p>

			</div>
			<c:choose>
			<c:when test="${task.assignedTo == 'UN-ASSIGNED'}">
			<button type="button" class="btn btn-primary">Assign</button>
			</c:when>
			<c:otherwise>
			<button type="button" class="btn btn-success">Completed</button>
			<button type="button" class="btn btn-warning">In-Progress</button>
			</c:otherwise>
			</c:choose>
			
		</div>
	</div>




</body>
</html>