package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "rulename")
public class RuleName {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name", length = 125)
  @NotBlank(message = "Name is mandatory")
  private String name;

  @Column(name = "description", length = 125)
  @NotBlank(message = "Description is mandatory")
  private String description;

  @Column(name = "json", length = 125)
  @NotBlank(message = "json is mandatory")
  private String json;

  @Column(name = "template", length = 512)
  @NotBlank(message = "template is mandatory")
  private String template;

  @Column(name = "sqlStr", length = 125)
  @NotBlank(message = "sqlStr is mandatory")
  private String sqlStr;

  @Column(name = "sqlPart", length = 125)
  @NotBlank(message = "sqlPart is mandatory")
  private String sqlPart;

  public RuleName(String name, String description, String json, String template, String sqlStr, String sqlPart) {
    this.name = name;
    this.description = description;
    this.json = json;
    this.template = template;
    this.sqlStr = sqlStr;
    this.sqlPart = sqlPart;
  }

  public RuleName() {

  }

}
