package com.faturista.dominio.calculo;

import java.math.BigDecimal;


public class CalculoBandeiraStrategyVerde extends CalculoBandeiraStrategy {

  public CalculoBandeiraStrategyVerde() {
    super(BigDecimal.ZERO);
  }

  public BigDecimal calculo(final Integer kwh) {
    return fator.multiply(new BigDecimal(kwh));
  }

}
