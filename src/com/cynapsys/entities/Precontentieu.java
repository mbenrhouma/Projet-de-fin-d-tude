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
@SequenceGenerator(name="SEQ_PRECONTENTIEU",sequenceName="S_PRECONTENTIEU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Precontentieu.findAll", query = "SELECT p FROM Precontentieu p")})
public class Precontentieu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_PRECONTENTIEU")
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_RELANCE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRelance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_HUISSIER_NOTAIRE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHuissierNotaire;
    @Column(name = "DATE_EFFECTUATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEffectuation;
    @Column(name = "DATE_FACTURE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFacture;
    @Column(name = "DATE_TRANSMISSION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTransmission;
    @Column(name = "MONTANT_FACTURE")
    private BigInteger montantFacture;
    @OneToMany(mappedBy = "precontentieu", fetch = FetchType.LAZY)
    private List<Arrangement> arrangementList;
    @OneToMany(mappedBy = "precontentieu", fetch = FetchType.LAZY)
    private List<Impayee> impayeeList;
    @JoinColumn(name = "ARRANGEMENT", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Arrangement arrangement;
    @JoinColumn(name = "CONTENTIEUX", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Contentieux contentieux;
    @JoinColumn(name = "HUISSIERS_NOTAIRES", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private HuissiersNotaires huissiersNotaires;
    @JoinColumn(name = "IMPAYEE", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Impayee impayee;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "precontentieu", fetch = FetchType.LAZY)
    private List<Contentieux> contentieuxList;

    public Precontentieu() {
    }

    public Precontentieu(Integer id) {
        this.id = id;
    }

    public Precontentieu(Integer id, Date dateRelance, Date dateHuissierNotaire) {
        this.id = id;
        this.dateRelance = dateRelance;
        this.dateHuissierNotaire = dateHuissierNotaire;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateRelance() {
        return dateRelance;
    }

    public void setDateRelance(Date dateRelance) {
        this.dateRelance = dateRelance;
    }

    public Date getDateHuissierNotaire() {
        return dateHuissierNotaire;
    }

    public void setDateHuissierNotaire(Date dateHuissierNotaire) {
        this.dateHuissierNotaire = dateHuissierNotaire;
    }

    public Date getDateEffectuation() {
        return dateEffectuation;
    }

    public void setDateEffectuation(Date dateEffectuation) {
        this.dateEffectuation = dateEffectuation;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public Date getDateTransmission() {
        return dateTransmission;
    }

    public void setDateTransmission(Date dateTransmission) {
        this.dateTransmission = dateTransmission;
    }

    public BigInteger getMontantFacture() {
        return montantFacture;
    }

    public void setMontantFacture(BigInteger montantFacture) {
        this.montantFacture = montantFacture;
    }

    @XmlTransient
    public List<Arrangement> getArrangementList() {
        return arrangementList;
    }

    public void setArrangementList(List<Arrangement> arrangementList) {
        this.arrangementList = arrangementList;
    }

    @XmlTransient
    public List<Impayee> getImpayeeList() {
        return impayeeList;
    }

    public void setImpayeeList(List<Impayee> impayeeList) {
        this.impayeeList = impayeeList;
    }

    public Arrangement getArrangement() {
        return arrangement;
    }

    public void setArrangement(Arrangement arrangement) {
        this.arrangement = arrangement;
    }

    public Contentieux getContentieux() {
        return contentieux;
    }

    public void setContentieux(Contentieux contentieux) {
        this.contentieux = contentieux;
    }

    public HuissiersNotaires getHuissiersNotaires() {
        return huissiersNotaires;
    }

    public void setHuissiersNotaires(HuissiersNotaires huissiersNotaires) {
        this.huissiersNotaires = huissiersNotaires;
    }

    public Impayee getImpayee() {
        return impayee;
    }

    public void setImpayee(Impayee impayee) {
        this.impayee = impayee;
    }

    @XmlTransient
    public List<Contentieux> getContentieuxList() {
        return contentieuxList;
    }

    public void setContentieuxList(List<Contentieux> contentieuxList) {
        this.contentieuxList = contentieuxList;
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
        if (!(object instanceof Precontentieu)) {
            return false;
        }
        Precontentieu other = (Precontentieu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.Precontentieu[ id=" + id + " ]";
    }
    
}
