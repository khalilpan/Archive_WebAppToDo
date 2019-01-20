<%@ include file="fragments/header.jspf" %>
<%@ include file="fragments/navigation.jspf" %>

	<div class="container">
		<h1 align="center">Add New Todo for User
			${userNameReceivedFromForm}</h1>

		<form:form method="post" modelAttribute="todoToAdd">
			<fieldset class="form-group">
				<form:label path="description">description</form:label>
				<form:input path="description" type="text" class="form-control"
					required="required" />
			</fieldset>


			<fieldset class="form-group">

				<form:label path="targetDate">Target Date</form:label>
				<form:input path="targetDate" type="text" class="form-control"
					required="required" />

			</fieldset>
			<button type="submit" class="btn btn-success">Add</button>
		</form:form>
	</div>

<%@ include file="fragments/footer.jspf" %>