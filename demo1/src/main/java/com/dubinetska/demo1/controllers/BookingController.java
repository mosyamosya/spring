package com.dubinetska.demo1.controllers;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController
@RequestMapping("/bookings")
public class BookingController {
    
    @GetMapping("/available-rooms")
    public List<String> getAvailableRooms() {
        return List.of("Room 101", "Room 202", "Room 303");
    }
    
    @PostMapping("/reserve")
    public String bookRoom(@RequestBody String bookingDetails) {
        return "Room booked successfully.";
    }
    
    @DeleteMapping("/{id}")
    public String cancelBooking(@PathVariable Long id) {
        return "Booking cancelled successfully.";
    }
    
    @GetMapping("/{id}")
    public String getBookingDetails(@PathVariable Long id) {
        return "Booking details for ID: " + id;
    }
}
