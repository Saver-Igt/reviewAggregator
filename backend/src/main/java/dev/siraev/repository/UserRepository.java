package dev.siraev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.siraev.models.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
