package com.webkaps.hotel.controller;

import com.webkaps.hotel.model.Hotel;
import com.webkaps.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hotel-api")
public class HotelController {

    @Autowired
    HotelService hotelService;
    @PostMapping
    public ResponseEntity<Hotel> saveHotelDetail(@RequestBody Hotel hotel){
        String hotelId =  UUID.randomUUID().toString();
        hotel.setHotelId(hotelId);
        Hotel savedHotelDetail = hotelService.saveHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHotelDetail);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> allHotels = hotelService.getAllHotels();
        return ResponseEntity.ok(allHotels);
    }

    @GetMapping("/{hotelId}")
    public  ResponseEntity<Hotel>  getHotelById(@PathVariable String hotelId){
        Hotel hotel = hotelService.getHotelById(hotelId);
        return ResponseEntity.ok(hotel);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Hotel>> getRatingByUserId(@PathVariable String userId){
        List<Hotel> hotelByUserId = hotelService.getHotelByUserId(userId);
        return ResponseEntity.ok(hotelByUserId);
    }
}
