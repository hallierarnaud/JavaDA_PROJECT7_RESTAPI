package com.nnk.springboot.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "curvepoint")
public class CurvePoint {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "CurveId")
  private Integer curveId;

  @Column(name = "asOfDate")
  private Timestamp asOfDate;

  @Column(name = "term")
  private Double term;

  @Column(name = "value")
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
