package com.faturista.dominio.calculo;

import com.faturista.dominio.model.TipoBandeira;

import java.io.Serializable;

public abstract class CalculoBandeiraFactory implements Serializable{

    public abstract CalculoBandeiraStrategy createFlagCalcStrategy(final TipoBandeira flagCalcType);

}
