package com.anuj.stayeasy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anuj.stayeasy.entity.Hotel;
import com.anuj.stayeasy.repository.HotelRepository;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel createHotel(Hotel hotel) {

        // Initially all rooms are available
        hotel.setAvailableRooms(hotel.getTotalRooms());

        // Save hotel
        return hotelRepository.save(hotel);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }      
}

