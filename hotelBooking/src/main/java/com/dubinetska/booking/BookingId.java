package com.dubinetska.booking;

import com.dubinetska.user.User;

import java.io.Serializable;


/**
 * BookingId
 */
public class BookingId implements Serializable {
@SuppressWarnings("unused")
  private User user;
  @SuppressWarnings("unused")
  private Room room;

  public BookingId() {

  }

  public BookingId(User user, Room room) {
    this.room = room;
    this.user = user;
  }

}