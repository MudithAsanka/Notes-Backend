package dev.mudith.notes.repository;

import dev.mudith.notes.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
