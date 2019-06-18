package sanchez.sanchez.sergio.teveo.persistence

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.security.core.GrantedAuthority
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Field


@Document(collection = "authorities")
data class AuthorityEntity(
		@Field("type")
		var type: AuthorityEnum,
		@Field("description")
		var description: String
): GrantedAuthority {
	
	@Id
	lateinit var id: String
	
	@Override
	override fun getAuthority(): String = type.name
	
}