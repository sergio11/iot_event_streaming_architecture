package sanchez.sanchez.sergio.teveo.uaa.commons.config

import org.springframework.context.annotation.Configuration;
import java.io.Serializable
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.annotation.PostConstruct

@Configuration
class CommonSecurityConfig: Serializable {
	
	@Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
    
    @PostConstruct
	fun init(){}
}