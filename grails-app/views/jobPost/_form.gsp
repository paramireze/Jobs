<%@ page import="jobs.JobPost" %>



<div class="fieldcontain ${hasErrors(bean: jobPostInstance, field: 'salaryRange', 'error')} ">
    <label for="salaryRange">
        <g:message code="jobPost.salaryRange.label" default="Salary Range"/>

    </label>
    <g:textField name="salaryRange" value="${jobPostInstance?.salaryRange}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: jobPostInstance, field: 'previousJobPost', 'error')} ">
    <label for="previousJobPost">
        <g:message code="jobPost.previousJobPost.label" default="Previous Job Post"/>

    </label>
    <g:select id="previousJobPost" name="previousJobPost.id" from="${jobs.JobPost.list()}" optionKey="id"
              value="${jobPostInstance?.previousJobPost?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: jobPostInstance, field: 'application', 'error')} ">
    <label for="application">
        <g:message code="jobPost.application.label" default="Application"/>

    </label>
    <g:select id="application" name="application.id" from="${jobs.Application.list()}" optionKey="id"
              value="${jobPostInstance?.application?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: jobPostInstance, field: 'active', 'error')} ">
    <label for="active">
        <g:message code="jobPost.active.label" default="Active"/>

    </label>
    <g:checkBox name="active" value="${jobPostInstance?.active}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: jobPostInstance, field: 'employmentType', 'error')} required">
    <label for="employmentType">
        <g:message code="jobPost.employmentType.label" default="Employment Type"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select id="employmentType" name="employmentType.id" from="${jobs.EmploymentType.list()}" optionKey="id"
              required="" value="${jobPostInstance?.employmentType?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: jobPostInstance, field: 'job', 'error')} required">
    <label for="job">
        <g:message code="jobPost.job.label" default="Job"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select id="job" name="job.id" from="${jobs.Job.list()}" optionKey="id" required=""
              value="${jobPostInstance?.job?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: jobPostInstance, field: 'postEnd', 'error')} required">
    <label for="postEnd">
        <g:message code="jobPost.postEnd.label" default="Post End"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="postEnd" required="" value="${jobPostInstance?.postEnd}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: jobPostInstance, field: 'postStart', 'error')} required">
    <label for="postStart">
        <g:message code="jobPost.postStart.label" default="Post Start"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="postStart" required="" value="${jobPostInstance?.postStart}"/>

</div>

