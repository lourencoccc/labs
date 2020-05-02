/**
 * Copyright (c) 2014, Cloudec.
 * All rights reserved.
 */
package org.f1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(schema = "f1", name = "piloto_temporada")
@SequenceGenerator(schema = "f1", name = "piloto_temp_seq", sequenceName = "piloto_temp_seq")
@XmlRootElement
public class PilotoTemporada extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "piloto_temp_seq")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_piloto")
    private Piloto piloto;
    @ManyToOne
    @JoinColumn(name = "id_equipe_temporada")
    private EquipeTemporada equipe;

    public PilotoTemporada() {
        super();
    }

    public PilotoTemporada(Long id, Piloto piloto, EquipeTemporada equipe) {
        super();
        this.id = id;
        this.piloto = piloto;
        this.equipe = equipe;
    }

    public Long getId() {
        return id;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public EquipeTemporada getEquipe() {
        return equipe;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public void setEquipe(EquipeTemporada equipe) {
        this.equipe = equipe;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (equipe == null ? 0 : equipe.hashCode());
        result = prime * result + (id == null ? 0 : id.hashCode());
        result = prime * result + (piloto == null ? 0 : piloto.hashCode());
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
        PilotoTemporada other = (PilotoTemporada) obj;
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
        if (piloto == null) {
            if (other.piloto != null) {
                return false;
            }
        } else if (!piloto.equals(other.piloto)) {
            return false;
        }
        return true;
    }

}
