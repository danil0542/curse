package com.danyamesh.curse.repository;

import com.danyamesh.curse.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
