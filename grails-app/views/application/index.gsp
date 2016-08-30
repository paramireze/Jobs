<%@ page import="jobs.Application" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'application.label', default: 'Application')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>

<div id="list-application" class="content scaffold-list" role="main">
    <div class="jumbotron"><h1>Submitted Applications</h1></div>
    <g:if test="${flash.message}">
        <div class="bg-success" role="status">${flash.message}</div>
    </g:if>
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
        <g:each in="${applicationInstanceList}" status="i" var="applicationInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td><g:link controller="user" action="show" id="${user.id}">${fieldValue(bean: applicationInstance, field: "user")}</g:link></td>
                <td><g:link controller="application" action="show" params="[id: applicationInstance.id]">${fieldValue(bean: applicationInstance, field: "jobPost")}</g:link></td>
                <td>${fieldValue(bean: applicationInstance, field: "status")}</td>
                <td>${fieldValue(bean: applicationInstance, field: "dateCreated")}</td>
            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${applicationInstanceCount ?: 0}"/>
    </div>
</div>
</body>
</html>
