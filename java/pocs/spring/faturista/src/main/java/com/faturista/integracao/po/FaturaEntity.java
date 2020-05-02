package com.faturista.integracao.po;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "faturas")
public class FaturaEntity implements Serializable {

  @Id
  @GeneratedValue
  private Long id;

  @NotNull
  private Integer consumo;

  @Temporal(TemporalType.DATE)
  private Date vencimento;

  private BigDecimal valor;

  private String bandeira;

  private BigDecimal bandeiraFator;

  private BigDecimal bandeiraValor;

  @ManyToOne
  @JoinColumn(name = "clientes_id",
      foreignKey = @ForeignKey(name = "faturas_clientes_id_fk")
  )
  private ClienteEntity cliente;

  @ManyToOne
  @JoinColumn(name = "concessionarias_id",
      foreignKey = @ForeignKey(name = "faturas_concessionarias_id_fk")
  )
  private ConcessionariaEntity concessionaria;

  public FaturaEntity() {
  }

  public FaturaEntity(Date vencimento, BigDecimal valor, Integer consumo) {
    this.vencimento = vencimento;
    this.valor = valor;
    this.consumo = consumo;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getConsumo() {
    return consumo;
  }

  public void setConsumo(Integer consumo) {
    this.consumo = consumo;
  }

  public Date getVencimento() {
    return vencimento;
  }

  public void setVencimento(Date vencimento) {
    this.vencimento = vencimento;
  }

  public BigDecimal getValor() {
    return valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }

  public String getBandeira() {
    return bandeira;
  }

  public void setBandeira(String bandeira) {
    this.bandeira = bandeira;
  }

  public BigDecimal getBandeiraFator() {
    return bandeiraFator;
  }

  public void setBandeiraFator(BigDecimal bandeiraFator) {
    this.bandeiraFator = bandeiraFator;
  }

  public BigDecimal getBandeiraValor() {
    return bandeiraValor;
  }

  public void setBandeiraValor(BigDecimal bandeiraValor) {
    this.bandeiraValor = bandeiraValor;
  }

  public ClienteEntity getCliente() {
    return cliente;
  }

  public void setCliente(ClienteEntity cliente) {
    this.cliente = cliente;
  }

  public ConcessionariaEntity getConcessionaria() {
    return concessionaria;
  }

  public void setConcessionaria(ConcessionariaEntity concessionaria) {
    this.concessionaria = concessionaria;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    FaturaEntity that = (FaturaEntity) o;

    if (id != null ? !id.equals(that.id) : that.id != null) {
      return false;
    }
    if (consumo != null ? !consumo.equals(that.consumo) : that.consumo != null) {
      return false;
    }
    if (vencimento != null ? !vencimento.equals(that.vencimento) : that.vencimento != null) {
      return false;
    }
    return cliente != null ? cliente.equals(that.cliente) : that.cliente == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (consumo != null ? consumo.hashCode() : 0);
    result = 31 * result + (vencimento != null ? vencimento.hashCode() : 0);
    result = 31 * result + (cliente != null ? cliente.hashCode() : 0);
    return result;
  }
}
