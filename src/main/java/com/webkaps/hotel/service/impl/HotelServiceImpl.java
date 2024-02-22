package com.webkaps.hotel.service.impl;

import com.webkaps.hotel.exception.ResourceNotFoundException;
import com.webkaps.hotel.model.Hotel;
import com.webkaps.hotel.repository.HotelRepository;
import com.webkaps.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel", "Id", hotelId));
    }

    @Override
    public List<Hotel> getHotelByUserId(String userId) {
        return hotelRepository.findByUserId(userId);

    }

}
