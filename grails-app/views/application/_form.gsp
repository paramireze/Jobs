<%@ page import="jobs.Application" %>


<div class="form-group">
    <label for="inputName" class="col-sm-2 control-label">Name</label>
    <div class="col-sm-10">
        <input type="text" disabled class="form-control" value="${user}" id="inputName" placeholder="Name">
    </div>
</div>
<div class="form-group">
    <label for="inputEmail" class="col-sm-2 control-label">Email</label>
    <div class="col-sm-10">
        <input type="email" disabled class="form-control" id="inputEmail" value="${user.email}" placeholder="Email">
    </div>
</div>
<div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
        <div class="checkbox">
            <label>
                <input type="checkbox"> Remember me
            </label>
        </div>
    </div>
</div>
<div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Sign in</button>
    </div>
</div>
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
</div>


