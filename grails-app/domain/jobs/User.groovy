package jobs

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.joda.time.LocalDate

@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

	private static final long serialVersionUID = 1

	transient springSecurityService

	String username
	String password
	String email
	String phone
	String address
	String city
	String state
	String zip


	// Automatic timestamping
	LocalDate dateCreated

	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	User(String username, String password, String email, String phone, String address, String city, String state, String zip) {
		this()
		this.username = username
		this.password = password
		this.email = email
		this.phone = phone
		this.address = address
		this.city = city
		this.state = state
		this.zip = zip
		this.accountExpired = false
		this.accountLocked = false
		this.passwordExpired = false
		this.dateCreated = LocalDate.now()

	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this)*.role
	}

	// *** Security-oriented methods ***
	Set<Role> getRoles() {
		UserRole.findAllByPerson(this).collect { UserRole ur -> ur.role } as Set
	}

	boolean hasRole(Role role) {
		UserRole.countByUserAndRole(this, role) > 0
	}

	boolean hasRole(String role) {
		hasRole(Role.findByAuthority(role))
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	String toString() { this.username }

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}

	static transients = ['springSecurityService']

	static constraints = {
		username blank: false, unique: true
		password blank: false
	}

	static mapping = {
		password column: '`password`'
	}

	static hasMany = [applications: Application, documents: Document]
}
