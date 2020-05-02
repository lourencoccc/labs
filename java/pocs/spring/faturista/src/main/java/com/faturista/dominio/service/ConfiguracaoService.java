package com.faturista.dominio.service;

import com.faturista.dominio.model.Concessionaria;

import java.util.List;


public interface ConfiguracaoService {

  List<Concessionaria> buscarTodosConcessionarias();

  Concessionaria salvarConcessionaria(Concessionaria concessionaria);

}
