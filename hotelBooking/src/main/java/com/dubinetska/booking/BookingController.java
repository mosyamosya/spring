package com.dubinetska.booking;

import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.dubinetska.user.UserService;
import com.dubinetska.user.User;

@RestController
@RequestMapping("/rooms")
public class BookingController {

  private final BookingService bookingService;
  private final UserService userService;

  public BookingController(BookingService bookingService, UserService userService) {
    this.bookingService = bookingService;
    this.userService = userService;
  }

  @GetMapping
  public List<Room> getAllRooms() {
    List<Room> rooms = bookingService.getAllRooms();
    System.out.println(rooms);
    return rooms;
  }

  @GetMapping("/{id}")
  public Optional<Room> getRoomById(@PathVariable Long id) {
    return bookingService.getRoomById(id);
  }

  @PostMapping
  public Room createRoom(@RequestBody Room room) {
    return bookingService.createRoom(room);
  }


  @PostMapping("/{roomId}")
  public Booking bookRoom(@RequestBody BookingDTO bookingDTO) {
    Room room = bookingService.getRoomById(bookingDTO.getRoomId()).orElseThrow(() -> new IllegalArgumentException());
    User user = userService.getUserById(bookingDTO.getUserId()).orElseThrow(() -> new IllegalArgumentException());

    Booking booking = new Booking(room, user);
    bookingService.bookRoom(booking);

    return booking;
  }

}
