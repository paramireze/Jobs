<%@ page import="jobs.Application" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'application.label', default: 'Application')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>

<div id="show-application" class="content scaffold-show" role="main">
    <h1>Submitted Application For ${applicationInstance.user.username}</h1>
    <g:if test="${flash.message}">
        <div class="bg-success" style="margin-bottom: 20px;" role="status">${flash.message}</div>
    </g:if>
    <div class="form-horizontal">
        <div class="form-group">
            <label class="col-sm-2 control-label">Job Position</label>
            <div class="col-sm-10">${applicationInstance?.jobPost} - ${applicationInstance?.jobPost?.job?.category}</div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Position</label>
            <div class="col-sm-10">${applicationInstance?.jobPost?.employmentType}</div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Salary Range</label>
            <div class="col-sm-10">${applicationInstance?.jobPost?.salaryRange}</div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Post Start - Post End</label>
            <div class="col-sm-10">${applicationInstance?.jobPost?.postStart} - ${applicationInstance?.jobPost?.postEnd}</div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Status</label>
            <div class="col-sm-10">${applicationInstance?.status}</div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Date Submitted</label>
            <div class="col-sm-10">${applicationInstance?.dateCreated}</div>
        </div>

    </div>

    <g:if test="${applicationInstance?.resume}">
        <h2>Resume</h2>
        <hr />
        ${raw(documentInstance?.body)}
        <div >${raw(applicationInstance?.resume?.body)}</div>
    </g:if>

    <g:if test="${applicationInstance?.coverLetter}">
        <h2>Cover Letter</h2>
        <hr />
        <div >${raw(applicationInstance?.coverLetter?.body)}</div>
    </g:if>

    <g:if test="${applicationInstance?.freeText}">
        <h2>Free Text Field</h2>
        <hr />
        <div >${raw(applicationInstance?.freeText)}</div>
    </g:if>

    <hr />
    <g:form url="[resource: applicationInstance, action: 'delete']" method="DELETE">
        <fieldset class="buttons">
            <g:link class="btn btn-default" action="edit" resource="${applicationInstance}"><g:message
                    code="default.button.edit.label" default="Edit"/></g:link>
            <g:actionSubmit class="btn btn-danger" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
