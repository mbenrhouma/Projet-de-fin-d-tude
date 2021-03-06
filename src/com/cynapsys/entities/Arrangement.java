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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UC057
 */
@Entity
@SequenceGenerator(name="SEQ_ARRANGEMENT",sequenceName="S_ARRANGEMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arrangement.findAll", query = "SELECT a FROM Arrangement a")})
public class Arrangement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_ARRANGEMENT")
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer duree;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_DEBUT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_FIN", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOMBRE_MENSUALITE", nullable = false)
    private Integer nombreMensualite;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTANT_ARRIERES", nullable = false)
    private Integer montantArrieres;
    @JoinColumn(name = "CONTENTIEUX", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Contentieux contentieux;
    @JoinColumn(name = "PRECONTENTIEU", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Precontentieu precontentieu;
    @OneToMany(mappedBy = "arrangement", fetch = FetchType.LAZY)
    private List<Precontentieu> precontentieuList;
    @OneToMany(mappedBy = "arrangement", fetch = FetchType.LAZY)
    private List<Contentieux> contentieuxList;

    public Arrangement() {
    }

    public Arrangement(Integer id) {
        this.id = id;
    }

    public Arrangement(Integer id, Integer duree, Date dateDebut, Date dateFin, Integer nombreMensualite, Integer montantArrieres) {
        this.id = id;
        this.duree = duree;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nombreMensualite = nombreMensualite;
        this.montantArrieres = montantArrieres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getNombreMensualite() {
        return nombreMensualite;
    }

    public void setNombreMensualite(Integer nombreMensualite) {
        this.nombreMensualite = nombreMensualite;
    }

    public Integer getMontantArrieres() {
        return montantArrieres;
    }

    public void setMontantArrieres(Integer montantArrieres) {
        this.montantArrieres = montantArrieres;
    }

    public Contentieux getContentieux() {
        return contentieux;
    }

    public void setContentieux(Contentieux contentieux) {
        this.contentieux = contentieux;
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
        if (!(object instanceof Arrangement)) {
            return false;
        }
        Arrangement other = (Arrangement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.Arrangement[ id=" + id + " ]";
    }
    
}
