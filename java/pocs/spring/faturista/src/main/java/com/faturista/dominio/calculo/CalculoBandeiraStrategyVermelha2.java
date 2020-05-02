package com.faturista.dominio.calculo;

import java.math.BigDecimal;


public class CalculoBandeiraStrategyVermelha2 extends CalculoBandeiraStrategy {

  public CalculoBandeiraStrategyVermelha2() {
    super(new BigDecimal(0.05));
  }

  public BigDecimal calculo(final Integer kwh) {
    return fator.multiply(new BigDecimal(kwh));
  }
}
