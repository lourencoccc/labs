package org.f1.test.dao;

import java.io.File;

import org.f1.dao.produces.DaoProduces;
import org.f1.entity.BaseEntity;
import org.f1.entity.Equipe;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

public class F1DaoDeployment {

    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "saude-familia-ws.war")
                         .addAsLibraries(new File("target/test-lib/ibsoft-suporte-dao-0.0.1-SNAPSHOT.jar"),
                             new File("target/test-lib/f1-javaee-dao-0.0.1-SNAPSHOT.jar"))
                         .addPackages(true, BaseEntity.class.getPackage(), DaoProduces.class.getPackage(),
                             Equipe.class.getPackage(), F1DaoDeployment.class.getPackage())
                         .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                         .addAsResource("import.sql").addAsWebInfResource("test-ds.xml")
                         .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }
}
