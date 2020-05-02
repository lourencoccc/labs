package com.faturista.dominio.model;

import java.io.Serializable;
import java.math.BigDecimal;


public class Bandeira implements Serializable {

  private String description;
  private BigDecimal value;
  private BigDecimal factor;
  private TipoBandeira tipoBandeira;

  public Bandeira() {
  }

  public Bandeira(TipoBandeira tipoBandeira, String description, BigDecimal value, BigDecimal factor) {
    this.tipoBandeira = tipoBandeira;
    this.description = description;
    this.value = value;
    this.factor = factor;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public BigDecimal getFactor() {
    return factor;
  }

  public void setFactor(BigDecimal factor) {
    this.factor = factor;
  }

  public TipoBandeira getTipoBandeira() {
    return tipoBandeira;
  }

  public void setTipoBandeira(TipoBandeira tipoBandeira) {
    this.tipoBandeira = tipoBandeira;
  }
}
