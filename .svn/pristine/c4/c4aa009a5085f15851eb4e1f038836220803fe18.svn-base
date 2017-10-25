/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynapsys.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Table;
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
@Table(name = "CLIENT_ACQUEREUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientAcquereur.findAll", query = "SELECT c FROM ClientAcquereur c")})
public class ClientAcquereur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "CODE_ACQUEREUR", nullable = false, length = 254)
    private String codeAcquereur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "NOM_PRENOM_FR", nullable = false, length = 254)
    private String nomPrenomFr;
    @Size(max = 254)
    @Column(name = "NOM_PRENOM_AR", length = 254)
    private String nomPrenomAr;
    @Column(name = "COMPTE_CONJOINT")
    private Integer compteConjoint;
    @Size(max = 254)
    @Column(name = "NOM_PRENOM_CONJOINT_FR", length = 254)
    private String nomPrenomConjointFr;
    @Size(max = 254)
    @Column(name = "NOM_PRENOM_CONJOINT_AR", length = 254)
    private String nomPrenomConjointAr;
    @Column(name = "DATE_NAISSANCE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNaissance;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "ADRESSE_CORRESPONDANCE", nullable = false, length = 254)
    private String adresseCorrespondance;
    @Size(max = 10)
    @Column(length = 10)
    private String cin;
    @Size(max = 10)
    @Column(name = "CIN_CONJOINT", length = 10)
    private String cinConjoint;
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
    @Column(name = "DUREE_CONTRAT", nullable = false)
    private Integer dureeContrat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ETAT_CONTRAT", nullable = false)
    private Integer etatContrat;
    @Column(name = "DATE_ENREGISTREMENT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnregistrement;
    private Integer prix;
    private Integer avance;
    private Integer solde;
    private Boolean contentieux;
    @Column(name = "EN_ARRANGEMENT")
    private Boolean enArrangement;
    @Column(name = "PRIX_PROVISOIRE")
    private Integer prixProvisoire;
    @Column(name = "SOLDE_CL_ACTUEL")
    private Integer soldeClActuel;
    private Integer numarchivage;
    @Column(name = " NV_ARCHIVE ")
    private Boolean  nvArchive ;
    @Temporal(TemporalType.TIMESTAMP)
    private Date datearchivage;
    @Temporal(TemporalType.TIMESTAMP)
    private Date datemainlevee;
    @Column(name = "INTERET_RETARD")
    private Integer interetRetard;
    @Column(name = "INTERET_APR_ECH")
    private Integer interetAprEch;
    @Size(max = 254)
    @Column(name = "CODE_MAJ", length = 254)
    private String codeMaj;
    @Size(max = 254)
    @Column(name = "ADRESSE_CORRESPONDANCE_AR", length = 254)
    private String adresseCorrespondanceAr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientAcquereur", fetch = FetchType.LAZY)
    private List<AncienneQuittance> ancienneQuittanceList;
    @OneToMany(mappedBy = "clientAcquereur", fetch = FetchType.LAZY)
    private List<Impayee> impayeeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientAcquereur", fetch = FetchType.LAZY)
    private List<Mainlevee> mainleveeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientAcquereur", fetch = FetchType.LAZY)
    private List<CessionClient> cessionClientList;
    @JoinColumn(name = "ANNEE_BUDGETAIRE", referencedColumnName = "CODE", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AnneeBudgetaire anneeBudgetaire;
    @JoinColumn(name = "DECES", referencedColumnName = "CODE_DECES")
    @ManyToOne(fetch = FetchType.LAZY)
    private Deces deces;
    @JoinColumn(name = "GROUPE", referencedColumnName = "CODE", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Groupe groupe;
    @JoinColumn(name = "LOGEMENT", referencedColumnName = "CODE_LOGEMENT")
    @ManyToOne(fetch = FetchType.LAZY)
    private Logement logement;
    @JoinColumn(name = "MAINLEVEE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Mainlevee mainlevee;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientAcquereur", fetch = FetchType.LAZY)
    private List<Reclamation> reclamationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientAcquereur", fetch = FetchType.LAZY)
    private List<Decompte> decompteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientAcquereur", fetch = FetchType.LAZY)
    private List<Assurance> assuranceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientAcquereur", fetch = FetchType.LAZY)
    private List<Deces> decesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientAcquereur", fetch = FetchType.LAZY)
    private List<TableauAmortissement> tableauAmortissementList;
    @OneToMany(mappedBy = "clientAcquereur", fetch = FetchType.LAZY)
    private List<NoteDebit> noteDebitList;
    @OneToMany(mappedBy = "clientAcquereur", fetch = FetchType.LAZY)
    private List<Mouvement> mouvementList;
    public ClientAcquereur() {
    }

    public ClientAcquereur(String codeAcquereur) {
        this.codeAcquereur = codeAcquereur;
    }

    public ClientAcquereur(String groupe,String libelle,String codeClient, String NomEtPrenom,String codelogement, String adresseLogement, String annee,String cin,Date datenaisse,String adresseCoress,String code,Integer prix,Date archivage ) {
       this.groupe= new Groupe(groupe);
       this.groupe.setLibelle(libelle);
       this.codeAcquereur=codeClient;
       this.nomPrenomFr=NomEtPrenom;
       this.logement= new Logement(codelogement);
       this.logement.setAdresseLoge(adresseLogement);
       this.anneeBudgetaire= new AnneeBudgetaire(annee);
       this.cin=cin;
       this.dateNaissance=datenaisse;
       this.adresseCorrespondance=adresseCoress;
       this.logement.setCodePostal(code);
       this.prix=prix;
       this.datearchivage=archivage;
       
    }

    public ClientAcquereur(String codeAcquereur, String nomPrenomFr, String adresseCorrespondance, Date dateDebut, Date dateFin, Integer dureeContrat, Integer etatContrat) {
        this.codeAcquereur = codeAcquereur;
        this.nomPrenomFr = nomPrenomFr;
        this.adresseCorrespondance = adresseCorrespondance;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.dureeContrat = dureeContrat;
        this.etatContrat = etatContrat;
    }
    
    public ClientAcquereur(String groupe,String libelle,String codeClient, String NomEtPrenom,String codelogement, String adresseLogement,String codePostal,Integer solde) {
        this.groupe= new Groupe(groupe);
        this.groupe.setLibelle(libelle);
        this.codeAcquereur=codeClient;
        this.nomPrenomFr=NomEtPrenom;
        this.logement= new Logement(codelogement);
        this.logement.setAdresseLoge(adresseLogement);
        this.logement.setCodePostal(codePostal);
       
        this.solde=solde;
       
     }
  

    public String getCodeAcquereur() {
        return codeAcquereur;
    }

    public void setCodeAcquereur(String codeAcquereur) {
        this.codeAcquereur = codeAcquereur;
    }

    public String getNomPrenomFr() {
        return nomPrenomFr;
    }

    public void setNomPrenomFr(String nomPrenomFr) {
        this.nomPrenomFr = nomPrenomFr;
    }

    public String getNomPrenomAr() {
        return nomPrenomAr;
    }

    public void setNomPrenomAr(String nomPrenomAr) {
        this.nomPrenomAr = nomPrenomAr;
    }

    public Integer getCompteConjoint() {
        return compteConjoint;
    }

    public void setCompteConjoint(Integer compteConjoint) {
        this.compteConjoint = compteConjoint;
    }

    public String getNomPrenomConjointFr() {
        return nomPrenomConjointFr;
    }

    public void setNomPrenomConjointFr(String nomPrenomConjointFr) {
        this.nomPrenomConjointFr = nomPrenomConjointFr;
    }

    public String getNomPrenomConjointAr() {
        return nomPrenomConjointAr;
    }

    public void setNomPrenomConjointAr(String nomPrenomConjointAr) {
        this.nomPrenomConjointAr = nomPrenomConjointAr;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresseCorrespondance() {
        return adresseCorrespondance;
    }

    public void setAdresseCorrespondance(String adresseCorrespondance) {
        this.adresseCorrespondance = adresseCorrespondance;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getCinConjoint() {
        return cinConjoint;
    }

    public void setCinConjoint(String cinConjoint) {
        this.cinConjoint = cinConjoint;
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

    public Integer getDureeContrat() {
        return dureeContrat;
    }

    public void setDureeContrat(Integer dureeContrat) {
        this.dureeContrat = dureeContrat;
    }

    public Integer getEtatContrat() {
        return etatContrat;
    }

    public void setEtatContrat(Integer etatContrat) {
        this.etatContrat = etatContrat;
    }

    public Date getDateEnregistrement() {
        return dateEnregistrement;
    }

    public void setDateEnregistrement(Date dateEnregistrement) {
        this.dateEnregistrement = dateEnregistrement;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public Integer getAvance() {
        return avance;
    }

    public void setAvance(Integer avance) {
        this.avance = avance;
    }

    public Integer getSolde() {
        return solde;
    }

    public void setSolde(Integer solde) {
        this.solde = solde;
    }

    public Boolean getContentieux() {
        return contentieux;
    }

    public void setContentieux(Boolean contentieux) {
        this.contentieux = contentieux;
    }

    public Boolean getEnArrangement() {
        return enArrangement;
    }

    public void setEnArrangement(Boolean enArrangement) {
        this.enArrangement = enArrangement;
    }

    public Integer getPrixProvisoire() {
        return prixProvisoire;
    }

    public void setPrixProvisoire(Integer prixProvisoire) {
        this.prixProvisoire = prixProvisoire;
    }

    public Integer getSoldeClActuel() {
        return soldeClActuel;
    }

    public void setSoldeClActuel(Integer soldeClActuel) {
        this.soldeClActuel = soldeClActuel;
    }

    public Integer getNumarchivage() {
        return numarchivage;
    }

    public void setNumarchivage(Integer numarchivage) {
        this.numarchivage = numarchivage;
    }

    public Date getDatearchivage() {
        return datearchivage;
    }

    public void setDatearchivage(Date datearchivage) {
        this.datearchivage = datearchivage;
    }

    public Date getDatemainlevee() {
        return datemainlevee;
    }

    public void setDatemainlevee(Date datemainlevee) {
        this.datemainlevee = datemainlevee;
    }

    public Integer getInteretRetard() {
        return interetRetard;
    }

    public void setInteretRetard(Integer interetRetard) {
        this.interetRetard = interetRetard;
    }

    public Integer getInteretAprEch() {
        return interetAprEch;
    }

    public void setInteretAprEch(Integer interetAprEch) {
        this.interetAprEch = interetAprEch;
    }

    public String getCodeMaj() {
        return codeMaj;
    }

    public void setCodeMaj(String codeMaj) {
        this.codeMaj = codeMaj;
    }

    public String getAdresseCorrespondanceAr() {
        return adresseCorrespondanceAr;
    }

    public void setAdresseCorrespondanceAr(String adresseCorrespondanceAr) {
        this.adresseCorrespondanceAr = adresseCorrespondanceAr;
    }

    @XmlTransient
    public List<AncienneQuittance> getAncienneQuittanceList() {
        return ancienneQuittanceList;
    }

    public void setAncienneQuittanceList(List<AncienneQuittance> ancienneQuittanceList) {
        this.ancienneQuittanceList = ancienneQuittanceList;
    }

    @XmlTransient
    public List<Impayee> getImpayeeList() {
        return impayeeList;
    }

    public void setImpayeeList(List<Impayee> impayeeList) {
        this.impayeeList = impayeeList;
    }

    @XmlTransient
    public List<Mainlevee> getMainleveeList() {
        return mainleveeList;
    }

    public void setMainleveeList(List<Mainlevee> mainleveeList) {
        this.mainleveeList = mainleveeList;
    }

    @XmlTransient
    public List<CessionClient> getCessionClientList() {
        return cessionClientList;
    }

    public void setCessionClientList(List<CessionClient> cessionClientList) {
        this.cessionClientList = cessionClientList;
    }

    public AnneeBudgetaire getAnneeBudgetaire() {
        return anneeBudgetaire;
    }

    public void setAnneeBudgetaire(AnneeBudgetaire anneeBudgetaire) {
        this.anneeBudgetaire = anneeBudgetaire;
    }

    public Deces getDeces() {
        return deces;
    }

    public void setDeces(Deces deces) {
        this.deces = deces;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public Logement getLogement() {
        return logement;
    }

    public void setLogement(Logement logement) {
        this.logement = logement;
    }

    public Mainlevee getMainlevee() {
        return mainlevee;
    }

    public void setMainlevee(Mainlevee mainlevee) {
        this.mainlevee = mainlevee;
    }

    @XmlTransient
    public List<Reclamation> getReclamationList() {
        return reclamationList;
    }

    public void setReclamationList(List<Reclamation> reclamationList) {
        this.reclamationList = reclamationList;
    }

    @XmlTransient
    public List<Decompte> getDecompteList() {
        return decompteList;
    }

    public void setDecompteList(List<Decompte> decompteList) {
        this.decompteList = decompteList;
    }

    @XmlTransient
    public List<Assurance> getAssuranceList() {
        return assuranceList;
    }

    public void setAssuranceList(List<Assurance> assuranceList) {
        this.assuranceList = assuranceList;
    }

    @XmlTransient
    public List<Deces> getDecesList() {
        return decesList;
    }

    public void setDecesList(List<Deces> decesList) {
        this.decesList = decesList;
    }

    @XmlTransient
    public List<TableauAmortissement> getTableauAmortissementList() {
        return tableauAmortissementList;
    }

    public void setTableauAmortissementList(List<TableauAmortissement> tableauAmortissementList) {
        this.tableauAmortissementList = tableauAmortissementList;
    }

    @XmlTransient
    public List<NoteDebit> getNoteDebitList() {
        return noteDebitList;
    }

    public void setNoteDebitList(List<NoteDebit> noteDebitList) {
        this.noteDebitList = noteDebitList;
    }

    @XmlTransient
    public List<Mouvement> getMouvementList() {
        return mouvementList;
    }

    public void setMouvementList(List<Mouvement> mouvementList) {
        this.mouvementList = mouvementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeAcquereur != null ? codeAcquereur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientAcquereur)) {
            return false;
        }
        ClientAcquereur other = (ClientAcquereur) object;
        if ((this.codeAcquereur == null && other.codeAcquereur != null) || (this.codeAcquereur != null && !this.codeAcquereur.equals(other.codeAcquereur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.ClientAcquereur[ codeAcquereur=" + codeAcquereur + " ]";
    }



	public Boolean getNvArchive() {
		return nvArchive;
	}

	public void setNvArchive(Boolean nvArchive) {
		this.nvArchive = nvArchive;
	}

	
}
