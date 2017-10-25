/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynapsys.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Quitance.findAll", query = "SELECT q FROM Quitance q")})
public class Quitance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "NUM_QUITTANCE", nullable = false, length = 254)
    private String numQuittance;
    @Column(name = "DATE_VERSEMENT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateVersement;
    private Integer montant;
    @Size(max = 254)
    @Column(name = "NOM_EMPLOYEUR", length = 254)
    private String nomEmployeur;
    @Column(name = "ETAT_QUITANCE")
    private Integer etatQuitance;
    @JoinColumn(name = "COMPTE_ATTENTE", referencedColumnName = "NUM_COMPTE", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CompteAttente compteAttente;
    @JoinColumn(name = "MOUVEMENT", referencedColumnName = "CODE_MV", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Mouvement mouvement;
    @OneToMany(mappedBy = "quitance", fetch = FetchType.LAZY)
    private List<Mouvement> mouvementList;

    public Quitance() {
    }

    public Quitance(String numQuittance) {
        this.numQuittance = numQuittance;
    }

    public String getNumQuittance() {
        return numQuittance;
    }

    public void setNumQuittance(String numQuittance) {
        this.numQuittance = numQuittance;
    }

    public Date getDateVersement() {
        return dateVersement;
    }

    public void setDateVersement(Date dateVersement) {
        this.dateVersement = dateVersement;
    }

    public Integer getMontant() {
        return montant;
    }

    public void setMontant(Integer montant) {
        this.montant = montant;
    }

    public String getNomEmployeur() {
        return nomEmployeur;
    }

    public void setNomEmployeur(String nomEmployeur) {
        this.nomEmployeur = nomEmployeur;
    }

    public Integer getEtatQuitance() {
        return etatQuitance;
    }

    public void setEtatQuitance(Integer etatQuitance) {
        this.etatQuitance = etatQuitance;
    }

    public CompteAttente getCompteAttente() {
        return compteAttente;
    }

    public void setCompteAttente(CompteAttente compteAttente) {
        this.compteAttente = compteAttente;
    }

    public Mouvement getMouvement() {
        return mouvement;
    }

    public void setMouvement(Mouvement mouvement) {
        this.mouvement = mouvement;
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
        hash += (numQuittance != null ? numQuittance.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quitance)) {
            return false;
        }
        Quitance other = (Quitance) object;
        if ((this.numQuittance == null && other.numQuittance != null) || (this.numQuittance != null && !this.numQuittance.equals(other.numQuittance))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.Quitance[ numQuittance=" + numQuittance + " ]";
    }
    
}
