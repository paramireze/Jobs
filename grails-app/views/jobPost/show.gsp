<%@ page import="jobs.JobPost" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'jobPost.label', default: 'JobPost')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-jobPost" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                              default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-jobPost" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list jobPost">

        <g:if test="${jobPostInstance?.salaryRange}">
            <li class="fieldcontain">
                <span id="salaryRange-label" class="property-label"><g:message code="jobPost.salaryRange.label"
                                                                               default="Salary Range"/></span>

                <span class="property-value" aria-labelledby="salaryRange-label"><g:fieldValue bean="${jobPostInstance}"
                                                                                               field="salaryRange"/></span>

            </li>
        </g:if>

        <g:if test="${jobPostInstance?.previousJobPost}">
            <li class="fieldcontain">
                <span id="previousJobPost-label" class="property-label"><g:message code="jobPost.previousJobPost.label"
                                                                                   default="Previous Job Post"/></span>

                <span class="property-value" aria-labelledby="previousJobPost-label"><g:link controller="jobPost"
                                                                                             action="show"
                                                                                             id="${jobPostInstance?.previousJobPost?.id}">${jobPostInstance?.previousJobPost?.encodeAsHTML()}</g:link></span>

            </li>
        </g:if>

        <g:if test="${jobPostInstance?.application}">
            <li class="fieldcontain">
                <span id="application-label" class="property-label"><g:message code="jobPost.application.label"
                                                                               default="Application"/></span>

                <span class="property-value" aria-labelledby="application-label"><g:link controller="application"
                                                                                         action="show"
                                                                                         id="${jobPostInstance?.application?.id}">${jobPostInstance?.application?.encodeAsHTML()}</g:link></span>

            </li>
        </g:if>

        <g:if test="${jobPostInstance?.active}">
            <li class="fieldcontain">
                <span id="active-label" class="property-label"><g:message code="jobPost.active.label"
                                                                          default="Active"/></span>

                <span class="property-value" aria-labelledby="active-label"><g:formatBoolean
                        boolean="${jobPostInstance?.active}"/></span>

            </li>
        </g:if>

        <g:if test="${jobPostInstance?.employmentType}">
            <li class="fieldcontain">
                <span id="employmentType-label" class="property-label"><g:message code="jobPost.employmentType.label"
                                                                                  default="Employment Type"/></span>

                <span class="property-value" aria-labelledby="employmentType-label"><g:link controller="employmentType"
                                                                                            action="show"
                                                                                            id="${jobPostInstance?.employmentType?.id}">${jobPostInstance?.employmentType?.encodeAsHTML()}</g:link></span>

            </li>
        </g:if>

        <g:if test="${jobPostInstance?.job}">
            <li class="fieldcontain">
                <span id="job-label" class="property-label"><g:message code="jobPost.job.label" default="Job"/></span>

                <span class="property-value" aria-labelledby="job-label"><g:link controller="job" action="show"
                                                                                 id="${jobPostInstance?.job?.id}">${jobPostInstance?.job?.encodeAsHTML()}</g:link></span>

            </li>
        </g:if>

        <g:if test="${jobPostInstance?.postEnd}">
            <li class="fieldcontain">
                <span id="postEnd-label" class="property-label"><g:message code="jobPost.postEnd.label"
                                                                           default="Post End"/></span>

                <span class="property-value" aria-labelledby="postEnd-label"><g:fieldValue bean="${jobPostInstance}"
                                                                                           field="postEnd"/></span>

            </li>
        </g:if>

        <g:if test="${jobPostInstance?.postStart}">
            <li class="fieldcontain">
                <span id="postStart-label" class="property-label"><g:message code="jobPost.postStart.label"
                                                                             default="Post Start"/></span>

                <span class="property-value" aria-labelledby="postStart-label"><g:fieldValue bean="${jobPostInstance}"
                                                                                             field="postStart"/></span>

            </li>
        </g:if>

    </ol>
    <g:form url="[resource: jobPostInstance, action: 'delete']" method="DELETE">
        <fieldset class="buttons">
            <g:link class="edit" action="edit" resource="${jobPostInstance}"><g:message code="default.button.edit.label"
                                                                                        default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
