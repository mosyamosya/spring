package com.dubinetska.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Demo1Application {
@RestController
public class HotelBookingController {

    @GetMapping("/rooms")
    public String getAvailableRooms() {
        return "Список доступних номерів";
    }
}
    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }
}
