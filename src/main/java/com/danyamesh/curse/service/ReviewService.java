package com.danyamesh.curse.service;

import com.danyamesh.curse.model.Review;
import com.danyamesh.curse.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewService implements BaseService<Review, Long> {
    private final ReviewRepository reviewRepository;

    @Override
    public Review save(Review entity) {
        return reviewRepository.save(entity);
    }

    @Override
    public Optional<Review> findById(Long aLong) {
        return reviewRepository.findById(aLong);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public void update(Review entity) {
        reviewRepository.save(entity);
    }

    @Override
    public void delete(Review entity) {
        reviewRepository.delete(entity);
    }

    @Override
    public void deleteById(Long aLong) {
        reviewRepository.deleteById(aLong);
    }
}
