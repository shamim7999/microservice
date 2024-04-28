package com.dsi.rating.service.controllers;

import com.dsi.rating.service.models.Rating;
import com.dsi.rating.service.services.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/ratings")
public class RatingController {
    private final RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        return ResponseEntity.ofNullable(ratingService.createRating(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getRatings() {
        return ResponseEntity.ofNullable(ratingService.getAllRatings());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId) throws Exception {
        List<Rating> ratings = ratingService.getRatingsByUserId(userId);
        if (ratings != null) {
            return ResponseEntity.ok(ratings);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId) throws Exception {
        List<Rating> ratings = ratingService.getRatingsByHotelId(hotelId);
        if (ratings != null) {
            return ResponseEntity.ok(ratings);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
