package sanchez.sanchez.sergio.teveo.persistence.entity

import java.time.LocalDateTime
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import lombok.ToString
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field


/**
 * User Entity
 * @author ssanchez
 *
 */
@Document(collection="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
class User {
	
	
	@Id String id
	
	/**
	 * FirstName
	 */
	@Field("first_name")
	String firstName
	
	/**
	 * Last Name
	 */
	@Field("last_name")
	String lastName

	/**
	 * Birth Date
	 */
	@Field("birthdate")
	Date birthdate
	
	
	/**
	 * Email
	 */
	@Field("email")
	String email;
	
	/**
	 * User Name
	 */
	@Field("user_name")
	String userName;

	/**
	 * Password
	 */
	@Field("password")
	String password;

	/**
	 * Password Request At
	 */
	@Field("password_requested_at")
	String passwordRequestedAt;

	/**
	 * Is Active
	 */
	@Field("is_active")
	Boolean active = Boolean.TRUE;

	/**
	 * Is Locked
	 */
	@Field("is_locked")
	Boolean locked = Boolean.FALSE;

	/**
	 * Last Login Access
	 */
	@Field("last_login_access")
	Date lastLoginAccess;

	/**
	 * Pending Deletion
	 */
	@Field("pending_deletion")
	Boolean pendingDeletion = Boolean.FALSE;

	/**
	 * Locale
	 */
	@Field("locale")
	Locale locale = Locale.getDefault();

	/**
	 * Last Password Reset Date
	 */
	@Field("last_password_reset_date")
	Date lastPasswordResetDate;

 
	@Field("confirmation_token")
	String confirmationToken;
	
	/**
	 * Authority
	 */
	@DBRef
	AuthorityEntity authority;
	
	@CreatedDate
	@Field("created_date")
	LocalDateTime createdDate;

}
