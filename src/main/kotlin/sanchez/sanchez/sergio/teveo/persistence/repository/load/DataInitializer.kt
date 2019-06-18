package sanchez.sanchez.sergio.teveo.persistence.repository.load

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired
import sanchez.sanchez.sergio.teveo.persistence.repository.UserRepository
import sanchez.sanchez.sergio.teveo.persistence.repository.AuthorityRepository
import sanchez.sanchez.sergio.teveo.persistence.AuthorityEntity
import reactor.core.publisher.Flux
import sanchez.sanchez.sergio.teveo.persistence.AuthorityEnum

@Component
class DataInitializer @Autowired constructor(
		private val userRepository: UserRepository,
		private val authorityRepository: AuthorityRepository
): CommandLineRunner  {
	
	override fun run(vararg args: String?) {

	
		val roles  = arrayOf(
			AuthorityEntity(
				type = AuthorityEnum.ROLE_ADMIN,
				description = "Role for Administrators"),
			AuthorityEntity(
				type = AuthorityEnum.ROLE_USER,
				description = "Role for Users"),
			AuthorityEntity(
				type = AuthorityEnum.ROLE_ANONYMOUS,
				description = "Role for Anonymous")
			)
		
		
		this.authorityRepository
                .deleteAll()
                .thenMany(
					Flux
						.just(*roles)
						.flatMap({ role: AuthorityEntity  ->
							authorityRepository.save(role) })
                )
                .subscribe(
                        null,
                        null,
                        {
							
							
						}
                );
		
		
	}
}