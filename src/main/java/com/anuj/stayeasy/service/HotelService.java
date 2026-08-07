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
    
    public Hotel getHotelById(Long id) {

    return hotelRepository.findById(id)
            .orElse(null);
    }

    public Hotel updateHotel(Long id, Hotel updatedHotel) {

        Hotel existingHotel = hotelRepository.findById(id)
                .orElse(null);

        if (existingHotel == null) {
            return null;
        }

        existingHotel.setName(updatedHotel.getName());
        existingHotel.setDescription(updatedHotel.getDescription());
        existingHotel.setCity(updatedHotel.getCity());
        existingHotel.setAddress(updatedHotel.getAddress());
        existingHotel.setTotalRooms(updatedHotel.getTotalRooms());
        existingHotel.setAvailableRooms(updatedHotel.getAvailableRooms());

        return hotelRepository.save(existingHotel);
    }

    public void deleteHotel(Long id) {

        Hotel hotel = hotelRepository.findById(id)
                .orElse(null);

        if (hotel != null) {
            hotelRepository.delete(hotel);
        }
    }

}

