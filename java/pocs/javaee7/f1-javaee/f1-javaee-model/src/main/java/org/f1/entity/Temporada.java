/**
 * Copyright (c) 2014, Cloudec.
 * All rights reserved.
 */
package org.f1.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
@Entity
@Table(schema = "f1", name = "temporada")
@SequenceGenerator(schema = "f1", name = "temporada_seq", sequenceName = "temporada_seq")
@XmlRootElement
public class Temporada extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "temporada_seq")
    private Long id;
    private Integer ano;
    @OneToMany
    private List<EquipeTemporada> equipes;

    public Temporada() {
        super();
    }

    public Long getId() {
        return id;
    }

    public Integer getAno() {
        return ano;
    }

    public List<EquipeTemporada> getEquipes() {
        return equipes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public void setEquipes(List<EquipeTemporada> equipes) {
        this.equipes = equipes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (ano == null ? 0 : ano.hashCode());
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
        Temporada other = (Temporada) obj;
        if (ano == null) {
            if (other.ano != null) {
                return false;
            }
        } else if (!ano.equals(other.ano)) {
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
