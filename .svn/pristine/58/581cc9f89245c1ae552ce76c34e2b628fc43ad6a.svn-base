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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UC057
 */
@Entity
@Table(name = "DETAIL_MENSUALITE")
@SequenceGenerator(name="SEQ_DETAIL_MENSUALITE",sequenceName="S_DETAIL_MENSUALITE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailMensualite.findAll", query = "SELECT d FROM DetailMensualite d")})
public class DetailMensualite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_DETAIL_MENSUALITE")
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
    @Column(name = "DATE_DEB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeb;
    @Column(name = "DATE_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    @Column(name = "CAPITAL_RESTANT_DU")
    private Integer capitalRestantDu;
    private Integer interet;
    private Integer amortissement;
    private Integer annuite;
    @Column(name = "MONTANT_MENS")
    private Integer montantMens;
    @Column(name = "ASSURANCE_ANNUELLE")
    private Integer assuranceAnnuelle;
    @Column(name = "TAXE_ASSURANCE")
    private Integer taxeAssurance;
    @Column(name = "MENSUALITE_DEF")
    private Integer mensualiteDef;
    @JoinColumn(name = "MENSUALITE", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Mensualite mensualite;

    public DetailMensualite() {
    }

    public DetailMensualite(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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


    public Integer getMontantMens() {
		return montantMens;
	}

	public void setMontantMens(Integer montantMens) {
		this.montantMens = montantMens;
	}

	public Integer getAssuranceAnnuelle() {
		return assuranceAnnuelle;
	}

	public void setAssuranceAnnuelle(Integer assuranceAnnuelle) {
		this.assuranceAnnuelle = assuranceAnnuelle;
	}

	public Integer getCapitalRestantDu() {
		return capitalRestantDu;
	}

	public void setCapitalRestantDu(Integer capitalRestantDu) {
		this.capitalRestantDu = capitalRestantDu;
	}

	public Integer getInteret() {
		return interet;
	}

	public void setInteret(Integer interet) {
		this.interet = interet;
	}

	public Integer getAmortissement() {
		return amortissement;
	}

	public void setAmortissement(Integer amortissement) {
		this.amortissement = amortissement;
	}

	public Integer getAnnuite() {
		return annuite;
	}

	public void setAnnuite(Integer annuite) {
		this.annuite = annuite;
	}

	public Integer getTaxeAssurance() {
		return taxeAssurance;
	}

	public void setTaxeAssurance(Integer taxeAssurance) {
		this.taxeAssurance = taxeAssurance;
	}

	public Integer getMensualiteDef() {
        return mensualiteDef;
    }

    public void setMensualiteDef(Integer mensualiteDef) {
        this.mensualiteDef = mensualiteDef;
    }

    public Mensualite getMensualite() {
        return mensualite;
    }

    public void setMensualite(Mensualite mensualite) {
        this.mensualite = mensualite;
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
        if (!(object instanceof DetailMensualite)) {
            return false;
        }
        DetailMensualite other = (DetailMensualite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.DetailMensualite[ id=" + id + " ]";
    }
    
}
