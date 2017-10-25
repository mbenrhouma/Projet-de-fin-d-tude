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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UC057
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mouvement.findAll", query = "SELECT m FROM Mouvement m")})
public class Mouvement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MV", nullable = false)
    private Integer idMv;
    @Size(max = 254)
    @Column(name = "CODE_MV", length = 254)
    private String codeMv;
    @Column(name = "DATE_MV")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMv;
    @Column(name = "MONTANT_CREDIT")
    private Integer montantCredit;
    @Column(name = "MONTANT_DEBIT")
    private Integer montantDebit;
    @Column(name = "SOLDE_DEBITEUR")
    private Integer soldeDebiteur;
    @Column(name = "SOLDE_CREDITEUR")
    private Integer soldeCrediteur;
    @Column(name = "DATE_PIECE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePiece;
    @Column(name = "NUM_PIECE")
    private Integer numPiece;
    @Size(max = 254)
    @Column(name = "C_COMPT_LIBELLE", length = 254)
    private String cComptLibelle;
    @Column(name = "NBR_MOIS_RETARD")
    private Integer nbrMoisRetard;
    @Size(max = 254)
    @Column(name = "C_COMPT", length = 254)
    private String cCompt;
    @Size(max = 254)
    @Column(name = "ORIGINE_MVT", length = 254)
    private String origineMvt;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_VALEUR_S")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateValeurS;
    @Column(name = "DATE_PIECE_S")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePieceS;
    @Column(name = "MONTANT_MVT_S")
    private Integer montantMvtS;
    @Size(max = 254)
    @Column(name = "NUM_QUITTANCE", length = 254)
    private String numQuittance;
    private Integer annee;
    @Size(max = 1)
    @Column(name = "SENS_MV", length = 1)
    private String sensMv;
    @Size(max = 1)
    @Column(length = 1)
    private String supprimer;
    @JoinColumn(name = "CAT_RECETTE", referencedColumnName = "CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private CatRecette catRecette;
    @JoinColumn(name = "CLIENTACQUEREUR", referencedColumnName = "CODE_ACQUEREUR")
    @ManyToOne(fetch = FetchType.LAZY)
    private ClientAcquereur clientAcquereur;
    @JoinColumn(name = "CLIENTLOCATAIRE", referencedColumnName = "CODE_LOCATAIRE")
    @ManyToOne(fetch = FetchType.LAZY)
    private ClientLocataire clientLocataire;
    @JoinColumn(name = "MODE_PAYEMENT", referencedColumnName = "CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private ModePayement modePayement;
    @JoinColumn(name = "QUITANCE", referencedColumnName = "NUM_QUITTANCE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Quitance quitance;

    public Mouvement() {
    }

    public Mouvement(Integer idMv) {
        this.idMv = idMv;
    }

    public Integer getIdMv() {
        return idMv;
    }

    public void setIdMv(Integer idMv) {
        this.idMv = idMv;
    }

    public String getCodeMv() {
        return codeMv;
    }

    public void setCodeMv(String codeMv) {
        this.codeMv = codeMv;
    }

    public Date getDateMv() {
        return dateMv;
    }

    public void setDateMv(Date dateMv) {
        this.dateMv = dateMv;
    }

    public Integer getMontantCredit() {
        return montantCredit;
    }

    public void setMontantCredit(Integer montantCredit) {
        this.montantCredit = montantCredit;
    }

    public Integer getMontantDebit() {
        return montantDebit;
    }

    public void setMontantDebit(Integer montantDebit) {
        this.montantDebit = montantDebit;
    }

    public Integer getSoldeDebiteur() {
        return soldeDebiteur;
    }

    public void setSoldeDebiteur(Integer soldeDebiteur) {
        this.soldeDebiteur = soldeDebiteur;
    }

    public Integer getSoldeCrediteur() {
        return soldeCrediteur;
    }

    public void setSoldeCrediteur(Integer soldeCrediteur) {
        this.soldeCrediteur = soldeCrediteur;
    }

    public Date getDatePiece() {
        return datePiece;
    }

    public void setDatePiece(Date datePiece) {
        this.datePiece = datePiece;
    }

    public Integer getNumPiece() {
        return numPiece;
    }

    public void setNumPiece(Integer numPiece) {
        this.numPiece = numPiece;
    }

    public String getCComptLibelle() {
        return cComptLibelle;
    }

    public void setCComptLibelle(String cComptLibelle) {
        this.cComptLibelle = cComptLibelle;
    }

    public Integer getNbrMoisRetard() {
        return nbrMoisRetard;
    }

    public void setNbrMoisRetard(Integer nbrMoisRetard) {
        this.nbrMoisRetard = nbrMoisRetard;
    }

    public String getCCompt() {
        return cCompt;
    }

    public void setCCompt(String cCompt) {
        this.cCompt = cCompt;
    }

    public String getOrigineMvt() {
        return origineMvt;
    }

    public void setOrigineMvt(String origineMvt) {
        this.origineMvt = origineMvt;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateValeurS() {
        return dateValeurS;
    }

    public void setDateValeurS(Date dateValeurS) {
        this.dateValeurS = dateValeurS;
    }

    public Date getDatePieceS() {
        return datePieceS;
    }

    public void setDatePieceS(Date datePieceS) {
        this.datePieceS = datePieceS;
    }

    public Integer getMontantMvtS() {
        return montantMvtS;
    }

    public void setMontantMvtS(Integer montantMvtS) {
        this.montantMvtS = montantMvtS;
    }

    public String getNumQuittance() {
        return numQuittance;
    }

    public void setNumQuittance(String numQuittance) {
        this.numQuittance = numQuittance;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public String getSensMv() {
        return sensMv;
    }

    public void setSensMv(String sensMv) {
        this.sensMv = sensMv;
    }

    public String getSupprimer() {
        return supprimer;
    }

    public void setSupprimer(String supprimer) {
        this.supprimer = supprimer;
    }

    public CatRecette getCatRecette() {
        return catRecette;
    }

    public void setCatRecette(CatRecette catRecette) {
        this.catRecette = catRecette;
    }

    public ClientAcquereur getClientAcquereur() {
        return clientAcquereur;
    }

    public void setClientAcquereur(ClientAcquereur clientAcquereur) {
        this.clientAcquereur = clientAcquereur;
    }

    public ClientLocataire getClientLocataire() {
        return clientLocataire;
    }

    public void setClientLocataire(ClientLocataire clientLocataire) {
        this.clientLocataire = clientLocataire;
    }

    public ModePayement getModePayement() {
        return modePayement;
    }

    public void setModePayement(ModePayement modePayement) {
        this.modePayement = modePayement;
    }

    public Quitance getQuitance() {
        return quitance;
    }

    public void setQuitance(Quitance quitance) {
        this.quitance = quitance;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMv != null ? idMv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mouvement)) {
            return false;
        }
        Mouvement other = (Mouvement) object;
        if ((this.idMv == null && other.idMv != null) || (this.idMv != null && !this.idMv.equals(other.idMv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.Mouvement[ idMv=" + idMv + " ]";
    }
    
}
