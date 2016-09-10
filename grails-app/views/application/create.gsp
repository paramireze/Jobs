<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'application.label', default: 'Application')}"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>
    <ckeditor:resources/>
</head>

<body>
<div id="create-application" class="content scaffold-create" role="main">
    <div class="jumbotron"><h2>Apply for ${applicationInstance.jobPost}</h2></div>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${applicationInstance}">
        <ul class="errors" role="alert">
            <g:eachError bean="${applicationInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                        error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form class="form-horizontal" url="[resource: applicationInstance, action: 'save']">
            <g:render template="form"/>
            <fieldset class="buttons">
            <g:submitButton name="create" class="btn btn-lg btn-success" value="${message(code: 'default.button.create.label', default: 'Create')}"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
