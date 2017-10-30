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
<title>Create Task</title>
</head>

<body>
<div class="container">
  <h2>Create A Task by Entering The Description Below</h2>
  <p>Enter The Description</p>
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
      <!-- Below is the creation of the button Admin must push to Create Task. -->>
    <input type="submit" value="Create Task"
	class="btn btn-success btn-block">
    
  </form:form>
</div>
	



</body>
</html>