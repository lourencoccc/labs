package com.faturista.integracao.po;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "concessionarias")
public class ConcessionariaEntity implements Serializable {

  @Id
  @GeneratedValue
  private Long id;
  private String nome;

  public ConcessionariaEntity() {
  }

  public ConcessionariaEntity(Long id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ConcessionariaEntity that = (ConcessionariaEntity) o;

    if (id != null ? !id.equals(that.id) : that.id != null) {
      return false;
    }
    return nome != null ? nome.equals(that.nome) : that.nome == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (nome != null ? nome.hashCode() : 0);
    return result;
  }
}
