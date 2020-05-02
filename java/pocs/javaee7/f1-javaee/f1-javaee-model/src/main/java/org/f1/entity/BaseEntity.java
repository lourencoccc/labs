/**
 * Copyright (c) 2014, Cloudec.
 * All rights reserved.
 */
package org.f1.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date dtAtualizacao;
    private Date dtInsercao;

    @Column(name = "dt_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDtAtualizacao() {
        return dtAtualizacao;
    }

    @Column(name = "dt_insercao")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDtInsercao() {
        return dtInsercao;
    }

    public void setDtAtualizacao(Date dtAtualizacao) {
        this.dtAtualizacao = dtAtualizacao;
    }

    public void setDtInsercao(Date dtInsercao) {
        this.dtInsercao = dtInsercao;
    }

    @PrePersist
    public void prePersist() {
        this.dtInsercao = Calendar.getInstance().getTime();
    }

    @PreUpdate
    public void preUpdate() {
        this.dtAtualizacao = Calendar.getInstance().getTime();
    }

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);

}
