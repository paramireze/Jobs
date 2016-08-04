<%@ page import="jobs.JobPost" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'jobPost.label', default: 'JobPost')}"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body>

<div id="edit-jobPost" class="content scaffold-edit" role="main">
    <h1>Edit Page</h1>
    <g:if test="${flash.message}">
        <div class="bg-success" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${jobPostInstance}">
        <ul class="errors" role="alert">
            <g:eachError bean="${jobPostInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                        error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form url="[resource: jobPostInstance, action: 'update']" method="PUT">
        <g:hiddenField name="version" value="${jobPostInstance?.version}"/>
        <fieldset class="form">
            <g:render template="form"/>
        </fieldset>
        <fieldset>
            <g:actionSubmit class="btn btn-block btn-info" action="update"
                            value="Update"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
