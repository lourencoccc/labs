package com.faturista.dominio.calculo;

import com.faturista.dominio.model.TipoBandeira;
import org.springframework.stereotype.Component;

@Component(value = "flagCalcFactory")
public class CalculoBandeiraFactoryBean extends CalculoBandeiraFactory {

    public CalculoBandeiraStrategy createFlagCalcStrategy(final TipoBandeira flagCalcType) {
        if (TipoBandeira.VERDE == flagCalcType) {
            return new CalculoBandeiraStrategyVerde();
        } else if (TipoBandeira.AMARELA == flagCalcType) {
            return new CalculoBandeiraStrategyAmarela();
        } else if (TipoBandeira.VERMELHA_1 == flagCalcType) {
            return new CalculoBandeiraStrategyVermelha1();
        } else if (TipoBandeira.VERMELHA_2 == flagCalcType) {
            return new CalculoBandeiraStrategyVermelha2();
        } else {
            return new CalculoBandeiraStrategySemBandeira();
        }
    }

}
