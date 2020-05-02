package br.com.ibsoft.saudefamilia.enums;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public enum Sexo {

	M("Masculino"), F("Feminino");

	private String nome;

	private Sexo(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
