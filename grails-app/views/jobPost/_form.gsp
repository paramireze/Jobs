<%@ page import="jobs.JobPost" %>


<div class="form-horizontal">
<div class="form-group fieldcontain ${hasErrors(bean: jobPostInstance, field: 'salaryRange', 'error')} ">
    <label for="salaryRange" class="col-sm-2">
        <g:message code="jobPost.salaryRange.label" default="Salary Range"/>

    </label>
    <div class="col-sm-4"><g:textField class="form-control" name="salaryRange" value="${jobPostInstance?.salaryRange}"/></div>

</div>

<div class="form-group fieldcontain ${hasErrors(bean: jobPostInstance, field: 'previousJobPost', 'error')} ">
    <label for="previousJobPost" class="col-sm-2">
        <g:message code="jobPost.previousJobPost.label" default="Previous Job Post"/>

    </label>
    <div class="col-sm-4"><g:select id="previousJobPost" name="previousJobPost.id" from="${jobs.JobPost.list()}" optionKey="id"
              value="${jobPostInstance?.previousJobPost?.id}" class="many-to-one form-control" noSelection="['null': '']"/></div>

</div>

<div class="form-group fieldcontain ${hasErrors(bean: jobPostInstance, field: 'application', 'error')} ">
    <label for="application" class="col-sm-2">
        <g:message code="jobPost.application.label" default="Application"/>

    </label>
    <div class="col-sm-4"><g:select id="application" name="application.id" from="${jobs.Application.list()}" optionKey="id"
              value="${jobPostInstance?.application?.id}" class="many-to-one form-control" noSelection="['null': '']"/></div>

</div>

<div class="form-group fieldcontain ${hasErrors(bean: jobPostInstance, field: 'active', 'error')} ">
    <label for="active" class="col-sm-2">
        <g:message code="jobPost.active.label" default="Active"/>

    </label>
    <div class="col-sm-4"><g:checkBox class="form-control" name="active" value="${jobPostInstance?.active}"/></div>

</div>

<div class="form-group fieldcontain ${hasErrors(bean: jobPostInstance, field: 'employmentType', 'error')} required">
    <label for="employmentType" class="col-sm-2">
        <g:message code="jobPost.employmentType.label" default="Employment Type"/>
        <span class="required-indicator">*</span>
    </label>
    <div class="col-sm-4"><g:select id="employmentType" name="employmentType.id" from="${jobs.EmploymentType.list()}" optionKey="id"
              required="" value="${jobPostInstance?.employmentType?.id}" class="many-to-one form-control"/></div>

</div>

<div class="form-group fieldcontain ${hasErrors(bean: jobPostInstance, field: 'job', 'error')} required">
    <label for="job" class="col-sm-2">
        <g:message code="jobPost.job.label" default="Job"/>
        <span class="required-indicator">*</span>
    </label>
    <div class="col-sm-4"><g:select id="job" name="job.id" from="${jobs.Job.list()}" optionKey="id" required=""
              value="${jobPostInstance?.job?.id}" class="many-to-one form-control"/></div>

</div>

<div class="form-group fieldcontain ${hasErrors(bean: jobPostInstance, field: 'postEnd', 'error')} required">
    <label for="postEnd" class="col-sm-2">
        <g:message code="jobPost.postEnd.label" default="Post End"/>
        <span class="required-indicator">*</span>
    </label>
    <div class="col-sm-4"><g:textField name="postEnd" class="form-control" required="" value="${jobPostInstance?.postEnd}"/></div>

</div>

<div class="form-group fieldcontain ${hasErrors(bean: jobPostInstance, field: 'postStart', 'error')} required">
    <label for="postStart" class="col-sm-2">
        <g:message code="jobPost.postStart.label" default="Post Start"/>
        <span class="required-indicator">*</span>
    </label>
    <div class="col-sm-4"><g:textField class="form-control" name="postStart" required="" value="${jobPostInstance?.postStart}"/></div>
</div>
</div>
