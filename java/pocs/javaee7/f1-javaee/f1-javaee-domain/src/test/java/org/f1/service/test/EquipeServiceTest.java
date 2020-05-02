/**
 * Copyright (c) 2011-2012, IBSOFT.
 * All rights reserved.
 */
package org.f1.service.test;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.f1.dao.EquipeDao;
import org.f1.entity.Equipe;
import org.f1.exception.F1Exception;
import org.f1.service.EquipeService;
import org.f1.service.bean.EquipeServiceBean;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
public class EquipeServiceTest implements Serializable {

    private static final long serialVersionUID = 1L;

    private EquipeService service;
    @Mock
    private EquipeDao equipeDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        service = new EquipeServiceBean(equipeDao);
    }

    @Test
    public void deveChamarPersistDeEquipeRepository() throws F1Exception {
        // dado
        Equipe equipe = new Equipe();
        equipe.setNome("Force India");

        // quando
        service.salvarEquipe(equipe);

        // verifique
        verify(equipeDao).persist(equipe);
    }

    @Test
    public void deveChamarUpdateDeEquipeRepository() throws F1Exception {
        // dado
        Equipe equipe = new Equipe();
        equipe.setId(12L);
        equipe.setNome("Force India");

        // quando
        service.atualizarEquipe(equipe);

        // verifique
        verify(equipeDao).update(equipe);
    }

    @Test
    public void naoDeveChamarUpdateDeEquipeRepositoryComIdNull() throws F1Exception {
        // dado
        Equipe equipe = new Equipe();
        equipe.setId(null);
        equipe.setNome("Force India");

        // quando
        service.atualizarEquipe(equipe);

        // verifique
        verify(equipeDao, times(0)).update(equipe);
    }

    @Test
    public void deveBuscarEquipePorId() {
        // dado
        Long id = 12L;
        Equipe equipe = new Equipe(id, "mercedes");
        when(equipeDao.findById(Equipe.class, id)).thenReturn(equipe);

        // quando
        Equipe equipeActual = service.buscarEquipe(id);

        // verifique
        assertEquals(equipe, equipeActual);
    }

    @Test
    public void deveListarTodasEquipesComPaginacao() {
        // dado
        Integer firstResult = 0, maxResults = 1;
        Equipe equipe = new Equipe(12L, "mercedes");
        List<Equipe> equipes = Arrays.asList(equipe);
        when(equipeDao.find(null, Equipe.class, firstResult, maxResults)).thenReturn(equipes);

        // quando
        List<Equipe> equipesActual = service.listarEquipes(firstResult, maxResults);

        // verifique
        assertThat(equipesActual, hasItem(equipe));
    }

    @Test
    public void deveListarNoMaximo50Equipes() {
        // dado
        Integer firstResult = 0, maxResults = 51;

        // quando
        service.listarEquipes(firstResult, maxResults);

        // verifique
        verify(equipeDao).find(null, Equipe.class, firstResult, new Integer(50));
    }

    @Test
    public void firstResultDaListaDeEquipesTemDefaultZero() {
        // dado
        Integer firstResult = -1, maxResults = 1;

        // quando
        service.listarEquipes(firstResult, maxResults);

        // verifique
        verify(equipeDao).find(null, Equipe.class, new Integer(0), maxResults);
    }

    @Test
    public void maxResultsDaListaDeEquipesTemDefault50() {
        // dado
        Integer firstResult = 0, maxResults = null;

        // quando
        service.listarEquipes(firstResult, maxResults);

        // verifique
        verify(equipeDao).find(null, Equipe.class, firstResult, new Integer(50));
    }
}
