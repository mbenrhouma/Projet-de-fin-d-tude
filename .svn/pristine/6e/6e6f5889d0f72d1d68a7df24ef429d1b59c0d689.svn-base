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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UC057
 */
@Entity
@SequenceGenerator(name="SEQ_CELLULE",sequenceName="S_CELLULE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cellule.findAll", query = "SELECT c FROM Cellule c")})
public class Cellule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_CELLULE")
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer code;
    @Size(max = 254)
    @Column(name = "LIBILLE_FR", length = 254)
    private String libilleFr;
    @Size(max = 254)
    @Column(name = "LIBILLE_AR", length = 254)
    private String libilleAr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cellule", fetch = FetchType.LAZY)
    private List<Utilisateur> utilisateurList;

    public Cellule() {
    }

    public Cellule(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getLibilleFr() {
        return libilleFr;
    }

    public void setLibilleFr(String libilleFr) {
        this.libilleFr = libilleFr;
    }

    public String getLibilleAr() {
        return libilleAr;
    }

    public void setLibilleAr(String libilleAr) {
        this.libilleAr = libilleAr;
    }

    @XmlTransient
    public List<Utilisateur> getUtilisateurList() {
        return utilisateurList;
    }

    public void setUtilisateurList(List<Utilisateur> utilisateurList) {
        this.utilisateurList = utilisateurList;
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
        if (!(object instanceof Cellule)) {
            return false;
        }
        Cellule other = (Cellule) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.Cellule[ code=" + code + " ]";
    }
    
}
