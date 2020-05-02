/**
 * Copyright (c) 2011-2012, IBSOFT.
 * All rights reserved.
 */
package org.f1.action;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.f1.exception.F1Exception;
import org.f1.service.EquipeService;

import br.com.ibsoft.f1.entity.Equipe;

/**
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
@Named
@ConversationScoped
public class EquipeAction implements Serializable {

    @Inject
    private Equipe equipe;
    private Long id;
    private List<Equipe> equipes;

    @Inject
    private EquipeService equipeService;
    @Inject
    private Conversation conversation;

    public String criar() {
        this.conversation.begin();
        return "criar?faces-redirect=true";
    }

    public String editar() {
        this.conversation.begin();
        return "criar?faces-redirect=true";
    }

    public String salvar() {
        try {
            equipe = equipeService.salvarEquipe(equipe);
        } catch (F1Exception e) {
            e.printStackTrace();
            return "criar";
        }
        this.conversation.end();
        return "visualizar";
    }

    public String atualizar() {
        try {
            equipe = equipeService.atualizarEquipe(equipe);
        } catch (F1Exception e) {
            e.printStackTrace();
            return "editar";
        }
        this.conversation.end();
        return "visualizar?faces-redirect=true&id=" + equipe.getId();
    }

    public String deletar() {
        this.conversation.begin();
        return "pesquisar?faces-redirect=true";
    }

    public String pesquisar() {
        equipes = equipeService.listarEquipes(0, 100);
        return "pesquisar";
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public Long getId() {
        return id;
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
