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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UC057
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tables.findAll", query = "SELECT t FROM Tables t")})
public class Tables implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(nullable = false, length = 254)
    private String code;
    @Size(max = 254)
    @Column(length = 254)
    private String libelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tables", fetch = FetchType.LAZY)
    private List<Tracabilite> tracabiliteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tables", fetch = FetchType.LAZY)
    private List<Colonne> colonneList;

    public Tables() {
    }

    public Tables(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @XmlTransient
    public List<Tracabilite> getTracabiliteList() {
        return tracabiliteList;
    }

    public void setTracabiliteList(List<Tracabilite> tracabiliteList) {
        this.tracabiliteList = tracabiliteList;
    }

    @XmlTransient
    public List<Colonne> getColonneList() {
        return colonneList;
    }

    public void setColonneList(List<Colonne> colonneList) {
        this.colonneList = colonneList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tables)) {
            return false;
        }
        Tables other = (Tables) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.Tables[ code=" + code + " ]";
    }
    
}
