package dev.siraev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.siraev.models.user.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
