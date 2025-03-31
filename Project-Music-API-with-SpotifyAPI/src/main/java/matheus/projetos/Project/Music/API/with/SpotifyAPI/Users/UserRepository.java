package matheus.projetos.Project.Music.API.with.SpotifyAPI.Users;

import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.Optional;

public interface UserRepository extends MongoRepository<UserEntity,String> {

 boolean existsByEmail(String email);
 Optional<UserEntity> findByEmail(String email);
}
