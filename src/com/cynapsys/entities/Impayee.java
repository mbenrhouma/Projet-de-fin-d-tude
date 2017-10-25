/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynapsys.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UC057
 */
@Entity
@SequenceGenerator(name="SEQ_IMPAYEE",sequenceName="S_IMPAYEE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Impayee.findAll", query = "SELECT i FROM Impayee i")})
public class Impayee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_IMPAYEE")
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOLDE_DEBITEUR", nullable = false)
    private Integer soldeDebiteur;
    @Column(name = "DATE_RELANCE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRelance;
    @JoinColumn(name = "CLIENT_ACQUEREUR", referencedColumnName = "CODE_ACQUEREUR")
    @ManyToOne(fetch = FetchType.LAZY)
    private ClientAcquereur clientAcquereur;
    @JoinColumn(name = "PRECONTENTIEU", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Precontentieu precontentieu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "impayee", fetch = FetchType.LAZY)
    private List<Precontentieu> precontentieuList;

    public Impayee() {
    }

    public Impayee(Integer id) {
        this.id = id;
    }

    public Impayee(Integer id, Integer soldeDebiteur) {
        this.id = id;
        this.soldeDebiteur = soldeDebiteur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSoldeDebiteur() {
        return soldeDebiteur;
    }

    public void setSoldeDebiteur(Integer soldeDebiteur) {
        this.soldeDebiteur = soldeDebiteur;
    }

    public Date getDateRelance() {
        return dateRelance;
    }

    public void setDateRelance(Date dateRelance) {
        this.dateRelance = dateRelance;
    }

    public ClientAcquereur getClientAcquereur() {
        return clientAcquereur;
    }

    public void setClientAcquereur(ClientAcquereur clientAcquereur) {
        this.clientAcquereur = clientAcquereur;
    }

    public Precontentieu getPrecontentieu() {
        return precontentieu;
    }

    public void setPrecontentieu(Precontentieu precontentieu) {
        this.precontentieu = precontentieu;
    }

    @XmlTransient
    public List<Precontentieu> getPrecontentieuList() {
        return precontentieuList;
    }

    public void setPrecontentieuList(List<Precontentieu> precontentieuList) {
        this.precontentieuList = precontentieuList;
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
        if (!(object instanceof Impayee)) {
            return false;
        }
        Impayee other = (Impayee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.Impayee[ id=" + id + " ]";
    }
    
}