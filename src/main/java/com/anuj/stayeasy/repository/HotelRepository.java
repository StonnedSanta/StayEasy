package com.anuj.stayeasy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anuj.stayeasy.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>{

    List<Hotel> findByName(String name);
}
