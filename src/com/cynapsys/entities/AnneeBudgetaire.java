/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynapsys.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "ANNEE_BUDGETAIRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnneeBudgetaire.findAll", query = "SELECT a FROM AnneeBudgetaire a")})
public class AnneeBudgetaire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(nullable = false, length = 2)
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer annee;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anneeBudgetaire", fetch = FetchType.LAZY)
    private List<ClientAcquereur> clientAcquereurList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anneeBudgetaire", fetch = FetchType.LAZY)
    private List<ClientLocataire> clientLocataireList;

    public AnneeBudgetaire() {
    }

    public AnneeBudgetaire(String code) {
        this.code = code;
    }

    public AnneeBudgetaire(String code, Integer annee) {
        this.code = code;
        this.annee = annee;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
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
        if (!(object instanceof AnneeBudgetaire)) {
            return false;
        }
        AnneeBudgetaire other = (AnneeBudgetaire) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.AnneeBudgetaire[ code=" + code + " ]";
    }
    
}
