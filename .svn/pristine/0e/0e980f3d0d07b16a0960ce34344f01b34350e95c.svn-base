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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UC057
 */
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CODE_POSTAL", "CODE"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localite.findAll", query = "SELECT l FROM Localite l")})
public class Localite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(nullable = false, length = 3)
    private String code;
    @Size(max = 254)
    @Column(name = "LIBELLE_FR", length = 254)
    private String libelleFr;
    @Size(max = 254)
    @Column(name = "LIBELLE_AR", length = 254)
    private String libelleAr;
    @Size(max = 254)
    @Column(name = "CODE_POSTAL", length = 254)
    private String codePostal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localite", fetch = FetchType.LAZY)
    private List<Logement> logementList;
    @JoinColumn(name = "GOUVERNORAT", referencedColumnName = "CODE", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Gouvernorat gouvernorat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localite", fetch = FetchType.LAZY)
    private List<Lotissement> lotissementList;

    public Localite() {
    }

    public Localite(Integer id) {
        this.id = id;
    }

    public Localite(Integer id, String code) {
        this.id = id;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    @XmlTransient
    public List<Logement> getLogementList() {
        return logementList;
    }

    public void setLogementList(List<Logement> logementList) {
        this.logementList = logementList;
    }

    public Gouvernorat getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(Gouvernorat gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    @XmlTransient
    public List<Lotissement> getLotissementList() {
        return lotissementList;
    }

    public void setLotissementList(List<Lotissement> lotissementList) {
        this.lotissementList = lotissementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localite)) {
            return false;
        }
        Localite other = (Localite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.Localite[ id=" + id + " ]";
    }
    
}
