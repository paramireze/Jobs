<%@ page import="jobs.Application" %>



<div class="form-group fieldcontain ${hasErrors(bean: applicationInstance, field: 'applicationDocument', 'error')} ">
    <label for="applicationDocument">
        <g:message code="application.applicationDocument.label" default="Application Document"/>

    </label>
    <g:select id="applicationDocument" name="applicationDocument.id" from="${jobs.ApplicationDocument.list()}"
              optionKey="id" value="${applicationInstance?.applicationDocument?.id}" class="form-control many-to-one"
              noSelection="['null': '']"/>

</div>

<div class="form-group fieldcontain ${hasErrors(bean: applicationInstance, field: 'jobPost', 'error')} required">
    <label for="jobPost">
        <g:message code="application.jobPost.label" default="Job Post"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select id="jobPost" name="jobPost.id" from="${jobs.JobPost.list()}" optionKey="id" required=""
              value="${applicationInstance?.jobPost?.id}" class="form-control many-to-one"/>

</div>

<div class="form-group fieldcontain ${hasErrors(bean: applicationInstance, field: 'status', 'error')} required">
    <label for="status">
        <g:message code="application.status.label" default="Status"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select id="status" name="status.id" from="${jobs.Status.list()}" optionKey="id" required=""
              value="${applicationInstance?.status?.id}" class="form-control many-to-one"/>

</div>

<div class="form-group fieldcontain ${hasErrors(bean: applicationInstance, field: 'user', 'error')} required">
    <label for="user">
        <g:message code="application.user.label" default="User"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select id="user" name="user.id" from="${jobs.User.list()}" optionKey="id" required=""
              value="${applicationInstance?.user?.id}" class="form-control many-to-one"/>

</div>

