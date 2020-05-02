package com.faturista.dominio.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class Fatura implements Serializable{

  private Long id;

  private Integer consumption;

  private Date due;

  private BigDecimal value;

  private Bandeira bandeira;

  public Fatura() {
  }

  public Fatura(Long id, Integer consumption, Date due, BigDecimal value,
                Bandeira bandeira) {
    this.id = id;
    this.consumption = consumption;
    this.due = due;
    this.value = value;
    this.bandeira = bandeira;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getConsumption() {
    return consumption;
  }

  public void setConsumption(Integer consumption) {
    this.consumption = consumption;
  }

  public Date getDue() {
    return due;
  }

  public void setDue(Date due) {
    this.due = due;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public Bandeira getBandeira() {
    return bandeira;
  }

  public void setBandeira(Bandeira bandeira) {
    this.bandeira = bandeira;
  }
}
