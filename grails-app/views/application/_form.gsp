<%@ page import="jobs.Document; jobs.Application" %>

<input type="hidden" name="jobPost" value="${applicationInstance.jobPost.id}" />
<input type="hidden" name="user" value="${user.id}" />
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
    <label for="inputResume" class="col-sm-2 control-label">Resume</label>
    <div class="col-sm-10">
        <g:select name="documentResume"
                  from="${user.documents}"
                    id="inputResume"
           noSelection="['':'Choose a Saved Resume']"
                    />
        <g:link action="index">Add Resume</g:link>
    </div>
</div>
<div class="form-group">
    <label for="inputCoverLetter" class="col-sm-2 control-label">Cover Letter</label>
    <div class="col-sm-10">
        <g:select name="documentCoverletter"
                  from="${user.documents}"
                    id="inputCoverLetter"
           noSelection="['':'Choose a Saved Coverletter']"/>
        <g:link action="index">Add Cover Letter</g:link>
    </div>
</div>
<div class="form-group">
    <label for="inputEmail" class="col-sm-2 control-label">Manually Enter Resume</label>
    <div class="col-sm-10">
        <ckeditor:editor name="myeditor" height="400px" width="80%">
            asdf
        </ckeditor:editor>
    </div>
</div>