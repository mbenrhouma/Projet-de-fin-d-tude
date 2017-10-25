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
import javax.persistence.Table;
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
@Table(name = "QUITANCE_EMPLOYEUR")
@SequenceGenerator(name="SEQ_QUITANCE_EMPLOYEUR",sequenceName="S_QUITANCE_EMPLOYEUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuitanceEmployeur.findAll", query = "SELECT q FROM QuitanceEmployeur q")})
public class QuitanceEmployeur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_QUITANCE_EMPLOYEUR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_QUITTANCE", nullable = false)
    private Integer numQuittance;
    @Column(name = "MONTANT_ENC")
    private Integer montantEnc;
    @Column(name = "MONTANT_IMPAYEE")
    private Integer montantImpayee;
    @Column(name = "DATE_DEB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeb;
    @Column(name = "DATE_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    private Integer duree;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quitanceEmployeur", fetch = FetchType.LAZY)
    private List<DetailQuiEmp> detailQuiEmpList;
    @JoinColumn(name = "EMPLOYEUR", referencedColumnName = "CODE_EMPLOYEUR", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employeur employeur;

    public QuitanceEmployeur() {
    }

    public QuitanceEmployeur(Integer numQuittance) {
        this.numQuittance = numQuittance;
    }

    public Integer getNumQuittance() {
        return numQuittance;
    }

    public void setNumQuittance(Integer numQuittance) {
        this.numQuittance = numQuittance;
    }

    public Integer getMontantEnc() {
        return montantEnc;
    }

    public void setMontantEnc(Integer montantEnc) {
        this.montantEnc = montantEnc;
    }

    public Integer getMontantImpayee() {
        return montantImpayee;
    }

    public void setMontantImpayee(Integer montantImpayee) {
        this.montantImpayee = montantImpayee;
    }

    public Date getDateDeb() {
        return dateDeb;
    }

    public void setDateDeb(Date dateDeb) {
        this.dateDeb = dateDeb;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    @XmlTransient
    public List<DetailQuiEmp> getDetailQuiEmpList() {
        return detailQuiEmpList;
    }

    public void setDetailQuiEmpList(List<DetailQuiEmp> detailQuiEmpList) {
        this.detailQuiEmpList = detailQuiEmpList;
    }

    public Employeur getEmployeur() {
        return employeur;
    }

    public void setEmployeur(Employeur employeur) {
        this.employeur = employeur;
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
        if (!(object instanceof QuitanceEmployeur)) {
            return false;
        }
        QuitanceEmployeur other = (QuitanceEmployeur) object;
        if ((this.numQuittance == null && other.numQuittance != null) || (this.numQuittance != null && !this.numQuittance.equals(other.numQuittance))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.QuitanceEmployeur[ numQuittance=" + numQuittance + " ]";
    }
    
}
