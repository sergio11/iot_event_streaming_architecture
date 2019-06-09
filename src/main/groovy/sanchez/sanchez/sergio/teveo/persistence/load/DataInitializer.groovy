package sanchez.sanchez.sergio.teveo.persistence.load

import sanchez.sanchez.sergio.teveo.persistence.entity.AuthorityEntity
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import sanchez.sanchez.sergio.teveo.persistence.entity.AuthorityEnum
import sanchez.sanchez.sergio.teveo.persistence.repository.AuthorityRepository
import sanchez.sanchez.sergio.teveo.persistence.repository.UserRepository
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
class DataInitializer  implements CommandLineRunner {
	
	
	private final UserRepository userRepository
	private final AuthorityRepository authorityRepository
	
	public DataInitializer(UserRepository userRepository, AuthorityRepository authorityRepository) {
		super();
		this.userRepository = userRepository;
		this.authorityRepository = authorityRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		def roles  = [
			new AuthorityEntity(
				type: AuthorityEnum.ROLE_ADMIN,
				description: "Role for Administrators"),
			new AuthorityEntity(
				type: AuthorityEnum.ROLE_USER,
				description: "Role for Users"),
			new AuthorityEntity(
				type: AuthorityEnum.ROLE_ANONYMOUS,
				description: "Role for Anonymous")
			]
		
			
		
		this.authorityRepository
                .deleteAll()
                .thenMany(
					Flux
						.just(*roles)
						.flatMap({ AuthorityEntity role -> authorityRepository.save(role) })
                )
                .subscribe(
                        null,
                        null,
                        { _ -> null }
                );
	}
}
