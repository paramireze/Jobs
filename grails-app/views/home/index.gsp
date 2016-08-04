<%@ page import="jobs.JobPost" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>Home Page</title>
</head>

<body>
<h1>Welcome to our Website</h1>
<p>Please browse our site to find our current job listings.</p>

<table class="table table-bordered table-hover table-striped table-dataTable">
    <thead>
    <tr>
        <th>Job Position</th>
        <th>Employement Type</th>
        <th>Salary</th>
        <th>Post End Date</th>
    </tr>
    </thead>
    <tbody>
    <g:each var="jobPost" in="${jobPosts}">
        <tr>
            <td>${jobPost.job}</td>
            <td>${jobPost.employmentType}</td>
            <td>${jobPost.salaryRange}</td>
            <td>${jobPost.postEnd}</td>
        </tr>
    </g:each>
    </tbody>
</table>

%{--<sec:ifLoggedIn>
    <sec:ifAllGranted roles="ROLE_HR">
        <div>HR</div>
    </sec:ifAllGranted>
</sec:ifLoggedIn>--}%

</body>
</html>
