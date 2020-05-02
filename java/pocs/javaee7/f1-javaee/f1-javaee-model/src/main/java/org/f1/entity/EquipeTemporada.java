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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(schema = "f1", name = "equipe_temporada")
@SequenceGenerator(schema = "f1", name = "equipe_temp_seq", sequenceName = "equipe_temp_seq")
@XmlRootElement
public class EquipeTemporada extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipe_temp_seq")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_equipe")
    private Equipe equipe;
    @OneToMany
    private List<PilotoTemporada> pilotos;
    @ManyToOne
    @JoinColumn(name = "id_temporada")
    private Temporada temporada;

    public EquipeTemporada() {
        super();
    }

    public EquipeTemporada(Long id, Equipe equipe, List<PilotoTemporada> pilotos, Temporada temporada) {
        super();
        this.id = id;
        this.equipe = equipe;
        this.pilotos = pilotos;
        this.temporada = temporada;
    }

    public Long getId() {
        return id;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public List<PilotoTemporada> getPilotos() {
        return pilotos;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public void setPilotos(List<PilotoTemporada> pilotos) {
        this.pilotos = pilotos;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (equipe == null ? 0 : equipe.hashCode());
        result = prime * result + (id == null ? 0 : id.hashCode());
        result = prime * result + (temporada == null ? 0 : temporada.hashCode());
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
        EquipeTemporada other = (EquipeTemporada) obj;
        if (equipe == null) {
            if (other.equipe != null) {
                return false;
            }
        } else if (!equipe.equals(other.equipe)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (temporada == null) {
            if (other.temporada != null) {
                return false;
            }
        } else if (!temporada.equals(other.temporada)) {
            return false;
        }
        return true;
    }

}
