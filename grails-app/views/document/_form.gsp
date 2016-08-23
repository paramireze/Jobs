<%@ page import="jobs.Document" %>


<div class="form-horizontal">
	<div class="form-group">
		<label class="col-sm-2 control-label"><g:message code="document.title.label" default="Title" /></label>
		<div class="col-sm-4"><g:textField class="form-control" name="title" required="" value="${documentInstance?.title}"/></div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label"><g:message code="document.filePath.label" default="File Path" /></label>
		<div class="col-sm-4"><g:textField class="form-control" name="filePath" value="${documentInstance?.filePath}"/></div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label"><g:message code="document.type.label" default="Type" />
			<span class="required-indicator">*</span></label>
		<div class="col-sm-4">
			<g:select id="type" name="type.id"  from="${jobs.DocumentType.list()}" optionKey="id" required="" value="${documentInstance?.type?.id}" class="many-to-one form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">
			<g:message code="document.user.label" default="User" />
			<span class="required-indicator">*</span>
		</label>
		<div class="col-sm-4"><g:select id="user" name="user.id" from="${jobs.User.list()}" optionKey="id" required="" value="${documentInstance?.user?.id}" class="many-to-one form-control"/></div>
	</div>

	<div class="form-group">
		<label for="body" class="col-sm-2 control-label">Document Body</label>
		<div class="col-sm-10">
			<ckeditor:editor name="body" height="400px" width="80%">
				${documentInstance?.body}
			</ckeditor:editor>
		</div>
	</div>
</div>

