/**
 * Copyright (c) 2011-2012, IBSOFT.
 * All rights reserved.
 */
package br.com.ibsoft.f1.rs.client.test;

import java.io.Serializable;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.ibsoft.f1.rs.client.EquipeResourceClient;
import br.com.ibsoft.f1.rs.client.bean.EquipeResourceClientBean;

/**
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
@RunWith(Arquillian.class)
public class EquipeResourceClientTest implements Serializable {

    private static final long serialVersionUID = 8471577473347440643L;

    private EquipeResourceClient resourceClient;

    @Before
    public void setUp() {
        resourceClient = new EquipeResourceClientBean(null);
    }

    @Deployment
    public static Archive<?> creatDeployment() {
        return F1RestDeployment.createDeployment().addPackages(true, EquipeResourceClient.class.getPackage(),
            EquipeResourceClientBean.class.getPackage());
    }

    @Test
    public void deve_listar_equipes() throws Exception {
        resourceClient.listar(0, 1);
        Assert.assertTrue(true);
    }

}
