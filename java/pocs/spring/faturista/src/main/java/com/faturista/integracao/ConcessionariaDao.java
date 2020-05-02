package com.faturista.integracao;

import com.faturista.integracao.po.ConcessionariaEntity;
import org.springframework.data.repository.CrudRepository;


public interface ConcessionariaDao extends CrudRepository<ConcessionariaEntity, Long> {

}
