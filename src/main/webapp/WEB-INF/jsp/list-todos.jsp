<%@ include file="fragments/header.jspf" %>
<%@ include file="fragments/navigation.jspf" %>

	<div class="container">
		<caption>your todos are</caption>
		<table class="table table-striped">

			<thead>
				<tr>
					<th>ID</th>
					<th>Description</th>
					<th>Target Date</th>
					<th>is it Done?</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<jstl:forEach items="${todos}" var="tempTodo">
					<tr>
						<td>${tempTodo.id}</td>
						<td>${tempTodo.description}</td>
						<td><fmt:formatDate value="${tempTodo.targetDate}"
								pattern="dd/MM/yyyy" /></td>
						<td>${tempTodo.isDone}</td>
						<td><a type="button" class="btn btn-success"
							href="/update-todo?idToUpdateTodo=${tempTodo.id}">Update</a></td>
						<td><a type="button" class="btn btn-warning"
							href="/delete-todo?idToDeleteTodo=${tempTodo.id}">Delete</a></td>
					</tr>
				</jstl:forEach>
			</tbody>
		</table>

		<div>
			<a class="button" href="/add-todo">add todo</a>
		</div>

	</div>

<%@ include file="fragments/footer.jspf" %>