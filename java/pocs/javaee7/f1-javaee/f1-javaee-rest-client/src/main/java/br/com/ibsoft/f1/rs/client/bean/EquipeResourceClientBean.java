/**
 * Copyright (c) 2011-2012, IBSOFT.
 * All rights reserved.
 */
package br.com.ibsoft.f1.rs.client.bean;

import java.util.ArrayList;
import java.util.List;

import org.f1.entity.Equipe;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.util.GenericType;

import br.com.ibsoft.f1.rs.client.EquipeResourceClient;
import br.com.ibsoft.f1.rs.client.F1HttpResourceClient;

/**
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
public class EquipeResourceClientBean extends F1HttpResourceClient implements EquipeResourceClient {

    private static final long serialVersionUID = -4076277045120633831L;

    public EquipeResourceClientBean(String baseUrl) {
        super(baseUrl);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.rs.client.EquipeResourceClient#listarEquipes(java.lang
     * .Integer , java.lang.Integer)
     */
    @Override
    public List<Equipe> listar(Integer first, Integer max) throws Exception {
        ClientRequest request = createRequest("/anuncios");
        ClientResponse<List<Equipe>> response = request.get(new GenericType<List<Equipe>>() {
        });
        List<Equipe> usuarios = new ArrayList<Equipe>(0);
        System.out.println("RESPONSE " + response.getStatus());
        if (response.getStatus() == 200) {
            usuarios = response.getEntity();
        }
        return usuarios;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.rs.client.EquipeResourceClient#buscarEquipePorId(java
     * .lang .Long)
     */
    @Override
    public Equipe buscarEquipePor(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.rs.client.EquipeResourceClient#salvarEquipe(br.com.ibsoft
     * . f1.entity.Equipe)
     */
    @Override
    public Equipe salvar(Equipe equipe) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.rs.client.EquipeResourceClient#atualizarEquipe(br.com
     * .ibsoft .f1.entity.Equipe)
     */
    @Override
    public Equipe atualizar(Equipe equipe) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.rs.client.EquipeResourceClient#deletarEquipe(java.lang
     * .Long)
     */
    @Override
    public void deletar(Long id) {
        // TODO Auto-generated method stub

    }

}
