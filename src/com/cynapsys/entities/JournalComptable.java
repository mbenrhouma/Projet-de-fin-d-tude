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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
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
@Table(name = "JOURNAL_COMPTABLE")
@SequenceGenerator(name="SEQ_JOURNAL_COMPTABLE",sequenceName="S_JOURNAL_COMPTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JournalComptable.findAll", query = "SELECT j FROM JournalComptable j")})
public class JournalComptable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_JOURNAL_COMPTABLE")
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
    private BigInteger ecriture;
    @Size(max = 254)
    @Column(length = 254)
    private String operation;
    private BigInteger compte;
    @Size(max = 254)
    @Column(length = 254)
    private String libelle;
    @Column(name = "MONTANT_DEBIT")
    private BigInteger montantDebit;
    @Column(name = "MONTANT_CREDIT")
    private BigInteger montantCredit;
    @Column(name = "DATE_OPERATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOperation;
    @Column(name = "CODE_CLIENT")
    private BigInteger codeClient;
    @Size(max = 254)
    @Column(name = "NOM_PRENOM_CLIENTV", length = 254)
    private String nomPrenomClientv;
    @Size(max = 254)
    @Column(length = 254)
    private String transfere;

    public JournalComptable() {
    }

    public JournalComptable(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getEcriture() {
        return ecriture;
    }

    public void setEcriture(BigInteger ecriture) {
        this.ecriture = ecriture;
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

    public BigInteger getMontantDebit() {
        return montantDebit;
    }

    public void setMontantDebit(BigInteger montantDebit) {
        this.montantDebit = montantDebit;
    }

    public BigInteger getMontantCredit() {
        return montantCredit;
    }

    public void setMontantCredit(BigInteger montantCredit) {
        this.montantCredit = montantCredit;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public BigInteger getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(BigInteger codeClient) {
        this.codeClient = codeClient;
    }

    public String getNomPrenomClientv() {
        return nomPrenomClientv;
    }

    public void setNomPrenomClientv(String nomPrenomClientv) {
        this.nomPrenomClientv = nomPrenomClientv;
    }

    public String getTransfere() {
        return transfere;
    }

    public void setTransfere(String transfere) {
        this.transfere = transfere;
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
        if (!(object instanceof JournalComptable)) {
            return false;
        }
        JournalComptable other = (JournalComptable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.JournalComptable[ id=" + id + " ]";
    }
    
}
