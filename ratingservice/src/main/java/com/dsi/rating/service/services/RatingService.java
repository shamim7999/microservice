package com.dsi.rating.service.services;

import com.dsi.rating.service.models.Rating;
import com.dsi.rating.service.repositories.RatingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RatingService {
    private final RatingRepository ratingRepository;

    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Rating getRating(String ratingId) throws Exception {
        return ratingRepository.findById(ratingId)
                .orElseThrow(() -> new Exception("Resource not found for id: "+ratingId));
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public List<Rating> getRatingsByUserId(String userId) throws Exception {
        return ratingRepository.findByUserId(userId);
    }

    public List<Rating> getRatingsByHotelId(String hotelId) throws Exception {
        return ratingRepository.findByHotelId(hotelId);
    }
}
