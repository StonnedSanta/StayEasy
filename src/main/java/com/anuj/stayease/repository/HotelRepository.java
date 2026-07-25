package com.anuj.stayease.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anuj.stayease.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>{

    List<Hotel> findByName(String name);
}
