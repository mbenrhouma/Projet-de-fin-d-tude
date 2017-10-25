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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UC057
 */
@Entity
@SequenceGenerator(name="SEQ_CESSION",sequenceName="S_CESSION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cession.findAll", query = "SELECT c FROM Cession c")})
public class Cession implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_CESSION")
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
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
    @Column(nullable = false)
    private Integer mensualite;
    private Integer conjoint;
    private Integer cd;
    private Integer duree;
    @Size(max = 254)
    @Column(name = "MATRICULE_EMPLOYER", length = 254)
    private String matriculeEmployer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cession", fetch = FetchType.LAZY)
    private List<DetailQuiEmp> detailQuiEmpList;
    @JoinColumn(name = "CESSION_CLIENT", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CessionClient cessionClient;
    @JoinColumn(name = "EMPLOYEUR", referencedColumnName = "CODE_EMPLOYEUR", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employeur employeur;

    public Cession() {
    }

    public Cession(Integer id) {
        this.id = id;
    }

    public Cession(Integer id, Date dateDebut, Date dateFin, Integer mensualite,Integer idc,String codeAc,String nomPrenomFr,String code,String libelle) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.mensualite = mensualite;
        this.cessionClient=new CessionClient(idc);
        Groupe groupe=new Groupe(code);
        groupe.setLibelle(libelle);
        ClientAcquereur clacq = new ClientAcquereur(codeAc);
        clacq.setNomPrenomFr(nomPrenomFr);
        clacq.setGroupe(groupe);
        this.cessionClient.setClientAcquereur(clacq);
     
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

   
    public Integer getMensualite() {
		return mensualite;
	}

	public void setMensualite(Integer mensualite) {
		this.mensualite = mensualite;
	}

	public Integer getConjoint() {
		return conjoint;
	}

	public void setConjoint(Integer conjoint) {
		this.conjoint = conjoint;
	}

	public Integer getCd() {
		return cd;
	}

	public void setCd(Integer cd) {
		this.cd = cd;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public String getMatriculeEmployer() {
        return matriculeEmployer;
    }

    public void setMatriculeEmployer(String matriculeEmployer) {
        this.matriculeEmployer = matriculeEmployer;
    }

    @XmlTransient
    public List<DetailQuiEmp> getDetailQuiEmpList() {
        return detailQuiEmpList;
    }

    public void setDetailQuiEmpList(List<DetailQuiEmp> detailQuiEmpList) {
        this.detailQuiEmpList = detailQuiEmpList;
    }

    public CessionClient getCessionClient() {
        return cessionClient;
    }

    public void setCessionClient(CessionClient cessionClient) {
        this.cessionClient = cessionClient;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cession)) {
            return false;
        }
        Cession other = (Cession) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.Cession[ id=" + id + " ]";
    }
    
}
