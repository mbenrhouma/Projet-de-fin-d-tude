/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynapsys.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UC057
 */
@Entity
@Table(name = "TYPE_LOGEMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeLogement.findAll", query = "SELECT t FROM TypeLogement t")})
public class TypeLogement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "CODE_TYPE", nullable = false, length = 254)
    private String codeType;
    @Size(max = 254)
    @Column(length = 254)
    private String libelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeLogement", fetch = FetchType.LAZY)
    private List<Logement> logementList;

    public TypeLogement() {
    }

    public TypeLogement(String codeType) {
        this.codeType = codeType;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @XmlTransient
    public List<Logement> getLogementList() {
        return logementList;
    }

    public void setLogementList(List<Logement> logementList) {
        this.logementList = logementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeType != null ? codeType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeLogement)) {
            return false;
        }
        TypeLogement other = (TypeLogement) object;
        if ((this.codeType == null && other.codeType != null) || (this.codeType != null && !this.codeType.equals(other.codeType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.TypeLogement[ codeType=" + codeType + " ]";
    }
    
}
