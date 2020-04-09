package com.codeclan.example.CourseBookingLab.repositories;

import com.codeclan.example.CourseBookingLab.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
