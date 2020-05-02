/**
 * Copyright (c) 2014, Cloudec.
 * All rights reserved.
 */
package org.f1.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
@Entity
@Table(schema = "f1", name = "piloto")
@SequenceGenerator(schema = "f1", name = "piloto_seq", sequenceName = "piloto_seq")
@XmlRootElement
public class Piloto extends BaseEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "piloto_seq")
    private Long id;
    private String nome;
    private String licensa;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento")
    private Date dataNascimento;

    public Piloto() {
        super();
    }

    public Piloto(Long id, String nome) {
        super();
        this.id = id;
        this.nome = nome;
    }

    public Piloto(Long id, String nome, String licensa, Date dataNascimento) {
        super();
        this.id = id;
        this.nome = nome;
        this.licensa = licensa;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLicensa() {
        return licensa;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLicensa(String licensa) {
        this.licensa = licensa;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (id == null ? 0 : id.hashCode());
        result = prime * result + (licensa == null ? 0 : licensa.hashCode());
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
        Piloto other = (Piloto) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (licensa == null) {
            if (other.licensa != null) {
                return false;
            }
        } else if (!licensa.equals(other.licensa)) {
            return false;
        }
        return true;
    }

}
