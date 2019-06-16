package sanchez.sanchez.sergio.teveo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.mongodb.config.EnableMongoAuditing


@SpringBootApplication
@EnableMongoAuditing
class TeveoPlatformApplication {

	static void main(String[] args) {
		SpringApplication.run(TeveoPlatformApplication, args)
	
	}

}
