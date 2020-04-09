package com.codeclan.example.CourseBookingLab.controllers;

import com.codeclan.example.CourseBookingLab.models.Customer;
import com.codeclan.example.CourseBookingLab.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

        @Autowired
        CustomerRepository customerRepository;

        @GetMapping
        public ResponseEntity<List<Customer>> getAllCustomer(
                @RequestParam(required = false, name = "courseId") Long courseId
        ) {
            if (courseId != null){
                return new ResponseEntity<>(customerRepository.findByBookingsCourseId(courseId), HttpStatus.OK);
            }
            return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
        }

        @GetMapping(value = "/{id}")
        public ResponseEntity getCustomer(@PathVariable Long id){
            return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer){
            customerRepository.save(customer);
            return new ResponseEntity<>(customer, HttpStatus.CREATED);
        }

        @DeleteMapping(value = "/{id}")
        public ResponseEntity<Long> deleteCustomer(@PathVariable Long id){
            customerRepository.deleteById(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        }
}
