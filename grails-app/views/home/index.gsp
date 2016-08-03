<%@ page import="jobs.JobPost" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>Home Page</title>
</head>

<body>
<table class="table table-bordered table-hover table-striped table-dataTable">
    <thead>
    <tr>
        <th>Job Position</th>
    </tr>
    </thead>
    <tbody>
    <g:each var="jobPost" in="${jobPosts}">
        <tr>
            <td>${jobPost.job}</td>
        </tr>
    </g:each>
    </tbody>
</table>
</body>
</html>
