package com.nnk.springboot.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import lombok.Data;

@Data
@Entity
@Table(name = "bidlist")
public class BidList {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Id")
  private Integer BidListId;

  @Column(name = "account", nullable = false, length = 30)
  private String account;

  @Column(name = "type", nullable = false, length = 30)
  private String type;

  @Column(name = "bidQuantity")
  @Digits(message = "Bid quantity is numeric", integer = 10, fraction = 2)
  private Double bidQuantity;

  @Column(name = "askQuantity")
  @Digits(message = "Ask quantity is numeric", integer = 10, fraction = 2)
  private Double askQuantity;

  @Column(name = "bid")
  @Digits(message = "Bid is numeric", integer = 10, fraction = 2)
  private Double bid;

  @Column(name = "ask")
  @Digits(message = "Ask is numeric", integer = 10, fraction = 2)
  private Double ask;

  @Column(name = "benchmark", length = 125)
  private String benchMark;

  @Column(name = "bidListDate")
  private Timestamp bidListDate;

  @Column(name = "commentary", length = 125)
  private String commentary;

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

  public BidList(String account, String type, Double bidQuantity) {
    this.account = account;
    this.type = type;
    this.bidQuantity = bidQuantity;
  }

  public BidList() {

  }

}
