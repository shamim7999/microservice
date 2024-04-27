package com.dsi.hotel.service.services;

import com.dsi.hotel.service.models.Hotel;
import com.dsi.hotel.service.repositories.HotelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;

    @Transactional
    public void saveHotel(Hotel hotel) {
        hotel.setId(UUID.randomUUID().toString());
        hotelRepository.save(hotel);
    }

    public Hotel findHotelById(String hotelId) throws Exception{
        return hotelRepository.findById(hotelId).orElseThrow(
                () -> new Exception("Resource not found for ID: "+hotelId)
        );
    }

    public List<Hotel> findAllHotels() {
        return hotelRepository.findAll();
    }
}
