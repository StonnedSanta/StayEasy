package com.anuj.stayeasy.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anuj.stayeasy.dto.request.HotelRequest;
import com.anuj.stayeasy.dto.response.HotelResponse;
import com.anuj.stayeasy.entity.Hotel;
import com.anuj.stayeasy.service.HotelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public HotelResponse createHotel(@Valid @RequestBody HotelRequest request) {

        Hotel hotel = new Hotel();

        hotel.setName(request.getName());
        hotel.setDescription(request.getDescription());
        hotel.setCity(request.getCity());
        hotel.setAddress(request.getAddress());
        hotel.setTotalRooms(request.getTotalRooms());

        Hotel savedHotel = hotelService.createHotel(hotel);

        HotelResponse response = new HotelResponse();

        response.setId(savedHotel.getId());
        response.setName(savedHotel.getName());
        response.setDescription(savedHotel.getDescription());
        response.setCity(savedHotel.getCity());
        response.setAddress(savedHotel.getAddress());
        response.setTotalRooms(savedHotel.getTotalRooms());
        response.setAvailableRooms(savedHotel.getAvailableRooms());

        if (savedHotel.getManager() != null) {
            response.setManagerId(savedHotel.getManager().getId());
        }

        return response;
    }

    @GetMapping
    public List<HotelResponse> getAllHotels() {

        List<Hotel> hotels = hotelService.getAllHotels();

        return hotels.stream().map(hotel -> {

            HotelResponse response = new HotelResponse();

            response.setId(hotel.getId());
            response.setName(hotel.getName());
            response.setDescription(hotel.getDescription());
            response.setCity(hotel.getCity());
            response.setAddress(hotel.getAddress());
            response.setTotalRooms(hotel.getTotalRooms());
            response.setAvailableRooms(hotel.getAvailableRooms());

            if (hotel.getManager() != null) {
                response.setManagerId(hotel.getManager().getId());
            }

            return response;

        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public HotelResponse getHotelById(@PathVariable Long id) {

        Hotel hotel = hotelService.getHotelById(id);

        if (hotel == null) {
        return null;
        }

        HotelResponse response = new HotelResponse();

        response.setId(hotel.getId());
        response.setName(hotel.getName());
        response.setDescription(hotel.getDescription());
        response.setCity(hotel.getCity());
        response.setAddress(hotel.getAddress());
        response.setTotalRooms(hotel.getTotalRooms());
        response.setAvailableRooms(hotel.getAvailableRooms());

        if (hotel.getManager() != null) {
            response.setManagerId(hotel.getManager().getId());
        }

        return response;
    }

    @PutMapping("/{id}")
    public HotelResponse updateHotel(
            @PathVariable Long id,
            @Valid @RequestBody HotelRequest request) {

        Hotel hotel = new Hotel();

        hotel.setName(request.getName());
        hotel.setDescription(request.getDescription());
        hotel.setCity(request.getCity());
        hotel.setAddress(request.getAddress());
        hotel.setTotalRooms(request.getTotalRooms());

        // Business Rule
        hotel.setAvailableRooms(request.getTotalRooms());

        Hotel updatedHotel = hotelService.updateHotel(id, hotel);

        if (updatedHotel == null) {
            return null;
        }   

        HotelResponse response = new HotelResponse();

        response.setId(updatedHotel.getId());
        response.setName(updatedHotel.getName());
        response.setDescription(updatedHotel.getDescription());
        response.setCity(updatedHotel.getCity());
        response.setAddress(updatedHotel.getAddress());
        response.setTotalRooms(updatedHotel.getTotalRooms());
        response.setAvailableRooms(updatedHotel.getAvailableRooms());

        if (updatedHotel.getManager() != null) {
            response.setManagerId(updatedHotel.getManager().getId());
        }

        return response;
    }

    @DeleteMapping("/{id}")
    public String deleteHotel(@PathVariable Long id) {

        hotelService.deleteHotel(id);

        return "Hotel deleted successfully";
    }

}