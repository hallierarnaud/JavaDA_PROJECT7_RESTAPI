package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "rating")
public class Rating {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "moodysRating", length = 125)
  private String moodysRating;

  @Column(name = "sandPRating", length = 125)
  private String sandPRating;

  @Column(name = "fitchRating", length = 125)
  private String fitchRating;

  @Column(name = "orderNumber")
  @Digits(message = "Order number is numeric", integer = 10, fraction = 0)
  private Integer orderNumber;

  public Rating(String moodysRating, String sandPRating, String fitchRating, Integer orderNumber) {
    this.moodysRating = moodysRating;
    this.sandPRating = sandPRating;
    this.fitchRating = fitchRating;
    this.orderNumber = orderNumber;
  }

  public Rating() {

  }

}
