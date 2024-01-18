<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Overflow</title>
<link rel="stylesheet" href="https://bootswatch.com/4/spacelab/bootstrap.css">
<link rel="stylesheet" href="/css/style.css">
</head>

<body>
	<header class="bg-dark p-2 mb-3">
		<h1 class="text-primary">DojoOverflow</h1>
		<a href="/questions" class="btn btn-primary">Dashboard</a>
	</header>
	<main class="text-center">
		<h2>What is your question?</h2>
		<form:form class="w-75 m-auto" action="/questions" method="POST" modelAttribute="question">
			<div class="form-group row">
				<form:label class="col-3" path="question">Question:</form:label>
				<form:textarea class="form-control col-5" path="question"/>
				<form:errors class="col-4 text-danger" path="question"/>
			</div>
			<div class="form-group row">
				<form:label class="col-3" path="tags">Tags:</form:label>
				<form:input class="form-control col-5" path="tags"/>
				<form:errors class="col-4 text-danger" path="tags"/>
			</div>
			<input type="submit" class="btn btn-success" value="Add Question">
		</form:form>
	</main>
</body>

</html>