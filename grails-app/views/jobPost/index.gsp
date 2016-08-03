<%@ page import="jobs.JobPost" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'jobPost.label', default: 'JobPost')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-jobPost" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                              default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-jobPost" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="salaryRange"
                              title="${message(code: 'jobPost.salaryRange.label', default: 'Salary Range')}"/>

            <th><g:message code="jobPost.previousJobPost.label" default="Previous Job Post"/></th>

            <th><g:message code="jobPost.application.label" default="Application"/></th>

            <g:sortableColumn property="active" title="${message(code: 'jobPost.active.label', default: 'Active')}"/>

            <th><g:message code="jobPost.employmentType.label" default="Employment Type"/></th>

            <th><g:message code="jobPost.job.label" default="Job"/></th>

        </tr>
        </thead>
        <tbody>
        <g:each in="${jobPostInstanceList}" status="i" var="jobPostInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show"
                            id="${jobPostInstance.id}">${fieldValue(bean: jobPostInstance, field: "salaryRange")}</g:link></td>

                <td>${fieldValue(bean: jobPostInstance, field: "previousJobPost")}</td>

                <td>${fieldValue(bean: jobPostInstance, field: "application")}</td>

                <td><g:formatBoolean boolean="${jobPostInstance.active}"/></td>

                <td>${fieldValue(bean: jobPostInstance, field: "employmentType")}</td>

                <td>${fieldValue(bean: jobPostInstance, field: "job")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${jobPostInstanceCount ?: 0}"/>
    </div>
</div>
</body>
</html>
