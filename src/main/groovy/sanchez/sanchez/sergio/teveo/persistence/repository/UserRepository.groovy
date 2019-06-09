package sanchez.sanchez.sergio.teveo.persistence.repository

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

import sanchez.sanchez.sergio.teveo.persistence.entity.User


/**
 * User Repository
 * @author ssanchez
 *
 */
@Repository
interface UserRepository extends ReactiveMongoRepository<User, String> {
}
