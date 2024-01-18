<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Overflow</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

</head>

<body>
	<header class="bg-dark p-2 mb-3">
		<h1 class="text-primary">DojoOverflow</h1>
		<a href="/questions" class="btn btn-primary">Dashboard</a>
	</header>
	<main class="text-center">
		<h2 class="mb-5"><c:out value="${ question.question }"/></h2>
		<div class="row">
			<div class="col">
				<p>Tags:
					<c:forEach items="${ question.tags }" var="tag">
					<span class="badge badge-warning">${ tag.subject }</span>
					</c:forEach>
				</p>
				<table class="table table-striped w-75 m-auto">
					<thead>
						<tr>
							<th>Answers</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ question.answers }" var="answer">
						<tr>
							<td>${ answer.answer }</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col">
				<h3 class="text-left">Add your answer:</h3>
				<form:form action="/answers" method="POST" modelAttribute="ans">
					<form:hidden path="question" value="${ question.id }"/>
					<div class="form-group row">
						<form:textarea class="col-8" rows="4" path="answer"/>
						<form:errors class="text-danger col-3" path="answer"/>
					</div>
					<input type="submit" class="btn btn-success" value="Submit Answer">
				</form:form>
			</div>
		</div>
		
	</main>
</body>

</html>