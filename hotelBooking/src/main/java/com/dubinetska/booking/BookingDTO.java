package com.dubinetska.booking;

import java.time.LocalDate;

public class BookingDTO {

  private Long userId;
  private Long roomId;

  private LocalDate date;
  private LocalDate expiredAt;
  private String isExpired;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getRoomId() {
    return roomId;
  }

  public void setRoomId(Long roomId) {
    this.roomId = roomId;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public String getIsExpired() {
    return isExpired;
  }

  public void setIsExpired(String isExpired) {
    this.isExpired = isExpired;
  }

  public LocalDate getExpiredAt() {
    return expiredAt;
  }

  public void setExpiredAt(LocalDate expiredAt) {
    this.expiredAt = expiredAt;
  }

}

