package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "trade")
public class Trade {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer tradeId;

  @Column(name = "account", nullable = false, length = 30)
  private String account;

  @Column(name = "type", nullable = false, length = 30)
  private String type;

  @Column(name = "buyQuantity")
  private Double buyQuantity;

  @Column(name = "sellQuantity")
  private Double sellQuantity;

  @Column(name = "buyPrice")
  private Double buyPrice;

  @Column(name = "sellPrice")
  private Double sellPrice;

  @Column(name = "benchmark", length = 125)
  private String benchMark;

  @Column(name = "tradeDate")
  private Timestamp tradeDate;

  @Column(name = "security", length = 125)
  private String security;

  @Column(name = "status", length = 10)
  private String status;

  @Column(name = "trader", length = 125)
  private String trader;

  @Column(name = "book", length = 125)
  private String book;

  @Column(name = "creationName", length = 125)
  private String creationName;

  @Column(name = "creationDate")
  private Timestamp creationDate;

  @Column(name = "revisionName", length = 125)
  private String revisionName;

  @Column(name = "revisionDate")
  private Timestamp revisionDate;

  @Column(name = "dealName", length = 125)
  private String dealName;

  @Column(name = "dealType", length = 125)
  private String dealType;

  @Column(name = "sourceListId", length = 125)
  private String sourceListId;

  @Column(name = "side", length = 125)
  private String side;

  public Trade(String account, String type) {
    this.account = account;
    this.type = type;
  }

  public Trade() {

  }

}
