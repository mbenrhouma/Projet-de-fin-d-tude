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
    @NamedQuery(name = "Groupe.findAll", query = "SELECT g FROM Groupe g")})
public class Groupe implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupe", fetch = FetchType.LAZY)
    private List<ClientAcquereur> clientAcquereurList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupe", fetch = FetchType.LAZY)
    private List<ClientLocataire> clientLocataireList;

    public Groupe() {
    }

    public Groupe(String code) {
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
    public List<ClientAcquereur> getClientAcquereurList() {
        return clientAcquereurList;
    }

    public void setClientAcquereurList(List<ClientAcquereur> clientAcquereurList) {
        this.clientAcquereurList = clientAcquereurList;
    }

    @XmlTransient
    public List<ClientLocataire> getClientLocataireList() {
        return clientLocataireList;
    }

    public void setClientLocataireList(List<ClientLocataire> clientLocataireList) {
        this.clientLocataireList = clientLocataireList;
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
        if (!(object instanceof Groupe)) {
            return false;
        }
        Groupe other = (Groupe) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.Groupe[ code=" + code + " ]";
    }
    
}
