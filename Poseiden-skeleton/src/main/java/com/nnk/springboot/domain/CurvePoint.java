package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "curvepoint")
public class CurvePoint {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "CurveId")
  @NotNull(message = "Curve must not be null")
  @Digits(message = "Curve id is numeric", integer = 10, fraction = 0)
  private Integer curveId;

  @Column(name = "asOfDate")
  private Timestamp asOfDate;

  @Column(name = "term")
  @NotNull(message = "Term must not be null")
  @Digits(message = "Term is numeric", integer = 10, fraction = 2)
  private Double term;

  @Column(name = "value")
  @NotNull(message = "Value must not be null")
  @Digits(message = "Value is numeric", integer = 10, fraction = 2)
  private Double value;

  @Column(name = "creationDate")
  private Timestamp creationDate;

  public CurvePoint(Integer curveId, Double term, Double value) {
    this.curveId = curveId;
    this.term = term;
    this.value = value;
  }

  public CurvePoint() {

  }

}
