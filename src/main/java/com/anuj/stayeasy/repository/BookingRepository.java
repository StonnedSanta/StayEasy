package com.anuj.stayeasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anuj.stayeasy.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
