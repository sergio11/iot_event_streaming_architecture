package sanchez.sanchez.sergio.teveo.persistence.repository

import org.springframework.stereotype.Repository
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import sanchez.sanchez.sergio.teveo.persistence.UserEntity

@Repository
interface UserRepository: ReactiveMongoRepository<UserEntity, String> {
}