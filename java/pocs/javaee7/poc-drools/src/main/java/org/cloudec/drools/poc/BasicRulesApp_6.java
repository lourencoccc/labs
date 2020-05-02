package org.cloudec.drools.poc;

import org.cloudec.drools.poc.model.Account;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class BasicRulesApp_6 {

	public static void main(String args[]) {

		// KieServices is the factory for all KIE services
		KieServices ks = KieServices.Factory.get();

		// From the kie services, a container is created from the classpath
		KieContainer kc = ks.getKieClasspathContainer();

		// From the container, a session is created based on
		// its definition and configuration in the META-INF/kmodule.xml file
		KieSession ksession = kc.newKieSession("AccountKS");
		
		try {
			Account account = new Account();
			account.setBalance(50l);
			ksession.insert(account);
			ksession.fireAllRules();
		} finally {
			ksession.dispose();
		}

	}
}
