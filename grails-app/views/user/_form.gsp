<%@ page import="jobs.User" %>

<div class="form-horizontal">
	<div class="form-group fieldcontain ${hasErrors(bean: userInstance, field: 'username', 'error')} required">
		<label class="col-sm-2 control-label" for="username">
			<g:message code="user.username.label" default="Username" />
			<span class="required-indicator">*</span>
		</label>
		<div class="col-sm-4">
			<g:textField class="form-control col-sm-4" name="username" required="" value="${userInstance?.username}"/>
		</div>
	</div>
	<div class="form-group fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} required">
		<label class="col-sm-2 control-label" for="password">
			<g:message code="user.password.label" default="Password" />
			<span class="required-indicator">*</span>
		</label>
		<div class="col-sm-4">
			<g:textField class="form-control" name="password" required="" value="${userInstance?.password}"/>
		</div>
	</div>
	<div class="form-group fieldcontain ${hasErrors(bean: userInstance, field: 'address', 'error')} required">
		<label class="col-sm-2 control-label" for="address">
			<g:message code="user.address.label" default="Address" />
			<span class="required-indicator">*</span>
		</label>
		<div class="col-sm-4">
			<g:textField class="form-control" name="address" required="" value="${userInstance?.address}"/>
		</div>
	</div>
	<div class="form-group fieldcontain ${hasErrors(bean: userInstance, field: 'city', 'error')} required">
		<label class="col-sm-2 control-label" for="city">
			<g:message code="user.city.label" default="City" />
			<span class="required-indicator">*</span>
		</label>
		<div class="col-sm-4">
			<g:textField class="form-control" name="city" required="" value="${userInstance?.city}"/>
		</div>
	</div>
	<div class="form-group fieldcontain ${hasErrors(bean: userInstance, field: 'email', 'error')} required">
		<label class="col-sm-2 control-label" for="email">
			<g:message code="user.email.label" default="Email" />
			<span class="required-indicator">*</span>
		</label>
		<div class="col-sm-4">
			<g:textField class="form-control" name="email" required="" value="${userInstance?.email}"/>
		</div>
	</div>
	<div class="form-group fieldcontain ${hasErrors(bean: userInstance, field: 'phone', 'error')} required">
		<label class="control-label col-sm-2" for="phone">
			<g:message code="user.phone.label" default="Phone" />
			<span class="required-indicator">*</span>
		</label>
		<div class="col-sm-4">
			<g:textField class="form-control" name="phone" required="" value="${userInstance?.phone}"/>
		</div>
	</div>
	<div class="form-group fieldcontain ${hasErrors(bean: userInstance, field: 'state', 'error')} required">
		<label class="control-label col-sm-2" for="state">
			<g:message code="user.state.label" default="State" />
			<span class="required-indicator">*</span>
		</label>
		<div class="col-sm-4">
			<g:textField class="form-control" name="state" required="" value="${userInstance?.state}"/>
		</div>
	</div>
	<div class="form-group fieldcontain ${hasErrors(bean: userInstance, field: 'zip', 'error')} required">
		<label class="col-sm-2 control-label" for="zip">
			<g:message code="user.zip.label" default="Zip" />
			<span class="required-indicator">*</span>
		</label>
		<div class="col-sm-4">
			<g:textField class="form-control" name="zip" required="" value="${userInstance?.zip}"/>
		</div>
	</div>
	<div class="form-group fieldcontain ${hasErrors(bean: userInstance, field: 'enabled', 'error')} ">
		<label class="col-sm-2 control-label" for="enabled">
			<g:message code="user.enabled.label" default="Enabled" />
		</label>
		<div class="col-sm-4">
			<g:checkBox class="form-control" name="enabled" value="${userInstance?.enabled}" />
		</div>
	</div>
	<div class="form-group fieldcontain ${hasErrors(bean: userInstance, field: 'accountExpired', 'error')} ">
		<label class="col-sm-2 control-label" for="accountExpired">
			<g:message code="user.accountExpired.label" default="Account Expired" />
		</label>
		<div class="col-sm-4">
			<g:checkBox class="form-control" name="accountExpired" value="${userInstance?.accountExpired}" />
		</div>
	</div>
	<div class="form-group fieldcontain ${hasErrors(bean: userInstance, field: 'accountLocked', 'error')} ">
		<label class="col-sm-2 control-label" for="accountLocked">
			<g:message code="user.accountLocked.label" default="Account Locked" />
		</label>
		<div class="col-sm-4">
			<g:checkBox class="form-control" name="accountLocked" value="${userInstance?.accountLocked}" />
		</div>
	</div>
	<div class="form-group fieldcontain ${hasErrors(bean: userInstance, field: 'passwordExpired', 'error')} ">
		<label class="control-label col-sm-2" for="passwordExpired">
			<g:message code="user.passwordExpired.label" default="Password Expired" />
		</label>
		<div class="col-sm-4">
			<g:checkBox class="form-control" name="passwordExpired" value="${userInstance?.passwordExpired}" />
		</div>
	</div>
</div>