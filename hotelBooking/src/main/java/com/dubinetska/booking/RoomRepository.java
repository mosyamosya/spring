package com.dubinetska.booking;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * RoomRepository
 */
public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("SELECT r FROM Room r LEFT JOIN FETCH r.booking b WHERE b.isExpired = FALSE OR b IS NULL")
    List<Room> findAllWithBookingStatus();
}