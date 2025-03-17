package com.dubinetska.booking;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
// import lombok.Data;

@Entity
@Table(name = "rooms")
public class Room {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "Room must have at least 1 bed")
  @Min(value = 1, message = "Room must have at least 1 bed")
  @Column(nullable = false)
  private Integer bed;

  @NotBlank(message = "Name cannot be empty")
  @Column(nullable = false)
  private String name;

  @OneToOne(mappedBy = "room", fetch = FetchType.LAZY)
  private Booking booking;

  public Long getId() {
    return id;
  }

  public Integer getBed() {
    return bed;
  }

  public void setBed(Integer bed) {
    this.bed = bed;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Booking getBooking() {
    return booking;
  }
}