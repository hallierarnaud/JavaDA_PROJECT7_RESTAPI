package com.nnk.springboot.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "trade")
public class Trade {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Id")
  private Integer tradeId;

  @Column(name = "account", nullable = false, length = 30)
  @NotBlank(message = "Account is mandatory")
  private String account;

  @Column(name = "type", nullable = false, length = 30)
  @NotBlank(message = "Type is mandatory")
  private String type;

  @Column(name = "buyQuantity")
  @NotNull(message = "Buy quantity must not be null")
  @Digits(message = "Buy quantity is numeric", integer = 10, fraction = 2)
  private Double buyQuantity;

  @Column(name = "sellQuantity")
  @Digits(message = "Sell quantity is numeric", integer = 10, fraction = 2)
  private Double sellQuantity;

  @Column(name = "buyPrice")
  @Digits(message = "Buy price is numeric", integer = 10, fraction = 2)
  private Double buyPrice;

  @Column(name = "sellPrice")
  @Digits(message = "Sell price is numeric", integer = 10, fraction = 2)
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

  public Trade(String account, String type, Double buyQuantity) {
    this.account = account;
    this.type = type;
    this.buyQuantity = buyQuantity;
  }

  public Trade() {

  }

}
