<%@ include file="fragments/header.jspf" %>
<%@ include file="fragments/navigation.jspf" %>

	<div class="container">
		<h1 align="center">Update Todo For User
			${userNameReceivedFromForm}</h1>

		<form:form method="post" modelAttribute="todoToUpdate">
			<fieldset class="form-group">
				<form:hidden path="id" />

				<form:label path="description">description</form:label>
				<form:input path="description" type="text" class="form-control"
					required="required" />

			</fieldset>

			<fieldset class="form-group">

				<form:label path="targetDate">Target Date</form:label>
				<form:input path="targetDate" type="text" class="form-control"
					required="required" />

			</fieldset>

			<form:hidden path="isDone" />
			<button type="submit" class="btn btn-success">Update</button>
		</form:form>
	</div>

<%@ include file="fragments/footer.jspf" %>