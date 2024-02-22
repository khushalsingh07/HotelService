package com.webkaps.hotel.repository;

import com.webkaps.hotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, String> {
    List<Hotel> findByUserId(String userId);
}
