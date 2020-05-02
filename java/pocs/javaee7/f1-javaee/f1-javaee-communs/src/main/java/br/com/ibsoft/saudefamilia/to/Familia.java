package br.com.ibsoft.saudefamilia.to;

import java.io.Serializable;

public class Familia implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String codigo;
	private String nome;
	private MicroArea microArea;
	private String latittude;
	private String longitude;
	private byte[] imagem;

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
