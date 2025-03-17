package com.dubinetska.booking.pages;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dubinetska.booking.Booking;
import com.dubinetska.booking.BookingService;
import com.dubinetska.booking.Room;
import com.dubinetska.user.User;
import com.dubinetska.user.UserService;

import jakarta.validation.Valid;

/**
 * BookingPageController
 */
@Controller
@RequestMapping("/views/rooms")
public class BookingPageController {

  private static final String REDIRECT_ROOMS = "redirect:/views/rooms";

  private final BookingService bookingService;
  private final UserService userService;

  public BookingPageController(BookingService bookingService, UserService userService) {
    this.bookingService = bookingService;
    this.userService = userService;
  }

  @GetMapping
  public String viewRooms(Model model) {
    List<Room> rooms = bookingService.getAllRooms();
    model.addAttribute("rooms", rooms);

    return "rooms";
  }

  @GetMapping("/create")
  public String createRoomForm(Model model) {
    model.addAttribute("room", new Room());
    return "createRoom";
  }

  @PostMapping
  public String createRoom(@Valid @ModelAttribute Room room, BindingResult bindingResult, Model model) {
    if(bindingResult.hasErrors()) {
      model.addAttribute("room", room);
      return "createRoom";
    }
    bookingService.createRoom(room);
    return REDIRECT_ROOMS;
  }

  @DeleteMapping("/{id}")
  public String deleteRoom(@PathVariable Long id) {
    System.out.println(id);
    bookingService.deleteRoom(id);
    return REDIRECT_ROOMS;
  }

  @GetMapping("/{id}/update")
  public String showUpdateForm(@PathVariable Long id, Model model) {
    Room room = bookingService.getRoomById(id).orElseThrow(() -> new IllegalArgumentException("Invalid room id"));
    model.addAttribute("room", room);
    return "updateRoom"; 
  }

  @PostMapping("/{id}/update")
  public String updateRoom(@PathVariable Long id, @Valid @ModelAttribute Room room, BindingResult bindingResult, Model model) {
    if(bindingResult.hasErrors()) {
      model.addAttribute("room", room);
      return "updateRoom";
    }
    room.setId(id); 
    bookingService.updateRoom(room); 
    return REDIRECT_ROOMS; 
  }

  @PutMapping("/{id}/bookRoom")
  public String bookRoom(@PathVariable Long id) {
    Room room = bookingService.getRoomById(id).orElseThrow(() -> new IllegalArgumentException("Invalid room id"));
    User user = userService.getUserById(1L).orElseThrow(() -> new IllegalArgumentException("Invalid user id"));
    Booking booking = new Booking(room, user);
    bookingService.bookRoom(booking);

    return REDIRECT_ROOMS;
  }

  @PutMapping("/{id}/unbookRoom")
  public String unbookRoom(@PathVariable Long id) {
    bookingService.unbookRoom(id, 1L);
    return REDIRECT_ROOMS;
  }
}
