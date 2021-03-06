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
@Table(name = "CLIENT_LOCATAIRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientLocataire.findAll", query = "SELECT c FROM ClientLocataire c")})
public class ClientLocataire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "CODE_LOCATAIRE", nullable = false, length = 254)
    private String codeLocataire;
    private Integer cin;
    @Size(max = 254)
    @Column(name = "NOM_PRENOM_AR", length = 254)
    private String nomPrenomAr;
    @Size(max = 254)
    @Column(name = "NOM_PRENOM_FR", length = 254)
    private String nomPrenomFr;
    @Size(max = 254)
    @Column(name = "RAISON_SOCIALE", length = 254)
    private String raisonSociale;
    @Size(max = 254)
    @Column(name = "ADRESSE_LOGEMENT", length = 254)
    private String adresseLogement;
    @Size(max = 254)
    @Column(name = "ADRESSE_CORRESPONDANCE", length = 254)
    private String adresseCorrespondance;
    @Column(name = "SOLDE_LOYER")
    private Integer soldeLoyer;
    @Size(max = 254)
    @Column(name = "CODE_MAJ", length = 254)
    private String codeMaj;
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
    @Column(name = "LOYER_ANNUEL", nullable = false)
    private Integer loyerAnnuel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOYER_MENSUEL", nullable = false)
    private Integer loyerMensuel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ETAT_CONTRAT", nullable = false)
    private Integer etatContrat;
    @Column(name = "DATE_ENREGISTREMENT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnregistrement;
    @Column(name = "TAUX_AUGMETATION")
    private Integer tauxAugmetation;
    @Column(name = "DATE_FIN_LOCATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFinLocation;
    @Column(name = "ETAT_CLIENTLOC")
    private short etatClientloc;
    @Column(name = "DATE_SIGNATURE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSignature;
    @JoinColumn(name = "ANNEE_BUDGETAIRE", referencedColumnName = "CODE", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AnneeBudgetaire anneeBudgetaire;
    @JoinColumn(name = "GROUPE", referencedColumnName = "CODE", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Groupe groupe;
    @JoinColumn(name = "LOGEMENT", referencedColumnName = "CODE_LOGEMENT")
    @ManyToOne(fetch = FetchType.LAZY)
    private Logement logement;
    @OneToMany(mappedBy = "clientLocataire", fetch = FetchType.LAZY)
    private List<NoteDebit> noteDebitList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientLocataire", fetch = FetchType.LAZY)
    private List<HistoriqueClientLoc> historiqueClientLocList;
    @OneToMany(mappedBy = "clientLocataire", fetch = FetchType.LAZY)
    private List<Mouvement> mouvementList;

    public ClientLocataire() {
    }

    public ClientLocataire(String codeLocataire) {
        this.codeLocataire = codeLocataire;
    }

    public ClientLocataire(String codeLocataire, Integer duree, Date dateDebut, Date dateFin, Integer loyerAnnuel, Integer loyerMensuel, Integer etatContrat) {
        this.codeLocataire = codeLocataire;
        this.duree = duree;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.loyerAnnuel = loyerAnnuel;
        this.loyerMensuel = loyerMensuel;
        this.etatContrat = etatContrat;
    }

    public String getCodeLocataire() {
        return codeLocataire;
    }

    public void setCodeLocataire(String codeLocataire) {
        this.codeLocataire = codeLocataire;
    }

    public Integer getCin() {
        return cin;
    }

    public void setCin(Integer cin) {
        this.cin = cin;
    }

    public String getNomPrenomAr() {
        return nomPrenomAr;
    }

    public void setNomPrenomAr(String nomPrenomAr) {
        this.nomPrenomAr = nomPrenomAr;
    }

    public String getNomPrenomFr() {
        return nomPrenomFr;
    }

    public void setNomPrenomFr(String nomPrenomFr) {
        this.nomPrenomFr = nomPrenomFr;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getAdresseLogement() {
        return adresseLogement;
    }

    public void setAdresseLogement(String adresseLogement) {
        this.adresseLogement = adresseLogement;
    }

    public String getAdresseCorrespondance() {
        return adresseCorrespondance;
    }

    public void setAdresseCorrespondance(String adresseCorrespondance) {
        this.adresseCorrespondance = adresseCorrespondance;
    }

    public Integer getSoldeLoyer() {
        return soldeLoyer;
    }

    public void setSoldeLoyer(Integer soldeLoyer) {
        this.soldeLoyer = soldeLoyer;
    }

    public String getCodeMaj() {
        return codeMaj;
    }

    public void setCodeMaj(String codeMaj) {
        this.codeMaj = codeMaj;
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

    public Integer getLoyerAnnuel() {
        return loyerAnnuel;
    }

    public void setLoyerAnnuel(Integer loyerAnnuel) {
        this.loyerAnnuel = loyerAnnuel;
    }

    public Integer getLoyerMensuel() {
        return loyerMensuel;
    }

    public void setLoyerMensuel(Integer loyerMensuel) {
        this.loyerMensuel = loyerMensuel;
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

    public Integer getTauxAugmetation() {
        return tauxAugmetation;
    }

    public void setTauxAugmetation(Integer tauxAugmetation) {
        this.tauxAugmetation = tauxAugmetation;
    }

    public Date getDateFinLocation() {
        return dateFinLocation;
    }

    public void setDateFinLocation(Date dateFinLocation) {
        this.dateFinLocation = dateFinLocation;
    }

    public short getEtatClientloc() {
        return etatClientloc;
    }

    public void setEtatClientloc(short etatClientloc) {
        this.etatClientloc = etatClientloc;
    }

    public Date getDateSignature() {
        return dateSignature;
    }

    public void setDateSignature(Date dateSignature) {
        this.dateSignature = dateSignature;
    }

    public AnneeBudgetaire getAnneeBudgetaire() {
        return anneeBudgetaire;
    }

    public void setAnneeBudgetaire(AnneeBudgetaire anneeBudgetaire) {
        this.anneeBudgetaire = anneeBudgetaire;
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

    @XmlTransient
    public List<NoteDebit> getNoteDebitList() {
        return noteDebitList;
    }

    public void setNoteDebitList(List<NoteDebit> noteDebitList) {
        this.noteDebitList = noteDebitList;
    }

    @XmlTransient
    public List<HistoriqueClientLoc> getHistoriqueClientLocList() {
        return historiqueClientLocList;
    }

    public void setHistoriqueClientLocList(List<HistoriqueClientLoc> historiqueClientLocList) {
        this.historiqueClientLocList = historiqueClientLocList;
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
        hash += (codeLocataire != null ? codeLocataire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientLocataire)) {
            return false;
        }
        ClientLocataire other = (ClientLocataire) object;
        if ((this.codeLocataire == null && other.codeLocataire != null) || (this.codeLocataire != null && !this.codeLocataire.equals(other.codeLocataire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.ClientLocataire[ codeLocataire=" + codeLocataire + " ]";
    }
    
}
