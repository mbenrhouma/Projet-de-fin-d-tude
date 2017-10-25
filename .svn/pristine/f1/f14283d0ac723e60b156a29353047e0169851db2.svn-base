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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UC057
 */
@Entity
@Table(name = "CESSION_CLIENT")
@SequenceGenerator(name="SEQ_CESSION_CLIENT",sequenceName="S_CESSION_CLIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CessionClient.findAll", query = "SELECT c FROM CessionClient c")})
public class CessionClient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_CESSION_CLIENT")
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
    private Integer actif;
    @Column(name = "DATE_CLOTURE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCloture;
    @JoinColumn(name = "CLIENT_ACQUEREUR", referencedColumnName = "CODE_ACQUEREUR", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ClientAcquereur clientAcquereur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cessionClient", fetch = FetchType.LAZY)
    private List<Cession> cessionList;

    public CessionClient() {
    }

    public CessionClient(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActif() {
        return actif;
    }

    public void setActif(Integer actif) {
        this.actif = actif;
    }

    public Date getDateCloture() {
        return dateCloture;
    }

    public void setDateCloture(Date dateCloture) {
        this.dateCloture = dateCloture;
    }

    public ClientAcquereur getClientAcquereur() {
        return clientAcquereur;
    }

    public void setClientAcquereur(ClientAcquereur clientAcquereur) {
        this.clientAcquereur = clientAcquereur;
    }

    @XmlTransient
    public List<Cession> getCessionList() {
        return cessionList;
    }

    public void setCessionList(List<Cession> cessionList) {
        this.cessionList = cessionList;
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
        if (!(object instanceof CessionClient)) {
            return false;
        }
        CessionClient other = (CessionClient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.CessionClient[ id=" + id + " ]";
    }
    
}
