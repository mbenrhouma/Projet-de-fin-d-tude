/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynapsys.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UC057
 */
@Entity
@Table(name = "ECRITURE_COMPTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EcritureComptable.findAll", query = "SELECT e FROM EcritureComptable e")})
public class EcritureComptable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(nullable = false, length = 254)
    private String operation;
    private BigInteger compte;
    @Size(max = 254)
    @Column(length = 254)
    private String libelle;
    @Size(max = 254)
    @Column(name = "TYPE_OPERATION", length = 254)
    private String typeOperation;

    public EcritureComptable() {
    }

    public EcritureComptable(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public BigInteger getCompte() {
        return compte;
    }

    public void setCompte(BigInteger compte) {
        this.compte = compte;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (operation != null ? operation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EcritureComptable)) {
            return false;
        }
        EcritureComptable other = (EcritureComptable) object;
        if ((this.operation == null && other.operation != null) || (this.operation != null && !this.operation.equals(other.operation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.EcritureComptable[ operation=" + operation + " ]";
    }
    
}
