package com.faturista.dominio.calculo;

import java.math.BigDecimal;


public class CalculoBandeiraStrategyAmarela extends CalculoBandeiraStrategy {

  public CalculoBandeiraStrategyAmarela() {
    super(new BigDecimal(0.01));
  }

  public BigDecimal calculo(final Integer kwh) {
    return fator.multiply(new BigDecimal(kwh));
  }
}
