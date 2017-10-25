/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynapsys.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UC057
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logement.findAll", query = "SELECT l FROM Logement l")})
public class Logement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "CODE_LOGEMENT", nullable = false, length = 254)
    private String codeLogement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "NUM_ORDRE", nullable = false, length = 254)
    private String numOrdre;
    @Size(max = 254)
    @Column(name = "ADRESSE_LOGE", length = 254)
    private String adresseLoge;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRIX_LOG", nullable = false)
    private Integer prixLog;
    @Column(name = "ETAT_LOG")
    private Integer etatLog;
    @Size(max = 254)
    @Column(name = "ADRESSE_LOGE_AR", length = 254)
    private String adresseLogeAr;
    @Size(max = 254)
    @Column(name = "CODE_POSTAL", nullable = true)
    private String codePostal;
    @JoinColumn(name = "GOUVERNORAT", referencedColumnName = "CODE", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Gouvernorat gouvernorat;
    @JoinColumn(name = "LOCALITE", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Localite localite;
    @JoinColumn(name = "LOTISSEMENT", referencedColumnName = "CODE", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Lotissement lotissement;
    @JoinColumn(name = "TYPE_LOGEMENT", referencedColumnName = "CODE_TYPE", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TypeLogement typeLogement;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "logement", fetch = FetchType.LAZY)
    private List<ClientAcquereur> clientAcquereurList;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "logement", fetch = FetchType.LAZY)
    private List<ClientLocataire> clientLocataireList;

    public Logement() {
    }

    public Logement(String codeLogement) {
        this.codeLogement = codeLogement;
    }

    public Logement(String codeLogement, String numOrdre, Integer prixLog) {
        this.codeLogement = codeLogement;
        this.numOrdre = numOrdre;
        this.prixLog = prixLog;
    }

   
    public Logement(String codeLogement,String codePostal, String adresseLoge ,Integer prixLog,Integer codegov,String libellegov,String codeType ,String libelleType) {
       this.codeLogement = codeLogement;
       this.codePostal=codePostal;
       this.adresseLoge=adresseLoge;
       this.prixLog=prixLog;
       this.gouvernorat=new Gouvernorat(codegov);
       this.gouvernorat.setLibelle(libellegov);
       this.typeLogement=new TypeLogement(codeType);
       this.typeLogement.setLibelle(libelleType);
       
       
    }
    public Logement(String codeLogement,String codePostal, String adresseLoge ,Integer prixLog,String numOrdre,Integer codegov,String libellegov,String codeType ,String libelleType,String codlot,String lotLibelle,
    		Integer locId,String locLibelle,String locCodePostal) {
        this.codeLogement = codeLogement;
        this.codePostal=codePostal;
        this.adresseLoge=adresseLoge;
        this.prixLog=prixLog;
        this.numOrdre=numOrdre;
        this.gouvernorat=new Gouvernorat(codegov);
        this.gouvernorat.setLibelle(libellegov);
        this.typeLogement=new TypeLogement(codeType);
        this.typeLogement.setLibelle(libelleType);
      
        this.lotissement=new Lotissement(codlot);
        this.lotissement.setLibelleFr(lotLibelle);
        this.localite=new Localite(locId);
        this.localite.setLibelleFr(locLibelle);
        this.localite.setCodePostal(locCodePostal);
     }
    public String getCodeLogement() {
        return codeLogement;
    }

    public void setCodeLogement(String codeLogement) {
        this.codeLogement = codeLogement;
    }

    public String getNumOrdre() {
        return numOrdre;
    }

    public void setNumOrdre(String numOrdre) {
        this.numOrdre = numOrdre;
    }

    public String getAdresseLoge() {
        return adresseLoge;
    }

    public void setAdresseLoge(String adresseLoge) {
        this.adresseLoge = adresseLoge;
    }

    public Integer getPrixLog() {
        return prixLog;
    }

    public void setPrixLog(Integer prixLog) {
        this.prixLog = prixLog;
    }

    public Integer getEtatLog() {
        return etatLog;
    }

    public void setEtatLog(Integer etatLog) {
        this.etatLog = etatLog;
    }


	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public Gouvernorat getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(Gouvernorat gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public Localite getLocalite() {
        return localite;
    }

    public void setLocalite(Localite localite) {
        this.localite = localite;
    }

    public Lotissement getLotissement() {
        return lotissement;
    }

    public void setLotissement(Lotissement lotissement) {
        this.lotissement = lotissement;
    }

    public TypeLogement getTypeLogement() {
        return typeLogement;
    }

    public void setTypeLogement(TypeLogement typeLogement) {
        this.typeLogement = typeLogement;
    }

    @XmlTransient
    public List<ClientAcquereur> getClientAcquereurList() {
        return clientAcquereurList;
    }

    public void setClientAcquereurList(List<ClientAcquereur> clientAcquereurList) {
        this.clientAcquereurList = clientAcquereurList;
    }

    @XmlTransient
    public List<ClientLocataire> getClientLocataireList() {
        return clientLocataireList;
    }

    public void setClientLocataireList(List<ClientLocataire> clientLocataireList) {
        this.clientLocataireList = clientLocataireList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeLogement != null ? codeLogement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logement)) {
            return false;
        }
        Logement other = (Logement) object;
        if ((this.codeLogement == null && other.codeLogement != null) || (this.codeLogement != null && !this.codeLogement.equals(other.codeLogement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.Logement[ codeLogement=" + codeLogement + " ]";
    }

	public String getAdresseLogeAr() {
		return adresseLogeAr;
	}

	public void setAdresseLogeAr(String adresseLogeAr) {
		this.adresseLogeAr = adresseLogeAr;
	}
    
}
