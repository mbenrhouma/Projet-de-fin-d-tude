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
@Table(name = "COMPTE_ATTENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompteAttente.findAll", query = "SELECT c FROM CompteAttente c")})
public class CompteAttente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "NUM_COMPTE", nullable = false, length = 254)
    private String numCompte;
    private Integer solde;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compteAttente", fetch = FetchType.LAZY)
    private List<Quitance> quitanceList;

    public CompteAttente() {
    }

    public CompteAttente(String numCompte) {
        this.numCompte = numCompte;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public Integer getSolde() {
        return solde;
    }

    public void setSolde(Integer solde) {
        this.solde = solde;
    }

    @XmlTransient
    public List<Quitance> getQuitanceList() {
        return quitanceList;
    }

    public void setQuitanceList(List<Quitance> quitanceList) {
        this.quitanceList = quitanceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numCompte != null ? numCompte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompteAttente)) {
            return false;
        }
        CompteAttente other = (CompteAttente) object;
        if ((this.numCompte == null && other.numCompte != null) || (this.numCompte != null && !this.numCompte.equals(other.numCompte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.CompteAttente[ numCompte=" + numCompte + " ]";
    }
    
}
