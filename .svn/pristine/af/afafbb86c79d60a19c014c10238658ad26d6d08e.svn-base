/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynapsys.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
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
@Table(name = "CAT_RECETTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatRecette.findAll", query = "SELECT c FROM CatRecette c")})
public class CatRecette implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(nullable = false, length = 254)
    private String code;
    @Size(max = 254)
    @Column(name = "LIBELLE_FR", length = 254)
    private String libelleFr;
    @Size(max = 254)
    @Column(name = "LIBELLE_AR", length = 254)
    private String libelleAr;
    @Column(name = "DECOMPTE_VAL")
    private Integer decompteVal;
    @OneToMany(mappedBy = "catRecette", fetch = FetchType.LAZY)
    private List<Mouvement> mouvementList;

    public CatRecette() {
    }

    public CatRecette(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelleFr() {
        return libelleFr;
    }

    public void setLibelleFr(String libelleFr) {
        this.libelleFr = libelleFr;
    }

    public String getLibelleAr() {
        return libelleAr;
    }

    public void setLibelleAr(String libelleAr) {
        this.libelleAr = libelleAr;
    }

    public Integer getDecompteVal() {
        return decompteVal;
    }

    public void setDecompteVal(Integer decompteVal) {
        this.decompteVal = decompteVal;
    }

    @XmlTransient
    public List<Mouvement> getMouvementList() {
        return mouvementList;
    }

    public void setMouvementList(List<Mouvement> mouvementList) {
        this.mouvementList = mouvementList;
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
        if (!(object instanceof CatRecette)) {
            return false;
        }
        CatRecette other = (CatRecette) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.CatRecette[ code=" + code + " ]";
    }
    
}
