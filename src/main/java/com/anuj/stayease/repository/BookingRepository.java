package com.anuj.stayease.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anuj.stayease.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
