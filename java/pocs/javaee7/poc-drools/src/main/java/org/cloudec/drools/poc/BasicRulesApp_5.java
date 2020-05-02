package org.cloudec.drools.poc;

import org.cloudec.drools.poc.model.Account;
import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

public class BasicRulesApp_5 {

	public static void main(String args[]) {
		KnowledgeBase knowledgeBase = createKnowledgeBase();
		StatefulKnowledgeSession session = knowledgeBase
				.newStatefulKnowledgeSession();
		try {
			Account account = new Account();
			account.setBalance(50l);
			session.insert(account);
			session.fireAllRules();
		} finally {
			session.dispose();
		}

	}

	private static KnowledgeBase createKnowledgeBase() {
		KnowledgeBuilder builder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		builder.add(ResourceFactory.newClassPathResource("poc/basicRule.drl"),
				ResourceType.DRL);
		if (builder.hasErrors()) {
			throw new RuntimeException(builder.getErrors().toString());
		}
		KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
		knowledgeBase.addKnowledgePackages(builder.getKnowledgePackages());
		return knowledgeBase;
	}

}
