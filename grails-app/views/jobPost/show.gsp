<%@ page import="jobs.JobPost" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'jobPost.label', default: 'JobPost')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<div id="show-jobPost" class="content scaffold-show" role="main">
    <h1>
        <sec:ifLoggedIn>
            <sec:ifAllGranted roles="ROLE_HR">
                <g:link controller="job" action="show"
                        id="${jobPostInstance?.job?.id}">${jobPostInstance?.job?.encodeAsHTML()}</g:link>
            </sec:ifAllGranted>
            <sec:ifAllGranted roles="ROLE_USER">
                ${jobPostInstance?.job?.encodeAsHTML()}
            </sec:ifAllGranted>
        </sec:ifLoggedIn>
        </h1>
    <g:if test="${flash.message}">
        <p class="bg-success" role="status">${flash.message}</p>
    </g:if>
    <dl class="dl-horizontal">
        <g:if test="${jobPostInstance?.salaryRange}">
                <dt id="salaryRange-label" class="property-label padding-right-10px"><g:message code="jobPost.salaryRange.label"
                                                                               default="Salary Range"/></dt>

                <dl class="property-value" aria-labelledby="salaryRange-label"><g:fieldValue bean="${jobPostInstance}"
                                                                                               field="salaryRange"/></dl>

        </g:if>

        <g:if test="${jobPostInstance?.previousJobPost}">
                <dt id="previousJobPost-label" class="property-label padding-right-10px"><g:message code="jobPost.previousJobPost.label"
                                                                                   default="Previous Job Post"/></dt>

                <dl class="property-value" aria-labelledby="previousJobPost-label"><g:link controller="jobPost"
                                                                                             action="show"
                                                                                             id="${jobPostInstance?.previousJobPost?.id}">${jobPostInstance?.previousJobPost?.encodeAsHTML()}</g:link></dl>

        </g:if>
        <g:if test="${jobPostInstance?.application}">
                <dt id="application-label" class="property-label padding-right-10px"><g:message code="jobPost.application.label"
                                                                               default="Application"/></dt>

                <dl class="property-value" aria-labelledby="application-label"><g:link controller="application"
                                                                                         action="show"
                                                                                         id="${jobPostInstance?.application?.id}">${jobPostInstance?.application?.encodeAsHTML()}</g:link></dl>
        </g:if>
        <g:if test="${jobPostInstance?.active}">
                <dt id="active-label" class="property-label"><g:message code="jobPost.active.label"
                                                                          default="Active"/></dt>

                <dl class="property-value" aria-labelledby="active-label"><g:formatBoolean
                        boolean="${jobPostInstance?.active}"/></dl>
        </g:if>
        <g:if test="${jobPostInstance?.employmentType}">
                <dt id="employmentType-label" class="property-label"><g:message code="jobPost.employmentType.label"
                                                                                  default="Employment Type"/></dt>

                <dl class="property-value" aria-labelledby="employmentType-label"><g:link controller="employmentType"
                                                                                            action="show"
                                                                                            id="${jobPostInstance?.employmentType?.id}">${jobPostInstance?.employmentType?.encodeAsHTML()}</g:link></dl>

        </g:if>

        <g:if test="${jobPostInstance?.job}">
                <dt id="job-label" class="property-label"><g:message code="jobPost.job.label" default="Job"/></dt>

                <dl class="property-value" aria-labelledby="job-label"><g:link controller="job" action="show"
                                                                                 id="${jobPostInstance?.job?.id}">${jobPostInstance?.job?.encodeAsHTML()}</g:link></dl>
        </g:if>

        <g:if test="${jobPostInstance?.postEnd}">
                <dt id="postEnd-label" class="property-label"><g:message code="jobPost.postEnd.label"
                                                                           default="Post End"/></dt>

                <dl class="property-value" aria-labelledby="postEnd-label"><g:fieldValue bean="${jobPostInstance}"
                                                                                           field="postEnd"/></dl>

        </g:if>

        <g:if test="${jobPostInstance?.postStart}">
                <dt id="postStart-label" class="property-label"><g:message code="jobPost.postStart.label"
                                                                             default="Post Start"/>: </dt>

                <dl class="property-value" aria-labelledby="postStart-label"><g:fieldValue bean="${jobPostInstance}"
                                                                                             field="postStart"/></dl>

        </g:if>
    </dl>
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
