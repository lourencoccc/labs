package com.faturista.dominio.bo;

import com.faturista.dominio.calculo.CalculoBandeiraFactory;
import com.faturista.dominio.calculo.CalculoBandeiraStrategy;
import com.faturista.dominio.model.Cliente;
import com.faturista.dominio.model.Fatura;
import com.faturista.integracao.ClienteDao;
import com.faturista.integracao.FaturaDao;
import com.faturista.integracao.po.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component(value = "faturaBO")
public class FaturaBO {

  private final ClienteDao clienteDao;
  private final FaturaDao faturaDao;
  private final CalculoBandeiraFactory calculoBandeiraFactory;

  @Autowired
  public FaturaBO(ClienteDao clienteDao,
      FaturaDao faturaDao,
      CalculoBandeiraFactory calculoBandeiraFactory) {
    this.clienteDao = clienteDao;
    this.faturaDao = faturaDao;
    this.calculoBandeiraFactory = calculoBandeiraFactory;
  }

  public List<Fatura> buscarTodos() {
    List<Fatura> faturas = new ArrayList<>();
    return faturas;
  }

  public Fatura salvar(Fatura fatura) {
    CalculoBandeiraStrategy flagCalc = calculoBandeiraFactory
        .createFlagCalcStrategy(fatura.getBandeira().getTipoBandeira());
    BigDecimal flagValue = flagCalc.calculo(fatura.getConsumption());
    return null;
  }


}
