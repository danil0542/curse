package com.danyamesh.curse.service;

import com.danyamesh.curse.model.Review;
import com.danyamesh.curse.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ReviewServiceTest {
    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewService reviewService;

    @Test
    void testSaveReview() {
        Review reviewToSave = new Review();
        Mockito.when(reviewRepository.save(Mockito.any())).thenReturn(reviewToSave);
        Review savedReview = reviewService.save(reviewToSave);
        assertNotNull(savedReview);
        Mockito.verify(reviewRepository, Mockito.times(1)).save(reviewToSave);
    }

    @Test
    void testFindReviewById() {
        Long reviewId = 1L;
        Review mockReview = new Review();
        Mockito.when(reviewRepository.findById(reviewId)).thenReturn(Optional.of(mockReview));
        Optional<Review> foundReview = reviewService.findById(reviewId);
        assertTrue(foundReview.isPresent());
        assertEquals(mockReview, foundReview.get());
        Mockito.verify(reviewRepository, Mockito.times(1)).findById(reviewId);
    }

    @Test
    void testFindAllReviews() {
        List<Review> mockReviews = Arrays.asList(new Review(), new Review());
        Mockito.when(reviewRepository.findAll()).thenReturn(mockReviews);
        List<Review> allReviews = reviewService.findAll();
        assertEquals(mockReviews.size(), allReviews.size());
        Mockito.verify(reviewRepository, Mockito.times(1)).findAll();
    }

    @Test
    void testUpdateReview() {
        Review reviewToUpdate = new Review();
        reviewService.update(reviewToUpdate);
        Mockito.verify(reviewRepository, Mockito.times(1)).save(reviewToUpdate);
    }

    @Test
    void testDeleteReview() {
        Review reviewToDelete = new Review();
        reviewService.delete(reviewToDelete);
        Mockito.verify(reviewRepository, Mockito.times(1)).delete(reviewToDelete);
    }

    @Test
    void testDeleteReviewById() {
        Long reviewIdToDelete = 1L;
        reviewService.deleteById(reviewIdToDelete);
        Mockito.verify(reviewRepository, Mockito.times(1)).deleteById(reviewIdToDelete);
    }
}