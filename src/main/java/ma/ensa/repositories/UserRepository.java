package ma.ensa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ma.ensa.entities.User;

public interface UserRepository extends JpaRepository<User, Long> { 
    User findByUsername(String username);
}
