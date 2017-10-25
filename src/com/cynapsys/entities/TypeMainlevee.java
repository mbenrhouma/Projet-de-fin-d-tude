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
@Table(name = "TYPE_MAINLEVEE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeMainlevee.findAll", query = "SELECT t FROM TypeMainlevee t")})
public class TypeMainlevee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String id;
    @Size(max = 50)
    @Column(name = "LIBELLE_FR", length = 50)
    private String libelleFr;
    @Size(max = 50)
    @Column(name = "LIBELLE_AR", length = 50)
    private String libelleAr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeMainlevee", fetch = FetchType.LAZY)
    private List<Mainlevee> mainleveeList;

    public TypeMainlevee() {
    }

    public TypeMainlevee(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @XmlTransient
    public List<Mainlevee> getMainleveeList() {
        return mainleveeList;
    }

    public void setMainleveeList(List<Mainlevee> mainleveeList) {
        this.mainleveeList = mainleveeList;
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
        if (!(object instanceof TypeMainlevee)) {
            return false;
        }
        TypeMainlevee other = (TypeMainlevee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.TypeMainlevee[ id=" + id + " ]";
    }
    
}
