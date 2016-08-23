<%@ page import="jobs.Document" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'document.label', default: 'Document')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
		<ckeditor:resources/>
	</head>
	<body>


	<div id="edit-document" class="content scaffold-edit" role="main">
			<h1><g:message code="default.edit.label" args="[entityName]" /> - ${documentInstance.title}</h1>
			<g:if test="${flash.message}">
				<div style="padding-bottom:20px; margin-bottom:20px;" class="bg-success" role="status">${raw(flash.message)}</div>			</g:if>
			<g:hasErrors bean="${documentInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${documentInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:documentInstance, action:'update']" method="PUT" >
				<g:hiddenField name="version" value="${documentInstance?.version}" />
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="btn btn-lg btn-success" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
