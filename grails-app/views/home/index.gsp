<%@ page import="jobs.JobPost" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>Home Page</title>
</head>

<body>
<div class="jumbotron">
    <h1>Welcome to our Website</h1>
    <p>Please browse our site to find our current job listings.</p>
</div>
<g:each var="category" in="${categories}">

    <h2>${category}</h2>
    <table class="table table-bordered table-hover table-striped">
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
            <g:if test="${category.toString() == jobPost.job.category.toString()}">
                <tr>
                    <td>
                        <g:link controller="jobPost" action="show" params="[id: jobPost.id]">${jobPost.job}</g:link>
                    </td>
                    <td>${jobPost.employmentType}</td>
                    <td>${jobPost.salaryRange}</td>
                    <td>${jobPost.postEnd}</td>
                </tr>
            </g:if>
        </g:each>
        </tbody>
    </table>
</g:each>
%{--<sec:ifLoggedIn>
    <sec:ifAllGranted roles="ROLE_HR">
        <div>HR</div>
    </sec:ifAllGranted>
</sec:ifLoggedIn>--}%

</body>
</html>
