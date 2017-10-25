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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UC057
 */
@Entity
@SequenceGenerator(name="SEQ_ASSURANCE",sequenceName="S_ASSURANCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assurance.findAll", query = "SELECT a FROM Assurance a")})
public class Assurance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_ASSURANCE")
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TYPE_ASSURANCE", nullable = false)
    private Integer typeAssurance;
    private Integer montant;
    private Integer montant2;
    private Integer conjoint;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assurance", fetch = FetchType.LAZY)
    private List<Reclamation> reclamationList;
    @JoinColumn(name = "ASSUREUR", referencedColumnName = "CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Assureur assureur;
    @JoinColumn(name = "CLIENT_ACQUEREUR", referencedColumnName = "CODE_ACQUEREUR", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ClientAcquereur clientAcquereur;
    @JoinColumn(name = "DECES", referencedColumnName = "CODE_DECES")
    @ManyToOne(fetch = FetchType.LAZY)
    private Deces deces;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assurance", fetch = FetchType.LAZY)
    private List<Deces> decesList;

    public Assurance() {
    }

    public Assurance(Integer id) {
        this.id = id;
    }

    public Assurance(Integer id, Integer typeAssurance) {
        this.id = id;
        this.typeAssurance = typeAssurance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeAssurance() {
        return typeAssurance;
    }

    public void setTypeAssurance(Integer typeAssurance) {
        this.typeAssurance = typeAssurance;
    }

    public Integer getMontant() {
        return montant;
    }

    public void setMontant(Integer montant) {
        this.montant = montant;
    }

    public Integer getMontant2() {
        return montant2;
    }

    public void setMontant2(Integer montant2) {
        this.montant2 = montant2;
    }

    public Integer getConjoint() {
        return conjoint;
    }

    public void setConjoint(Integer conjoint) {
        this.conjoint = conjoint;
    }

    @XmlTransient
    public List<Reclamation> getReclamationList() {
        return reclamationList;
    }

    public void setReclamationList(List<Reclamation> reclamationList) {
        this.reclamationList = reclamationList;
    }

    public Assureur getAssureur() {
        return assureur;
    }

    public void setAssureur(Assureur assureur) {
        this.assureur = assureur;
    }

    public ClientAcquereur getClientAcquereur() {
        return clientAcquereur;
    }

    public void setClientAcquereur(ClientAcquereur clientAcquereur) {
        this.clientAcquereur = clientAcquereur;
    }

    public Deces getDeces() {
        return deces;
    }

    public void setDeces(Deces deces) {
        this.deces = deces;
    }

    @XmlTransient
    public List<Deces> getDecesList() {
        return decesList;
    }

    public void setDecesList(List<Deces> decesList) {
        this.decesList = decesList;
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
        if (!(object instanceof Assurance)) {
            return false;
        }
        Assurance other = (Assurance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.Assurance[ id=" + id + " ]";
    }
    
}
