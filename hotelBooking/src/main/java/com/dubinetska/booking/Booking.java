package com.dubinetska.booking;
import java.time.LocalDate;

import com.dubinetska.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
/**
 * Booking
 */
@Entity
@Table(name = "booking")
@IdClass(BookingId.class)
public class Booking {

  @ManyToOne
  @Id
  @JoinColumn(name = "room_id", nullable = false)
  private Room room;

  @ManyToOne
  @Id
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  private LocalDate bookedAt = LocalDate.now();

  private LocalDate expiredAt = LocalDate.now().plusDays(3);

  private boolean isExpired = false;

  public Booking() {
  }

  public Booking(Room room, User user) {
    this.room = room;
    this.user = user;
  }

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public LocalDate getBookedAt() {
    return bookedAt;
  }

  public void setBookedAt(LocalDate bookedAt) {
    this.bookedAt = bookedAt;
  }

  public boolean isExpired() {
    return isExpired;
  }

  public void setExpired(boolean isExpired) {
    this.isExpired = isExpired;
  }

  public LocalDate getExpiredAt() {
    return expiredAt;
  }

  public void setExpiredAt(LocalDate expiredAt) {
    this.expiredAt = expiredAt;
  }

}
