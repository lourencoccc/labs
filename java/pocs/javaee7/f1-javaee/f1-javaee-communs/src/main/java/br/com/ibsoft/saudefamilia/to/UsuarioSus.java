package br.com.ibsoft.saudefamilia.to;

import java.io.Serializable;
import java.util.Date;

import br.com.ibsoft.saudefamilia.enums.RacaCor;
import br.com.ibsoft.saudefamilia.enums.Sexo;

public class UsuarioSus implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String cns;
	private String nome;
	private Date dataNascimento;
	private Sexo sexo;
	private RacaCor racaCor;
	private String codigoMunicipioNascimento;
	private String nomeMae;
	private Date dataPreenchimento;
	private String cnsAgente;
	private Familia familia;

	public Long getId() {
		return id;
	}

	public String getCns() {
		return cns;
	}

	public String getNome() {
		return nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public RacaCor getRacaCor() {
		return racaCor;
	}

	public String getCodigoMunicipioNascimento() {
		return codigoMunicipioNascimento;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public Date getDataPreenchimento() {
		return dataPreenchimento;
	}

	public String getCnsAgente() {
		return cnsAgente;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCns(String cns) {
		this.cns = cns;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public void setRacaCor(RacaCor racaCor) {
		this.racaCor = racaCor;
	}

	public void setCodigoMunicipioNascimento(String codigoMunicipioNascimento) {
		this.codigoMunicipioNascimento = codigoMunicipioNascimento;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public void setDataPreenchimento(Date dataPreenchimento) {
		this.dataPreenchimento = dataPreenchimento;
	}

	public void setCnsAgente(String cnsAgente) {
		this.cnsAgente = cnsAgente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (cns == null ? 0 : cns.hashCode());
		result = prime * result + (id == null ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		UsuarioSus other = (UsuarioSus) obj;
		if (cns == null) {
			if (other.cns != null) {
				return false;
			}
		} else if (!cns.equals(other.cns)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}
