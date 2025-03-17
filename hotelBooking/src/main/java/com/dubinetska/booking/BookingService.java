package com.dubinetska.booking;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


/**
 * BookingService
 */
@Service
public class BookingService {

  private final RoomRepository roomRepository;
  private final BookingRepository bookingRepository;

  public BookingService(RoomRepository roomRepository, BookingRepository bookingRepository) {
    this.roomRepository = roomRepository;
    this.bookingRepository = bookingRepository;
  }

  public List<Room> getAllRooms() {
    return roomRepository.findAllWithBookingStatus();
  }

  public Optional<Room> getRoomById(Long id) {
    return roomRepository.findById(id);
  }

  public Room createRoom(Room room) {
    return roomRepository.save(room);
  }

  public void deleteRoom(Long id) {
    bookingRepository.deleteByRoomId(id);
    roomRepository.deleteById(id);
  }

  public void updateRoom(Room room) {
    roomRepository.save(room);
  }

  public void unbookRoom(Long roomId, Long userId) {
    bookingRepository.unbookRoom(roomId, userId);
  }

  public Booking bookRoom(Booking Booking) {
    return bookingRepository.save(Booking);
  }

}
