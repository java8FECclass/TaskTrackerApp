<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>

<!-- Link up the style sheet -->

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<link href="${contextPath}/resources/dist/css/bootstrap.css" rel="stylesheet">

<link href="${contextPath}/resources/dist/css/createTask.css" rel="stylesheet">
<!--  put in image -->


<title>Create a new task</title>
	
</head>

<body>


<div class="container" >


  <h2 class="text-warning">Create A Task by Entering The Description Below</h2>
  <p class="text-warning">Enter The Description</p>
  <!-- This creates a comment form that allows Admin to create task. -->
  <form:form action="saveTask" class="form-horizontal" method="post"
					modelAttribute="task">
    
    <br>
    <!-- This Is A Path Reference To Task Descriptions Model Object-->
    <form:textarea path="taskDescription" rows="5" placeholder="enter a task description" type="text"
									class="form-control" />
     <br>
     <!-- This Creates A Blank Line , That Puts A Space in between the form and the button -->
      <br>    
      <!-- Below is the creation of the button Admin must push to Create Task. -->
    <input type="submit" value="Submit new Task"
	class="btn btn-danger btn-block">
    
  </form:form>
</div>
	



</body>
</html>