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
@SequenceGenerator(name="SEQ_DECOMPTE",sequenceName="S_DECOMPTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Decompte.findAll", query = "SELECT d FROM Decompte d")})
public class Decompte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_DECOMPTE")
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "ID_DECOMPTE", nullable = false, length = 254)
    private String idDecompte;
    @Column(name = "TAUX_INTERET_RETARD")
    private Double	tauxInteretRetard;
    @Column(name = "DATE_DECOMPTE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDecompte;
    @Column(name = "CUMUL_MOIS")
    private Integer cumulMois;
    private Integer debit;
    private Integer credit;
    @Column(name = "SOLDE_DECOMPTE")
    private Integer soldeDecompte;
    @Column(name = "CUMUL_ARRIERE")
    private Integer cumulArriere;
    @Column(name = "MONTANT_INTERET_RETARD")
    private Integer montantInteretRetard;
    @Column(name = "TAUX_INT_APRES_ECH")
    private Double	tauxIntApresEch;
    @Column(name = "MONTANT_INT_APRES_ECH")
    private Integer montantIntApresEch;
    private Integer montant;
    @Column(name = "FRAIS_ASSURANCE")
    private Integer fraisAssurance;
    @Column(name = "FRAIS_CONTENTIEUX")
    private Integer fraisContentieux;
    @Column(name = "FRAIS_CONTRAT")
    private Integer fraisContrat;
    @Column(name = "FRAIS_LOTISSEMENT")
    private Integer fraisLotissement;
    @Column(name = "AUTRES_FRAIS")
    private Integer autresFrais;
    private Integer valide;
    @Size(max = 254)
    @Column(name = "NUM_ORDRE", length = 254)
    private String numOrdre;
    @Column(name = "DATE_DEBUT_CONTRAT")
    private Integer dateDebutContrat;
    @Column(name = "DATE_FIN_CONTRAT")
    private Integer dateFinContrat;
    @JoinColumn(name = "CLIENT_ACQUEREUR", referencedColumnName = "CODE_ACQUEREUR", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ClientAcquereur clientAcquereur;

    public Decompte() {
    }

    


	public Decompte(Double tauxInteretRetard, Date dateDecompte,
			Integer cumulMois, Integer debit, Integer credit,
			Integer soldeDecompte, Integer cumulArriere,
			Integer montantInteretRetard, Double tauxIntApresEch,
			Integer montantIntApresEch, Integer montant,
			Integer fraisAssurance, Integer fraisContentieux,
			Integer fraisContrat, Integer fraisLotissement,
			Integer autresFrais, Integer valide, String numOrdre,
			Integer dateDebutContrat, Integer dateFinContrat,
			ClientAcquereur clientAcquereur) {
		super();
		this.tauxInteretRetard = tauxInteretRetard;
		this.dateDecompte = dateDecompte;
		this.cumulMois = cumulMois;
		this.debit = debit;
		this.credit = credit;
		this.soldeDecompte = soldeDecompte;
		this.cumulArriere = cumulArriere;
		this.montantInteretRetard = montantInteretRetard;
		this.tauxIntApresEch = tauxIntApresEch;
		this.montantIntApresEch = montantIntApresEch;
		this.montant = montant;
		this.fraisAssurance = fraisAssurance;
		this.fraisContentieux = fraisContentieux;
		this.fraisContrat = fraisContrat;
		this.fraisLotissement = fraisLotissement;
		this.autresFrais = autresFrais;
		this.valide = valide;
		this.numOrdre = numOrdre;
		this.dateDebutContrat = dateDebutContrat;
		this.dateFinContrat = dateFinContrat;
		this.clientAcquereur = clientAcquereur;
	}




	public Decompte(String idDecompte) {
        this.idDecompte = idDecompte;
    }

    public String getIdDecompte() {
        return idDecompte;
    }

    public void setIdDecompte(String idDecompte) {
        this.idDecompte = idDecompte;
    }

    public Date getDateDecompte() {
        return dateDecompte;
    }

    public void setDateDecompte(Date dateDecompte) {
        this.dateDecompte = dateDecompte;
    }

    public Integer getCumulMois() {
        return cumulMois;
    }

    public void setCumulMois(Integer cumulMois) {
        this.cumulMois = cumulMois;
    }

    public Integer getDebit() {
        return debit;
    }

    public void setDebit(Integer debit) {
        this.debit = debit;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getSoldeDecompte() {
        return soldeDecompte;
    }

    public void setSoldeDecompte(Integer soldeDecompte) {
        this.soldeDecompte = soldeDecompte;
    }

    public Integer getCumulArriere() {
        return cumulArriere;
    }

    public void setCumulArriere(Integer cumulArriere) {
        this.cumulArriere = cumulArriere;
    }

    public Integer getMontantInteretRetard() {
        return montantInteretRetard;
    }

    public void setMontantInteretRetard(Integer montantInteretRetard) {
        this.montantInteretRetard = montantInteretRetard;
    }

    public Double getTauxInteretRetard() {
		return tauxInteretRetard;
	}

	public void setTauxInteretRetard(Double tauxInteretRetard) {
		this.tauxInteretRetard = tauxInteretRetard;
	}

	public Double getTauxIntApresEch() {
		return tauxIntApresEch;
	}

	public void setTauxIntApresEch(Double tauxIntApresEch) {
		this.tauxIntApresEch = tauxIntApresEch;
	}

	public Integer getMontantIntApresEch() {
        return montantIntApresEch;
    }

    public void setMontantIntApresEch(Integer montantIntApresEch) {
        this.montantIntApresEch = montantIntApresEch;
    }

    public Integer getMontant() {
        return montant;
    }

    public void setMontant(Integer montant) {
        this.montant = montant;
    }

    public Integer getFraisAssurance() {
        return fraisAssurance;
    }

    public void setFraisAssurance(Integer fraisAssurance) {
        this.fraisAssurance = fraisAssurance;
    }

    public Integer getFraisContentieux() {
        return fraisContentieux;
    }

    public void setFraisContentieux(Integer fraisContentieux) {
        this.fraisContentieux = fraisContentieux;
    }

    public Integer getFraisContrat() {
        return fraisContrat;
    }

    public void setFraisContrat(Integer fraisContrat) {
        this.fraisContrat = fraisContrat;
    }

    public Integer getFraisLotissement() {
        return fraisLotissement;
    }

    public void setFraisLotissement(Integer fraisLotissement) {
        this.fraisLotissement = fraisLotissement;
    }

    public Integer getAutresFrais() {
        return autresFrais;
    }

    public void setAutresFrais(Integer autresFrais) {
        this.autresFrais = autresFrais;
    }

    public Integer getValide() {
        return valide;
    }

    public void setValide(Integer valide) {
        this.valide = valide;
    }

    public String getNumOrdre() {
        return numOrdre;
    }

    public void setNumOrdre(String numOrdre) {
        this.numOrdre = numOrdre;
    }

    public Integer getDateDebutContrat() {
        return dateDebutContrat;
    }

    public void setDateDebutContrat(Integer dateDebutContrat) {
        this.dateDebutContrat = dateDebutContrat;
    }

    public Integer getDateFinContrat() {
        return dateFinContrat;
    }

    public void setDateFinContrat(Integer dateFinContrat) {
        this.dateFinContrat = dateFinContrat;
    }

    public ClientAcquereur getClientAcquereur() {
        return clientAcquereur;
    }

    public void setClientAcquereur(ClientAcquereur clientAcquereur) {
        this.clientAcquereur = clientAcquereur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDecompte != null ? idDecompte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Decompte)) {
            return false;
        }
        Decompte other = (Decompte) object;
        if ((this.idDecompte == null && other.idDecompte != null) || (this.idDecompte != null && !this.idDecompte.equals(other.idDecompte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.Decompte[ idDecompte=" + idDecompte + " ]";
    }
    
}
