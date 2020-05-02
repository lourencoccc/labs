/**
 * Copyright (c) 2011-2012, IBSOFT.
 * All rights reserved.
 */
package br.com.ibsoft.f1.rs.client;

import java.io.Serializable;
import java.util.List;

import org.f1.entity.Equipe;

/**
 * @author lourenco
 * 
 * @since v1.0.0
 */
public interface EquipeResourceClient extends Serializable {

    List<Equipe> listar(Integer first, Integer max) throws Exception;

    Equipe buscarEquipePor(Long id);

    Equipe salvar(Equipe equipe);

    Equipe atualizar(Equipe equipe);

    void deletar(Long id);

}
