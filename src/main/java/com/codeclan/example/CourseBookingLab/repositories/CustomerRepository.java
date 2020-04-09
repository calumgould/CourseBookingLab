package com.codeclan.example.CourseBookingLab.repositories;

import com.codeclan.example.CourseBookingLab.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseId(Long courseId);

    List<Customer> findByBookingsCourseTownIgnoreCaseAndBookingsCourseId(String town, Long courseId);

    List<Customer> findByBookingsCourseTownIgnoreCaseAndBookingsCourseIdAndAgeGreaterThan(String town, Long courseId, int age);

}
