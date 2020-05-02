package com.faturista.dominio.calculo;

import java.math.BigDecimal;


public abstract class CalculoBandeiraStrategy {

  final BigDecimal fator;

  CalculoBandeiraStrategy(final BigDecimal fator) {
    this.fator = fator;
  }

  public BigDecimal getFator() {
    return this.fator;
  }

  public abstract BigDecimal calculo(final Integer kwh);

}
