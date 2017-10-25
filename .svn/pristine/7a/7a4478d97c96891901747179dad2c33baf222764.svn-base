package com.cynapsys.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "DETAIL_QUI_EMP")
@SequenceGenerator(name="SEQ_DETAIL_QUI_EMP",sequenceName="S_DETAIL_QUI_EMP")
@XmlRootElement
public class DetailQuittanceEmployeur implements Serializable {
	 private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_DETAIL_QUI_EMP")
	    @Basic(optional = false)
	    @NotNull
	    @Column(nullable = false)
	    private Integer id;
	    @Column(name = "NBR_MOIS")
	    private Integer nombredemois;
	    @Column(name = "MONTANT_A_PAYE")
	    private Integer montantapayé;
	    @Column(name = "MONTANT_RECU")
	    private Integer montantrecu;
	    @Column(name = "MONTANT_RESTANT")
	    private Integer montantrestant;
	    @JoinColumn(name = "QUITANCE_EMPLOYEUR", referencedColumnName = "NUM_QUITTANCE", nullable = false)
	    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	    private QuitanceEmployeur quittanceEmployeur;
	    @JoinColumn(name = "CESSION", referencedColumnName = "ID", nullable = false)
	    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	    private Cession cession;
	
	    
	    
	    public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getNombredemois() {
			return nombredemois;
		}
		public void setNombredemois(Integer nombredemois) {
			this.nombredemois = nombredemois;
		}
		public Integer getMontantapayé() {
			return montantapayé;
		}
		public void setMontantapayé(Integer montantapayé) {
			this.montantapayé = montantapayé;
		}
		public Integer getMontantrecu() {
			return montantrecu;
		}
		public void setMontantrecu(Integer montantrecu) {
			this.montantrecu = montantrecu;
		}
		public Integer getMontantrestant() {
			return montantrestant;
		}
		public void setMontantrestant(Integer montantrestant) {
			this.montantrestant = montantrestant;
		}
		public QuitanceEmployeur getQuittanceEmployeur() {
			return quittanceEmployeur;
		}
		public void setQuittanceEmployeur(QuitanceEmployeur quittanceEmployeur) {
			this.quittanceEmployeur = quittanceEmployeur;
		}
		public Cession getCession() {
			return cession;
		}
		public void setCession(Cession cession) {
			this.cession = cession;
		}
	    
	    
	    

}
