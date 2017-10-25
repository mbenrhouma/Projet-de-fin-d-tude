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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UC057
 */
@Entity
@SequenceGenerator(name="SEQ_CONTENTIEUX",sequenceName="S_CONTENTIEUX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contentieux.findAll", query = "SELECT c FROM Contentieux c")})
public class Contentieux implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_CONTENTIEUX")
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "NUM_DOSSIER", nullable = false, length = 254)
    private String numDossier;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_TRANSMISSION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTransmission;
    @Column(name = "DATE_RELANCE_CONTENTIEUX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRelanceContentieux;
    @Column(name = "DATE_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedebarrex;
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedebfinex;
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedebarrprste;
    @Temporal(TemporalType.TIMESTAMP)
    private Date datefinarrprste;
    @Size(max = 254)
    @Column(length = 254)
    private String etatcontentieux;
    @OneToMany(mappedBy = "contentieux", fetch = FetchType.LAZY)
    private List<Arrangement> arrangementList;
    @OneToMany(mappedBy = "contentieux", fetch = FetchType.LAZY)
    private List<Precontentieu> precontentieuList;
    @JoinColumn(name = "ARRANGEMENT", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Arrangement arrangement;
    @JoinColumn(name = "PRECONTENTIEU", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Precontentieu precontentieu;

    public Contentieux() {
    }

    public Contentieux(Integer id) {
        this.id = id;
    }

    public Contentieux(Integer id, String numDossier, Date dateTransmission) {
        this.id = id;
        this.numDossier = numDossier;
        this.dateTransmission = dateTransmission;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumDossier() {
        return numDossier;
    }

    public void setNumDossier(String numDossier) {
        this.numDossier = numDossier;
    }

    public Date getDateTransmission() {
        return dateTransmission;
    }

    public void setDateTransmission(Date dateTransmission) {
        this.dateTransmission = dateTransmission;
    }

    public Date getDateRelanceContentieux() {
        return dateRelanceContentieux;
    }

    public void setDateRelanceContentieux(Date dateRelanceContentieux) {
        this.dateRelanceContentieux = dateRelanceContentieux;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Date getDatedebarrex() {
        return datedebarrex;
    }

    public void setDatedebarrex(Date datedebarrex) {
        this.datedebarrex = datedebarrex;
    }

    public Date getDatedebfinex() {
        return datedebfinex;
    }

    public void setDatedebfinex(Date datedebfinex) {
        this.datedebfinex = datedebfinex;
    }

    public Date getDatedebarrprste() {
        return datedebarrprste;
    }

    public void setDatedebarrprste(Date datedebarrprste) {
        this.datedebarrprste = datedebarrprste;
    }

    public Date getDatefinarrprste() {
        return datefinarrprste;
    }

    public void setDatefinarrprste(Date datefinarrprste) {
        this.datefinarrprste = datefinarrprste;
    }

    public String getEtatcontentieux() {
        return etatcontentieux;
    }

    public void setEtatcontentieux(String etatcontentieux) {
        this.etatcontentieux = etatcontentieux;
    }

    @XmlTransient
    public List<Arrangement> getArrangementList() {
        return arrangementList;
    }

    public void setArrangementList(List<Arrangement> arrangementList) {
        this.arrangementList = arrangementList;
    }

    @XmlTransient
    public List<Precontentieu> getPrecontentieuList() {
        return precontentieuList;
    }

    public void setPrecontentieuList(List<Precontentieu> precontentieuList) {
        this.precontentieuList = precontentieuList;
    }

    public Arrangement getArrangement() {
        return arrangement;
    }

    public void setArrangement(Arrangement arrangement) {
        this.arrangement = arrangement;
    }

    public Precontentieu getPrecontentieu() {
        return precontentieu;
    }

    public void setPrecontentieu(Precontentieu precontentieu) {
        this.precontentieu = precontentieu;
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
        if (!(object instanceof Contentieux)) {
            return false;
        }
        Contentieux other = (Contentieux) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.Contentieux[ id=" + id + " ]";
    }
    
}
