
<%@ page import="jobs.Document" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'document.label', default: 'Document')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="show-document" class="content scaffold-show" role="main">
			<g:if test="${flash.message}">
			<div style="padding-bottom:20px; margin-top:20px; margin-bottom:20px;" class="bg-success" role="status">${raw(flash.message)}</div>
			</g:if>
			<h1><g:fieldValue bean="${documentInstance}" field="title"/></h1>


			<div class="form-horizontal">
				<div class="form-group">
					<label class="col-sm-2 control-label"><g:message code="document.user.label" default="User" /></label>
					<div class="col-sm-10"><g:link controller="user" action="show" id="${documentInstance?.user?.id}">${documentInstance?.user?.encodeAsHTML()}</g:link></div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label"><g:message code="document.filePath.label" default="File Path" /></label>
					<div class="col-sm-10"><g:fieldValue bean="${documentInstance}" field="filePath"/></div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label"><g:message code="document.body.label" default="Body" /></label>
					<div class="col-sm-10">${raw(documentInstance?.body)}</div>
				</div>
			</div>
			
			<g:form url="[resource:documentInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="btn btn-default" action="edit" resource="${documentInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-danger" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
