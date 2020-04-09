package com.codeclan.example.CourseBookingLab.components;

import com.codeclan.example.CourseBookingLab.models.Booking;
import com.codeclan.example.CourseBookingLab.models.Course;
import com.codeclan.example.CourseBookingLab.models.Customer;
import com.codeclan.example.CourseBookingLab.repositories.BookingRepository;
import com.codeclan.example.CourseBookingLab.repositories.CourseRepository;
import com.codeclan.example.CourseBookingLab.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component

public class DataLoader implements ApplicationRunner {
    
    @Autowired
    CourseRepository courseRepository;
    
    @Autowired
    CustomerRepository customerRepository;
    
    @Autowired
    BookingRepository bookingRepository;
    
    public DataLoader(){
        
    }
    
    public void run(ApplicationArguments args) {

        Course course1 = new Course("Intro to Ruby", "Edinburgh", 4);
        Course course2 = new Course("Javascript Basics", "Glasgow", 3);
        courseRepository.save(course1);
        courseRepository.save(course2);
        
        Customer customer1 = new Customer("Bob", "Stirling", 34);
        Customer customer2 = new Customer("John", "Dundee", 23);
        customerRepository.save(customer1);
        customerRepository.save(customer2);

        Booking booking1 = new Booking("01-05-20", course1, customer1);
        Booking booking2 = new Booking("05-08-20", course2, customer2);
        Booking booking3 = new Booking("05-08-20", course2, customer1);

        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);

        course1.addBooking(booking1);
        courseRepository.save(course1);

        course2.addBooking(booking2);
        courseRepository.save(course2);

        course1.addBooking(booking3);
        courseRepository.save(course1);

        customer1.addBooking(booking1);
        customerRepository.save(customer1);

        customer2.addBooking(booking2);
        customerRepository.save(customer2);

        customer1.addBooking(booking3);
        customerRepository.save(customer1);
    }
}
