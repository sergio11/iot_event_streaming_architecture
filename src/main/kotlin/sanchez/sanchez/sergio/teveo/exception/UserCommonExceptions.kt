package sanchez.sanchez.sergio.teveo.uaa.commons.exception

sealed class UsernameAlredyExistsException(
		val firstName: String,
		val lastName: String,
		val username: String
	): RuntimeException()


sealed class EmailAlredyExistsException(
		val firstName: String,
		val lastName: String,
		val mail: String
): RuntimeException()

sealed class UserNotActivatedException(): RuntimeException()

sealed class UsernameNotFoundException(): RuntimeException()