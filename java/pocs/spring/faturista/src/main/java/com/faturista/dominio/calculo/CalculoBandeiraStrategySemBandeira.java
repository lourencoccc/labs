package com.faturista.dominio.calculo;

import java.math.BigDecimal;


public class CalculoBandeiraStrategySemBandeira extends CalculoBandeiraStrategy {

    public CalculoBandeiraStrategySemBandeira() {
        super(BigDecimal.ZERO);
    }

    public BigDecimal calculo(final Integer kwh) {
        return fator;
    }

}
