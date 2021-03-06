/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynapsys.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "HISTORIQUE_CLIENT_LOC")
@SequenceGenerator(name="SEQ_HISTORIQUE_CLIENT_LOC",sequenceName="S_HISTORIQUE_CLIENT_LOC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoriqueClientLoc.findAll", query = "SELECT h FROM HistoriqueClientLoc h")})
public class HistoriqueClientLoc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_HISTORIQUE_CLIENT_LOC")
    @Basic(optional = false)
    @NotNull
    @Column(name = "HIS_ID", nullable = false)
    private Integer hisId;
    @Column(name = "DATE_DEBUT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Column(name = "DATE_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    @Column(name = "MONTANT_MENSUEL")
    private BigInteger montantMensuel;
    @Column(name = "DATE_MODIF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModif;
    @JoinColumn(name = "CLIENT_LOCATAIRE", referencedColumnName = "CODE_LOCATAIRE", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ClientLocataire clientLocataire;

    public HistoriqueClientLoc() {
    }

    public HistoriqueClientLoc(Integer hisId) {
        this.hisId = hisId;
    }

    public Integer getHisId() {
        return hisId;
    }

    public void setHisId(Integer hisId) {
        this.hisId = hisId;
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

    public BigInteger getMontantMensuel() {
        return montantMensuel;
    }

    public void setMontantMensuel(BigInteger montantMensuel) {
        this.montantMensuel = montantMensuel;
    }

    public Date getDateModif() {
        return dateModif;
    }

    public void setDateModif(Date dateModif) {
        this.dateModif = dateModif;
    }

    public ClientLocataire getClientLocataire() {
        return clientLocataire;
    }

    public void setClientLocataire(ClientLocataire clientLocataire) {
        this.clientLocataire = clientLocataire;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hisId != null ? hisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoriqueClientLoc)) {
            return false;
        }
        HistoriqueClientLoc other = (HistoriqueClientLoc) object;
        if ((this.hisId == null && other.hisId != null) || (this.hisId != null && !this.hisId.equals(other.hisId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.HistoriqueClientLoc[ hisId=" + hisId + " ]";
    }
    
}
