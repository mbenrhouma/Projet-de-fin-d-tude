/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynapsys.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UC057
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parametrage.findAll", query = "SELECT p FROM Parametrage p")})
public class Parametrage implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PARAM_ID", nullable = false, precision = 22, scale = 0)
    private BigDecimal paramId;
    @Column(name = "DELAI_PRECONTENTTIEUX")
    private BigInteger delaiPrecontenttieux;
    @Column(name = "DELAI_PASSAGE_CONTENTIEUX")
    private BigInteger delaiPassageContentieux;

    public Parametrage() {
    }

    public Parametrage(BigDecimal paramId) {
        this.paramId = paramId;
    }

    public BigDecimal getParamId() {
        return paramId;
    }

    public void setParamId(BigDecimal paramId) {
        this.paramId = paramId;
    }

    public BigInteger getDelaiPrecontenttieux() {
        return delaiPrecontenttieux;
    }

    public void setDelaiPrecontenttieux(BigInteger delaiPrecontenttieux) {
        this.delaiPrecontenttieux = delaiPrecontenttieux;
    }

    public BigInteger getDelaiPassageContentieux() {
        return delaiPassageContentieux;
    }

    public void setDelaiPassageContentieux(BigInteger delaiPassageContentieux) {
        this.delaiPassageContentieux = delaiPassageContentieux;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paramId != null ? paramId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametrage)) {
            return false;
        }
        Parametrage other = (Parametrage) object;
        if ((this.paramId == null && other.paramId != null) || (this.paramId != null && !this.paramId.equals(other.paramId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.Parametrage[ paramId=" + paramId + " ]";
    }
    
}
