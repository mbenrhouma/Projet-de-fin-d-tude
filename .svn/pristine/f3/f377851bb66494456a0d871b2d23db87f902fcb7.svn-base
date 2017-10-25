/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynapsys.entities;

import java.io.Serializable;
import java.math.BigInteger;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UC057
 */
@Entity
@Table(name = "DETAIL_QUI_EMP")
@SequenceGenerator(name="SEQ_DETAIL_QUI_EMP",sequenceName="S_DETAIL_QUI_EMP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailQuiEmp.findAll", query = "SELECT d FROM DetailQuiEmp d")})
public class DetailQuiEmp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_DETAIL_QUI_EMP")
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
    @Column(name = "NBR_MOIS")
    private BigInteger nbrMois;
    @Column(name = "MONTANT_A_PAYE")
    private BigInteger montantAPaye;
    @Column(name = "MONTANT_RECU")
    private BigInteger montantRecu;
    @Column(name = "MONTANT_RESTANT")
    private BigInteger montantRestant;
    @JoinColumn(name = "CESSION", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cession cession;
    @JoinColumn(name = "QUITANCE_EMPLOYEUR", referencedColumnName = "NUM_QUITTANCE", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private QuitanceEmployeur quitanceEmployeur;

    public DetailQuiEmp() {
    }

    public DetailQuiEmp(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getNbrMois() {
        return nbrMois;
    }

    public void setNbrMois(BigInteger nbrMois) {
        this.nbrMois = nbrMois;
    }

    public BigInteger getMontantAPaye() {
        return montantAPaye;
    }

    public void setMontantAPaye(BigInteger montantAPaye) {
        this.montantAPaye = montantAPaye;
    }

    public BigInteger getMontantRecu() {
        return montantRecu;
    }

    public void setMontantRecu(BigInteger montantRecu) {
        this.montantRecu = montantRecu;
    }

    public BigInteger getMontantRestant() {
        return montantRestant;
    }

    public void setMontantRestant(BigInteger montantRestant) {
        this.montantRestant = montantRestant;
    }

    public Cession getCession() {
        return cession;
    }

    public void setCession(Cession cession) {
        this.cession = cession;
    }

    public QuitanceEmployeur getQuitanceEmployeur() {
        return quitanceEmployeur;
    }

    public void setQuitanceEmployeur(QuitanceEmployeur quitanceEmployeur) {
        this.quitanceEmployeur = quitanceEmployeur;
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
        if (!(object instanceof DetailQuiEmp)) {
            return false;
        }
        DetailQuiEmp other = (DetailQuiEmp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.DetailQuiEmp[ id=" + id + " ]";
    }
    
}
