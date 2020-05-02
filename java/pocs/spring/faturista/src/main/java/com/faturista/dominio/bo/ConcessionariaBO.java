package com.faturista.dominio.bo;

import com.faturista.dominio.model.Concessionaria;
import com.faturista.integracao.ConcessionariaDao;
import com.faturista.integracao.po.ConcessionariaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Component(value = "concessionariaBO")
public class ConcessionariaBO implements Serializable {

  private final ConcessionariaDao concessionariaDao;

  @Autowired
  public ConcessionariaBO(ConcessionariaDao concessionariaDao) {
    this.concessionariaDao = concessionariaDao;
  }

  public List<Concessionaria> buscarTodos() {
    List<Concessionaria> concessionarias = new ArrayList<>();
    for (ConcessionariaEntity entity : concessionariaDao.findAll()) {
      concessionarias.add(new Concessionaria(entity.getId(), entity.getNome()));
    }
    return concessionarias;
  }

  public Concessionaria salvar(final Concessionaria concessionaria) {
    ConcessionariaEntity concessionariaEntity = new ConcessionariaEntity();
    copiarParaEnity(concessionaria, concessionariaEntity);
    concessionariaEntity = concessionariaDao.save(concessionariaEntity);
    concessionaria.setId(concessionariaEntity.getId());
    return concessionaria;
  }

  public Concessionaria buscarPorId(final Long id) {
    return null;
  }

  void copiarParaEnity(final Concessionaria concessionaria,
      final ConcessionariaEntity concessionariaEntity) {
    concessionariaEntity.setId(concessionaria.getId());
    concessionariaEntity.setNome(concessionaria.getName());
  }

  void copiarParaConcessionaria(final ConcessionariaEntity concessionariaEntity,
      final Concessionaria concessionaria) {
    concessionaria.setId(concessionariaEntity.getId());
    concessionaria.setName(concessionariaEntity.getNome());
  }


}
