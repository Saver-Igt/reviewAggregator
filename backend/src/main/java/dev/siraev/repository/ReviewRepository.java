package dev.siraev.repository;

import dev.siraev.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Review findByUserIdAndGameId(Long userId, Long gameId);
    List<Review> findByGameId(Long gameId);
    List<Review> findByUserId(Long userId);
}
