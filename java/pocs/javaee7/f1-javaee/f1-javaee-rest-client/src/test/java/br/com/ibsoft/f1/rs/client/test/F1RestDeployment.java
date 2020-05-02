/**
 * Copyright (c) 2011-2012, IBSOFT.
 * All rights reserved.
 */
package br.com.ibsoft.f1.rs.client.test;

import java.io.File;

import org.f1.entity.BaseEntity;
import org.f1.entity.Equipe;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

/**
 * @author lourenco
 * 
 * @since v1.0.0
 */
public class F1RestDeployment {

    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "f1-ws.war")
                         .addAsLibraries(new File("target/test-lib/ibsoft-suporte-dao-0.0.1-SNAPSHOT.jar"),
                             new File("target/test-lib/ibsoft-suporte-domain-0.0.1-SNAPSHOT.jar"),
                             new File("target/test-lib/ibsoft-suporte-commons-0.0.1-SNAPSHOT.jar"),
                             new File("target/test-lib/f1-javaee-dao-0.0.1-SNAPSHOT.jar"),
                             new File("target/test-lib/f1-javaee-dao-hibernate-0.0.1-SNAPSHOT.jar"),
                             new File("target/test-lib/f1-javaee-domain-0.0.1-SNAPSHOT.jar"),
                             new File("target/test-lib/f1-javaee-ws-0.0.1-SNAPSHOT.jar"),
                             new File("target/test-lib/commons-io-2.0.1.jar"),
                             new File("target/test-lib/commons-lang3-3.0.1.jar"))
                         .addPackages(true, BaseEntity.class.getPackage(), Equipe.class.getPackage(),
                             F1RestDeployment.class.getPackage())
                         .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                         .addAsResource("import.sql").addAsWebInfResource("test-ds.xml").addAsWebInfResource("web.xml")
                         .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }
}
