package sanchez.sanchez.sergio.teveo.persistence

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Field
import java.util.Date
import java.util.Locale
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import org.springframework.data.mongodb.core.mapping.DBRef

@Document(collection="users")
data class UserEntity(
	@Id
	var id: String,
	
	@Field("first_name")
	var firstName: String,
	
	@Field("last_name")
	var lastName: String,
	
	@Field("birthdate")
	var birthdate: Date,
	
	@Field("email")
	var email: String,
	
	@Field("user_name")
	var userName: String,
	
	@Field("password")
	var password: String,
	
	@Field("password_requested_at")
	var passwordRequestedAt: String,
	
	@Field("is_active")
	var active: Boolean = true,
	
	@Field("is_locked")
	var locked: Boolean = false,
	
	@Field("last_login_access")
	var lastLoginAccess: Date,
	
	@Field("pending_deletion")
	var pendingDeletion: Boolean = false,
	
	@Field("locale")
	var locale: Locale = Locale.getDefault(),
	
	@Field("last_password_reset_date")
	var lastPasswordResetDate: Date,
	
	@Field("confirmation_token")
	var confirmationToken: String,
	
	@CreatedDate
	@Field("created_date")
	var createdDate: LocalDateTime,
	
	@DBRef
	var authority: AuthorityEntity

) {
}

