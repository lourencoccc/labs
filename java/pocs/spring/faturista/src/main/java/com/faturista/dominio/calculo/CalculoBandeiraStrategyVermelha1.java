package com.faturista.dominio.calculo;

import java.math.BigDecimal;


public class CalculoBandeiraStrategyVermelha1 extends CalculoBandeiraStrategy {

  public CalculoBandeiraStrategyVermelha1() {
    super(new BigDecimal(0.03));
  }

  public BigDecimal calculo(final Integer kwh) {
    return fator.multiply(new BigDecimal(kwh));
  }
}
