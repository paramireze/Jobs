
<%@ page import="jobs.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="show-user" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="bg-success" role="status">${flash.message}</div>
			</g:if>
			<div class="form-horizontal">
				<div class="form-group">
					<label class="col-sm-2 control-label">User Name</label>
					<div class="col-sm-10">${userInstance.username}</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label"><g:message code="user.accountExpired.label" default="Account Expired" /></label>
					<div class="col-sm-10"><g:formatBoolean boolean="${userInstance?.accountExpired}" /></div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label"><g:message code="user.accountLocked.label" default="Account Locked" /></label>
					<div class="col-sm-10"><g:formatBoolean boolean="${userInstance?.accountLocked}" /></div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label"><g:message code="user.address.label" default="Address" /></label>
					<div class="col-sm-10"><g:fieldValue bean="${userInstance}" field="address"/>, <g:fieldValue bean="${userInstance}" field="city"/>, <g:fieldValue bean="${userInstance}" field="state"/>, <g:fieldValue bean="${userInstance}" field="zip"/></div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label"><g:message code="user.email.label" default="Email" /></label>
					<div class="col-sm-10"><g:fieldValue bean="${userInstance}" field="email"/></div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label"><g:message code="user.phone.label" default="Phone" /></label>
					<div class="col-sm-10"><g:fieldValue bean="${userInstance}" field="phone"/></div>
				</div>

			</div>

			<g:if test="${userInstance?.applications}">
				<h2>Applications</h2>
				<table class="table table-bordered table-hover table-striped">
					<thead>
						<tr>
							<th><g:message code="application.jobPost.label" default="Job Post"/></th>

							<th><g:message code="application.status.label" default="Status"/></th>
							<th><g:message code="application.dateCreated.label" default="Date Submitted"/></th>

							<th><g:message code="application.user.label" default="User"/></th>
						</tr>
					</thead>
					<tbody>
						<g:each in="${userInstance.applications}" var="applicationInstance">
							<tr>
								<td><g:link controller="application" action="show" id="${applicationInstance.id}">${applicationInstance?.encodeAsHTML()}</g:link></td>
								<td>${fieldValue(bean: applicationInstance, field: "status")}</td>

								<td>${fieldValue(bean: applicationInstance, field: "dateCreated")}</td>

								<td>${fieldValue(bean: applicationInstance, field: "user")}</td>
							</tr>
						</g:each>

					</tbody>
				</table>
			</g:if>

			<g:if test="${userInstance?.applications}">
				<h2>Documents</h2>
				<table class="table table-bordered table-hover table-striped">
					<thead>
					<tr>
						<th>Title</th>
						<th>Belongs To</th>
						<th>Created</th>
						<th>Type</th>
					</tr>
					</thead>
					<tbody>
					<g:each in="${userInstance.documents}" var="documentInstance">
						<tr>
							<td><g:link controller="document" action="show" id="${documentInstance.id}">${documentInstance?.encodeAsHTML()}</g:link></td>
							<td>${documentInstance.user}</td>

							<td>${fieldValue(bean: documentInstance, field: "dateCreated")}</td>

							<td>${fieldValue(bean: documentInstance, field: "type")}</td>

						</tr>
					</g:each>

					</tbody>
				</table>
			</g:if>

			

			<g:form url="[resource:userInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="btn btn-default" action="edit" resource="${userInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-danger" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
