package examplewar.service;

import examplewar.model.Cliente
import examplewar.produces.DaoProduces
import examplewar.service.ClienteService;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.io.File;

/**
 * Created by joao on 19/05/14.
 */
@RunWith(Arquillian.class)
public class ClienteServiceTest {

    @Inject
    private ClienteService clienteService

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap
                .create(WebArchive.class, "test.war")
                .addPackages(true, ClienteService.class.getPackage(),
                Cliente.class.getPackage(), DaoProduces.class.getPackage())
                .addAsResource("META-INF/test-persistence.xml",
                "META-INF/persistence.xml")
                .addAsWebInfResource("test-ds.xml")
                .addAsLibraries(new File("/home/joao/.gradle/caches/modules-2/files-2.1/org.codehaus.groovy/groovy-all/2.3.0/c034699189c8ef92c98c4f483ecb109646f70189/groovy-all-2.3.0.jar"))
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml")
    }


    @Test
    public void test(){
        clienteService.listarTodosClientes();
        Assert.assertTrue(true);
    }

}
