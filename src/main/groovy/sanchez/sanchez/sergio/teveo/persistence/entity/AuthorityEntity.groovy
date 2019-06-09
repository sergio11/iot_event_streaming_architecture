package sanchez.sanchez.sergio.teveo.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.security.core.GrantedAuthority
import groovy.transform.EqualsAndHashCode
import groovy.transform.MapConstructor
import groovy.transform.ToString
import lombok.Data
import lombok.Getter
import lombok.Setter

/**
 * Authority Entity
 * @author ssanchez
 *
 */
@Document(collection = "authorities")
@MapConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
class AuthorityEntity implements GrantedAuthority {

	/**
	 * ID
	 */
	@Id
	String id;
	
	/**
	 * Type
	 */
	@Field("type")
	AuthorityEnum type;
	
	/**
	 * Description
	 */
	@Field("description")
	String description;
	
	
	@Override
	public String getAuthority() {
		return type.name();
	}
	
}
