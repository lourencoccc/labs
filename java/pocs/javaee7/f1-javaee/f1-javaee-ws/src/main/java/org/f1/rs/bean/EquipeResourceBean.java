/**
 * Copyright (c) 2011-2012, IBSOFT.
 * All rights reserved.
 */
package org.f1.rs.bean;

import java.util.List;

import javax.inject.Inject;

import org.f1.entity.Equipe;
import org.f1.exception.F1Exception;
import org.f1.rs.EquipeResource;
import org.f1.service.EquipeService;

/**
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
public class EquipeResourceBean implements EquipeResource {

    private static final long serialVersionUID = 5481252114941052436L;

    @Inject
    private EquipeService equipeService;

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.f1.rs.EquipeResource#listarEquipes(java.lang.Integer,
     * java.lang.Integer)
     */
    @Override
    public List<Equipe> listar(Integer first, Integer max) throws F1Exception {
        List<Equipe> equipes = equipeService.listarEquipes(first, max);
        return equipes;
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.f1.rs.EquipeResource#buscarEquipePorId(java.lang.Long)
     */
    @Override
    public Equipe buscarEquipePor(Long id) throws F1Exception {
        Equipe equipe = equipeService.buscarEquipe(id);
        return equipe;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.rs.EquipeResource#salvarEquipe(br.com.ibsoft.f1.entity
     * .Equipe)
     */
    @Override
    public Equipe salvar(Equipe equipe) throws F1Exception {
        return equipeService.salvarEquipe(equipe);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.rs.EquipeResource#atualizarEquipe(br.com.ibsoft.f1.entity
     * .Equipe)
     */
    @Override
    public Equipe atualizar(Equipe equipe) throws F1Exception {
        return equipeService.atualizarEquipe(equipe);
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.f1.rs.EquipeResource#deletarEquipe(java.lang.Long)
     */
    @Override
    public void deletar(Long id) throws F1Exception {
        equipeService.deletarEquipe(id);
    }
}
