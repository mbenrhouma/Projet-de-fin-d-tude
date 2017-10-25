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
@Table(name = "TABLEAU_AMORTISSEMENT")
@SequenceGenerator(name="SEQ_TABLEAU_AMORTISSEMENT",sequenceName="S_TABLEAU_AMORTISSEMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableauAmortissement.findAll", query = "SELECT t FROM TableauAmortissement t")})
public class TableauAmortissement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_TABLEAU_AMORTISSEMENT")
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_EFFET", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEffet;
    private Integer duree;
    @Column(name = "TAX_ASSURANCE")
    private Integer taxAssurance;
    @Column(name = "ASSURANCE_ANNUELLE")
    private Integer assuranceAnnuelle;
    private Integer etat;
    @Column(name = "DATE_ANNULATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAnnulation;
    @JoinColumn(name = "CLIENT_ACQUEREUR", referencedColumnName = "CODE_ACQUEREUR", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ClientAcquereur clientAcquereur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tableauAmortissement", fetch = FetchType.LAZY)
    private List<Mensualite> mensualiteList;

    public TableauAmortissement() {
    }

    public TableauAmortissement(Integer id) {
        this.id = id;
    }

    public TableauAmortissement(Integer id, Date dateEffet) {
        this.id = id;
        this.dateEffet = dateEffet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateEffet() {
        return dateEffet;
    }

    public void setDateEffet(Date dateEffet) {
        this.dateEffet = dateEffet;
    }

    public Integer getTaxAssurance() {
        return taxAssurance;
    }

    public void setTaxAssurance(Integer taxAssurance) {
        this.taxAssurance = taxAssurance;
    }

    public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public Integer getAssuranceAnnuelle() {
		return assuranceAnnuelle;
	}

	public void setAssuranceAnnuelle(Integer assuranceAnnuelle) {
		this.assuranceAnnuelle = assuranceAnnuelle;
	}

	public Integer getEtat() {
		return etat;
	}

	public void setEtat(Integer etat) {
		this.etat = etat;
	}

	public Date getDateAnnulation() {
        return dateAnnulation;
    }

    public void setDateAnnulation(Date dateAnnulation) {
        this.dateAnnulation = dateAnnulation;
    }

    public ClientAcquereur getClientAcquereur() {
        return clientAcquereur;
    }

    public void setClientAcquereur(ClientAcquereur clientAcquereur) {
        this.clientAcquereur = clientAcquereur;
    }

    @XmlTransient
    public List<Mensualite> getMensualiteList() {
        return mensualiteList;
    }

    public void setMensualiteList(List<Mensualite> mensualiteList) {
        this.mensualiteList = mensualiteList;
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
        if (!(object instanceof TableauAmortissement)) {
            return false;
        }
        TableauAmortissement other = (TableauAmortissement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.TableauAmortissement[ id=" + id + " ]";
    }
    
}
