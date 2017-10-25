/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynapsys.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
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
@SequenceGenerator(name="SEQ_TRACABILITE",sequenceName="S_TRACABILITE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tracabilite.findAll", query = "SELECT t FROM Tracabilite t")})
public class Tracabilite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_TRACABILITE")
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
    @Column(name = "DATE_SAISIE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSaisie;
    @Size(max = 254)
    @Column(name = "ANCIEN_VALEUR", length = 254)
    private String ancienValeur;
    @Size(max = 254)
    @Column(name = "NOUVELLE_VALEUR", length = 254)
    private String nouvelleValeur;
    @JoinColumn(name = "COLONNE", referencedColumnName = "CODE", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Colonne colonne;
    @JoinColumn(name = "TABLES", referencedColumnName = "CODE", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tables tables;
    @JoinColumn(name = "UTILISATEUR", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Utilisateur utilisateur;

    public Tracabilite() {
    }

    public Tracabilite(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateSaisie() {
        return dateSaisie;
    }

    public void setDateSaisie(Date dateSaisie) {
        this.dateSaisie = dateSaisie;
    }

    public String getAncienValeur() {
        return ancienValeur;
    }

    public void setAncienValeur(String ancienValeur) {
        this.ancienValeur = ancienValeur;
    }

    public String getNouvelleValeur() {
        return nouvelleValeur;
    }

    public void setNouvelleValeur(String nouvelleValeur) {
        this.nouvelleValeur = nouvelleValeur;
    }

    public Colonne getColonne() {
        return colonne;
    }

    public void setColonne(Colonne colonne) {
        this.colonne = colonne;
    }

    public Tables getTables() {
        return tables;
    }

    public void setTables(Tables tables) {
        this.tables = tables;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
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
        if (!(object instanceof Tracabilite)) {
            return false;
        }
        Tracabilite other = (Tracabilite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.Tracabilite[ id=" + id + " ]";
    }
    
}
