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
    <label for="inputEmail" class="col-sm-2 control-label">Resume</label>
    <div class="col-sm-10">
        <g:select name="Document"
                  from="${user.documents}" />
        <g:link action="index">Add Resume</g:link>
    </div>
</div>
<div class="form-group">
    <label for="inputEmail" class="col-sm-2 control-label">Cover Letter</label>
    <div class="col-sm-10">
        <g:select name="Document"
                  from="${user.documents}" />
        <g:link action="index">Add Cover Letter</g:link>
    </div>
</div>
<div class="form-group">
    <label for="inputEmail" class="col-sm-2 control-label">Manually Enter Resume</label>
    <div class="col-sm-10">
        <g:textArea name="myField" value="myValue" rows="5" cols="40"/>
    </div>
</div>