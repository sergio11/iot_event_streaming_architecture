package sanchez.sanchez.sergio.teveo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.config.EnableMongoAuditing


@SpringBootApplication
@EnableMongoAuditing
class TestKotlinApplication

fun main(args: Array<String>) {
	runApplication<TestKotlinApplication>(*args)
}
