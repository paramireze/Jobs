
<%@ page import="jobs.Document" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'document.label', default: 'Document')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>

		<table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th><g:message code="application.jobPost.label" default="Job Post"/></th>
					<th><g:message code="application.status.label" default="Status"/></th>
					<th><g:message code="application.user.label" default="User"/></th>
				</tr>
			</thead>
			<tbody>
				<g:each in="${applicationInstanceList}" status="i" var="applicationInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</g:each>
			</tbody>
		</table>

		<div id="show-document" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list document">
			
				<g:if test="${documentInstance?.body}">
				<li class="fieldcontain">
					<span id="body-label" class="property-label"><g:message code="document.body.label" default="Body" /></span>
					
						<span class="property-value" aria-labelledby="body-label"><g:fieldValue bean="${documentInstance}" field="body"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${documentInstance?.filePath}">
				<li class="fieldcontain">
					<span id="filePath-label" class="property-label"><g:message code="document.filePath.label" default="File Path" /></span>
					
						<span class="property-value" aria-labelledby="filePath-label"><g:fieldValue bean="${documentInstance}" field="filePath"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${documentInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="document.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${documentInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${documentInstance?.type}">
				<li class="fieldcontain">
					<span id="type-label" class="property-label"><g:message code="document.type.label" default="Type" /></span>
					
						<span class="property-value" aria-labelledby="type-label"><g:link controller="documentType" action="show" id="${documentInstance?.type?.id}">${documentInstance?.type?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${documentInstance?.user}">
				<li class="fieldcontain">
					<span id="user-label" class="property-label"><g:message code="document.user.label" default="User" /></span>
					
						<span class="property-value" aria-labelledby="user-label"><g:link controller="user" action="show" id="${documentInstance?.user?.id}">${documentInstance?.user?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:documentInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${documentInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
