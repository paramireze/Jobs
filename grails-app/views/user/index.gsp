
<%@ page import="jobs.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>

		<div id="list-user" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="bg-success" role="status">${flash.message}</div>
			</g:if>

			<table class="table table-bordered table-hover table-striped">
			<thead>
					<tr>
					
						<g:sortableColumn property="username" title="${message(code: 'user.username.label', default: 'Username')}" />

						<g:sortableColumn property="email" title="${message(code: 'user.email.label', default: 'Email')}" />

						<g:sortableColumn property="phone" title="${message(code: 'user.phone.label', default: 'Phone')}" />
					
						<g:sortableColumn property="accountLocked" title="${message(code: 'user.accountLocked.label', default: 'Account Locked')}" />
					
						<g:sortableColumn property="address" title="${message(code: 'user.address.label', default: 'Address')}" />
					
						<g:sortableColumn property="city" title="${message(code: 'user.city.label', default: 'City')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${userInstanceList}" status="i" var="userInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${userInstance.id}">${fieldValue(bean: userInstance, field: "username")}</g:link></td>
					
						<td>${fieldValue(bean: userInstance, field: "email")}</td>

						<td>${fieldValue(bean: userInstance, field: "phone")}</td>

						<td><g:formatBoolean boolean="${userInstance.accountLocked}" /></td>
					
						<td>${fieldValue(bean: userInstance, field: "address")}</td>
					
						<td>${fieldValue(bean: userInstance, field: "city")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${userInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
