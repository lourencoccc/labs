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
import java.util.Date;
import java.util.List;

import org.f1.dao.PilotoDao;
import org.f1.entity.Piloto;
import org.f1.exception.F1Exception;
import org.f1.service.PilotoService;
import org.f1.service.bean.PilotoServiceBean;
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
public class PilotoServiceTest implements Serializable {

    private static final long serialVersionUID = 1L;

    private PilotoService service;
    @Mock
    private PilotoDao pilotoDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        service = new PilotoServiceBean(pilotoDao);
    }

    @Test
    public void deveChamarPersistDePilotoRepository() throws F1Exception {
        // dado
        Piloto piloto = new Piloto();
        piloto.setDataNascimento(new Date());
        piloto.setLicensa("012");
        piloto.setNome("Force India");

        // quando
        service.salvarPiloto(piloto);

        // verifique
        verify(pilotoDao).persist(piloto);
    }

    @Test
    public void deveChamarUpdateDePilotoRepository() throws F1Exception {
        // dado
        Piloto piloto = new Piloto();
        piloto.setId(12L);
        piloto.setDataNascimento(new Date());
        piloto.setLicensa("012");
        piloto.setNome("Force India");

        // quando
        service.atualizarPiloto(piloto);

        // verifique
        verify(pilotoDao).update(piloto);
    }

    @Test
    public void naoDeveChamarUpdateDePilotoRepositoryComIdNull() throws F1Exception {
        // dado
        Piloto piloto = new Piloto();
        piloto.setId(null);
        piloto.setDataNascimento(new Date());
        piloto.setLicensa("012");
        piloto.setNome("Force India");

        // quando
        service.atualizarPiloto(piloto);

        // verifique
        verify(pilotoDao, times(0)).update(piloto);
    }

    @Test
    public void deveBuscarPilotoPorId() {
        // dado
        Long id = 12L;
        Piloto Piloto = new Piloto(id, "mercedes");
        when(pilotoDao.findById(Piloto.class, id)).thenReturn(Piloto);

        // quando
        Piloto PilotoActual = service.buscarPiloto(id);

        // verifique
        assertEquals(Piloto, PilotoActual);
    }

    @Test
    public void deveListarTodasPilotosComPaginacao() {
        // dado
        Integer firstResult = 0, maxResults = 1;
        Piloto Piloto = new Piloto(12L, "mercedes");
        List<Piloto> Pilotos = Arrays.asList(Piloto);
        when(pilotoDao.find(null, Piloto.class, firstResult, maxResults)).thenReturn(Pilotos);

        // quando
        List<Piloto> PilotosActual = service.listarPilotos(firstResult, maxResults);

        // verifique
        assertThat(PilotosActual, hasItem(Piloto));
    }

    @Test
    public void deveListarNoMaximo50Pilotos() {
        // dado
        Integer firstResult = 0, maxResults = 51;

        // quando
        service.listarPilotos(firstResult, maxResults);

        // verifique
        verify(pilotoDao).find(null, Piloto.class, firstResult, new Integer(50));
    }

    @Test
    public void firstResultDaListaDePilotosTemDefaultZero() {
        // dado
        Integer firstResult = -1, maxResults = 1;

        // quando
        service.listarPilotos(firstResult, maxResults);

        // verifique
        verify(pilotoDao).find(null, Piloto.class, new Integer(0), maxResults);
    }

    @Test
    public void maxResultsDaListaDePilotosTemDefault50() {
        // dado
        Integer firstResult = 0, maxResults = null;

        // quando
        service.listarPilotos(firstResult, maxResults);

        // verifique
        verify(pilotoDao).find(null, Piloto.class, firstResult, new Integer(50));
    }
}
