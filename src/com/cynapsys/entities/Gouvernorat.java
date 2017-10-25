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
@SequenceGenerator(name="SEQ_GOUVERNORAT",sequenceName="S_GOUVERNORAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gouvernorat.findAll", query = "SELECT g FROM Gouvernorat g")})
public class Gouvernorat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_GOUVERNORAT")
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer code;
    @Size(max = 254)
    @Column(length = 254)
    private String libelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gouvernorat", fetch = FetchType.LAZY)
    private List<Logement> logementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gouvernorat", fetch = FetchType.LAZY)
    private List<Localite> localiteList;

    public Gouvernorat() {
    }

    public Gouvernorat(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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

    @XmlTransient
    public List<Localite> getLocaliteList() {
        return localiteList;
    }

    public void setLocaliteList(List<Localite> localiteList) {
        this.localiteList = localiteList;
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
        if (!(object instanceof Gouvernorat)) {
            return false;
        }
        Gouvernorat other = (Gouvernorat) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.Gouvernorat[ code=" + code + " ]";
    }
    
}
