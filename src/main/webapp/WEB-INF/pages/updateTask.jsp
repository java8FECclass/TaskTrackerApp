<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

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
			<!-- Split button -->
			<c:choose>
				<c:when test="${task.assignedTo == 'UN-ASSIGNED'}">
					<a href="${contextPath}/updateAssignedTo/${task.taskId}/${name}">
						<span class="btn btn-primary">Assign</span>
					</a>
				</c:when>
				<c:otherwise>
					<!-- link buttons to code in TaskController.java -->
					<a
						href="${contextPath}/updateStatus/${task.taskId}/IN-PROGRESS/${name}">
						<span class="btn btn-warning">IN-PROGRESS</span>
					</a>

					<a
						href="${contextPath}/updateStatus/${task.taskId}/COMPLETED/${name}">
						<span class="btn btn-success">COMPLETED</span>
					</a>
				</c:otherwise>
			</c:choose>



		</div>
	</div>




</body>
</html>