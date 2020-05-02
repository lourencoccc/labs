package com.faturista.integracao;

import com.faturista.integracao.po.ClienteEntity;
import org.springframework.data.repository.CrudRepository;


public interface ClienteDao extends CrudRepository<ClienteEntity, Long> {

}
