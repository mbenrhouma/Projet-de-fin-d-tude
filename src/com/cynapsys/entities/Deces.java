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
@SequenceGenerator(name="SEQ_DECES",sequenceName="S_DECES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deces.findAll", query = "SELECT d FROM Deces d")})
public class Deces implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_DECES")
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODE_DECES", nullable = false)
    private Integer codeDeces;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_DECES", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeces;
    @Column(name = "CAPITALE_ASSURE")
    private BigInteger capitaleAssure;
    @Column(name = "CAPITALE_REMBOURSE")
    private BigInteger capitaleRembourse;
    @Column(name = "DATE_REMBOURSEMENT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRemboursement;
    @OneToMany(mappedBy = "deces", fetch = FetchType.LAZY)
    private List<ClientAcquereur> clientAcquereurList;
    @OneToMany(mappedBy = "deces", fetch = FetchType.LAZY)
    private List<Assurance> assuranceList;
    @JoinColumn(name = "ASSURANCE", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Assurance assurance;
    @JoinColumn(name = "CLIENT_ACQUEREUR", referencedColumnName = "CODE_ACQUEREUR", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ClientAcquereur clientAcquereur;

    public Deces() {
    }

    public Deces(Integer codeDeces) {
        this.codeDeces = codeDeces;
    }

    public Deces(Integer codeDeces, Date dateDeces) {
        this.codeDeces = codeDeces;
        this.dateDeces = dateDeces;
    }

    public Integer getCodeDeces() {
        return codeDeces;
    }

    public void setCodeDeces(Integer codeDeces) {
        this.codeDeces = codeDeces;
    }

    public Date getDateDeces() {
        return dateDeces;
    }

    public void setDateDeces(Date dateDeces) {
        this.dateDeces = dateDeces;
    }

    public BigInteger getCapitaleAssure() {
        return capitaleAssure;
    }

    public void setCapitaleAssure(BigInteger capitaleAssure) {
        this.capitaleAssure = capitaleAssure;
    }

    public BigInteger getCapitaleRembourse() {
        return capitaleRembourse;
    }

    public void setCapitaleRembourse(BigInteger capitaleRembourse) {
        this.capitaleRembourse = capitaleRembourse;
    }

    public Date getDateRemboursement() {
        return dateRemboursement;
    }

    public void setDateRemboursement(Date dateRemboursement) {
        this.dateRemboursement = dateRemboursement;
    }

    @XmlTransient
    public List<ClientAcquereur> getClientAcquereurList() {
        return clientAcquereurList;
    }

    public void setClientAcquereurList(List<ClientAcquereur> clientAcquereurList) {
        this.clientAcquereurList = clientAcquereurList;
    }

    @XmlTransient
    public List<Assurance> getAssuranceList() {
        return assuranceList;
    }

    public void setAssuranceList(List<Assurance> assuranceList) {
        this.assuranceList = assuranceList;
    }

    public Assurance getAssurance() {
        return assurance;
    }

    public void setAssurance(Assurance assurance) {
        this.assurance = assurance;
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
        hash += (codeDeces != null ? codeDeces.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deces)) {
            return false;
        }
        Deces other = (Deces) object;
        if ((this.codeDeces == null && other.codeDeces != null) || (this.codeDeces != null && !this.codeDeces.equals(other.codeDeces))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.Deces[ codeDeces=" + codeDeces + " ]";
    }
    
}
