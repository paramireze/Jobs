<%@ page import="jobs.Document" %>



<div class="fieldcontain ${hasErrors(bean: documentInstance, field: 'body', 'error')} ">
	<label for="body">
		<g:message code="document.body.label" default="Body" />
		
	</label>
	<g:textField name="body" value="${documentInstance?.body}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: documentInstance, field: 'filePath', 'error')} ">
	<label for="filePath">
		<g:message code="document.filePath.label" default="File Path" />
		
	</label>
	<g:textField name="filePath" value="${documentInstance?.filePath}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: documentInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="document.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${documentInstance?.title}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: documentInstance, field: 'type', 'error')} required">
	<label for="type">
		<g:message code="document.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="type" name="type.id" from="${jobs.DocumentType.list()}" optionKey="id" required="" value="${documentInstance?.type?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: documentInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="document.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${jobs.User.list()}" optionKey="id" required="" value="${documentInstance?.user?.id}" class="many-to-one"/>

</div>

