/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynapsys.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UC057
 */
@Entity
@Table(name = "ANCIENNE_QUITTANCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AncienneQuittance.findAll", query = "SELECT a FROM AncienneQuittance a")})
public class AncienneQuittance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "NUM_QUITTANCE", nullable = false, length = 254)
    private String numQuittance;
    @Size(max = 254)
    @Column(length = 254)
    private String objet;
    @Size(max = 254)
    @Column(name = "MODE_REGLEMENT", length = 254)
    private String modeReglement;
    private BigInteger montant;
    @Column(name = "COMPTE_A_DEBITER")
    private BigInteger compteADebiter;
    @Column(name = "DATE_ENREGISTREMENT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnregistrement;
    @Column(name = "DATE_VALEUR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateValeur;
    @JoinColumn(name = "CLIENT_ACQUEREUR", referencedColumnName = "CODE_ACQUEREUR", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ClientAcquereur clientAcquereur;

    public AncienneQuittance() {
    }

    public AncienneQuittance(String numQuittance) {
        this.numQuittance = numQuittance;
    }

    public String getNumQuittance() {
        return numQuittance;
    }

    public void setNumQuittance(String numQuittance) {
        this.numQuittance = numQuittance;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getModeReglement() {
        return modeReglement;
    }

    public void setModeReglement(String modeReglement) {
        this.modeReglement = modeReglement;
    }

    public BigInteger getMontant() {
        return montant;
    }

    public void setMontant(BigInteger montant) {
        this.montant = montant;
    }

    public BigInteger getCompteADebiter() {
        return compteADebiter;
    }

    public void setCompteADebiter(BigInteger compteADebiter) {
        this.compteADebiter = compteADebiter;
    }

    public Date getDateEnregistrement() {
        return dateEnregistrement;
    }

    public void setDateEnregistrement(Date dateEnregistrement) {
        this.dateEnregistrement = dateEnregistrement;
    }

    public Date getDateValeur() {
        return dateValeur;
    }

    public void setDateValeur(Date dateValeur) {
        this.dateValeur = dateValeur;
    }

    public ClientAcquereur getClientAcquereur() {
        return clientAcquereur;
    }

    public void setClientAcquereur(ClientAcquereur clientAcquereur) {
        this.clientAcquereur = clientAcquereur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numQuittance != null ? numQuittance.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AncienneQuittance)) {
            return false;
        }
        AncienneQuittance other = (AncienneQuittance) object;
        if ((this.numQuittance == null && other.numQuittance != null) || (this.numQuittance != null && !this.numQuittance.equals(other.numQuittance))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.AncienneQuittance[ numQuittance=" + numQuittance + " ]";
    }
    
}
