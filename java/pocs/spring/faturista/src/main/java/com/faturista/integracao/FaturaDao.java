package com.faturista.integracao;

import com.faturista.integracao.po.FaturaEntity;
import org.springframework.data.repository.CrudRepository;


public interface FaturaDao extends CrudRepository<FaturaEntity, Long> {

}
