package dev.siraev.repository;

import dev.siraev.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    public Review findByUserIdAndGameId(Long userId, Long gameId);
}
