<%@ page import="jobs.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'username', 'error')} required">
	<label for="username">
		<g:message code="user.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="username" required="" value="${userInstance?.username}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="user.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" required="" value="${userInstance?.password}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'accountExpired', 'error')} ">
	<label for="accountExpired">
		<g:message code="user.accountExpired.label" default="Account Expired" />
		
	</label>
	<g:checkBox name="accountExpired" value="${userInstance?.accountExpired}" />

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'accountLocked', 'error')} ">
	<label for="accountLocked">
		<g:message code="user.accountLocked.label" default="Account Locked" />
		
	</label>
	<g:checkBox name="accountLocked" value="${userInstance?.accountLocked}" />

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'address', 'error')} required">
	<label for="address">
		<g:message code="user.address.label" default="Address" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="address" required="" value="${userInstance?.address}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'applications', 'error')} ">
	<label for="applications">
		<g:message code="user.applications.label" default="Applications" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${userInstance?.applications?}" var="a">
    <li><g:link controller="application" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="application" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'application.label', default: 'Application')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'city', 'error')} required">
	<label for="city">
		<g:message code="user.city.label" default="City" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="city" required="" value="${userInstance?.city}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'documents', 'error')} ">
	<label for="documents">
		<g:message code="user.documents.label" default="Documents" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${userInstance?.documents?}" var="d">
    <li><g:link controller="document" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="document" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'document.label', default: 'Document')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="user.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="email" required="" value="${userInstance?.email}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'enabled', 'error')} ">
	<label for="enabled">
		<g:message code="user.enabled.label" default="Enabled" />
		
	</label>
	<g:checkBox name="enabled" value="${userInstance?.enabled}" />

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'passwordExpired', 'error')} ">
	<label for="passwordExpired">
		<g:message code="user.passwordExpired.label" default="Password Expired" />
		
	</label>
	<g:checkBox name="passwordExpired" value="${userInstance?.passwordExpired}" />

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'phone', 'error')} required">
	<label for="phone">
		<g:message code="user.phone.label" default="Phone" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="phone" required="" value="${userInstance?.phone}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'state', 'error')} required">
	<label for="state">
		<g:message code="user.state.label" default="State" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="state" required="" value="${userInstance?.state}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'zip', 'error')} required">
	<label for="zip">
		<g:message code="user.zip.label" default="Zip" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="zip" required="" value="${userInstance?.zip}"/>

</div>

