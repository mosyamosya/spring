package com.dubinetska.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

/**
 * BookingRepository
 */
public interface BookingRepository extends JpaRepository<Booking, Long> {

  @Modifying
  @Transactional
  @Query("DELETE FROM Booking b WHERE b.room.id = :roomId AND b.user.id = :userId")
  void unbookRoom( Long roomId, Long userId);

  @Modifying
  @Transactional
  @Query("DELETE FROM Booking b WHERE b.room.id = :roomId")
  void deleteByRoomId(Long roomId);

}