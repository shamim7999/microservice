package com.dsi.hotel.service.controllers;

import com.dsi.hotel.service.models.Hotel;
import com.dsi.hotel.service.services.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/hotels")
public class HotelController {
    private final HotelService hotelService;

    @PostMapping
    public ResponseEntity<?> saveHotel(@RequestBody Hotel hotel) {
        hotelService.saveHotel(hotel);
        return ResponseEntity.ofNullable(hotel);
    }

    @GetMapping
    public ResponseEntity<?> findAllHotels() {
        return ResponseEntity.ofNullable(hotelService.findAllHotels());
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<?> findHotelById(@PathVariable String hotelId)
            throws Exception {
        return ResponseEntity.ofNullable(hotelService.findHotelById(hotelId));
    }
}
