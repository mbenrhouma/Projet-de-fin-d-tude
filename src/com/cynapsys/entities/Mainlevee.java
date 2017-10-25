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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UC057
 */
@Entity    
@SequenceGenerator(name="SEQ_MAINLEVEE",sequenceName="S_MAINLEVEE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mainlevee.findAll", query = "SELECT m FROM Mainlevee m")})
public class Mainlevee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_MAINLEVEE")
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
    @Column(name = "DATE_MAINLEVEE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMainlevee;
    @JoinColumn(name = "CLIENT_ACQUEREUR", referencedColumnName = "CODE_ACQUEREUR", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ClientAcquereur clientAcquereur;
    @JoinColumn(name = "TYPE_MAINLEVEE", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TypeMainlevee typeMainlevee;
    @OneToMany(mappedBy = "mainlevee", fetch = FetchType.LAZY)
    private List<ClientAcquereur> clientAcquereurList;

    public Mainlevee() {
    }

    public Mainlevee(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateMainlevee() {
        return dateMainlevee;
    }

    public void setDateMainlevee(Date dateMainlevee) {
        this.dateMainlevee = dateMainlevee;
    }

    public ClientAcquereur getClientAcquereur() {
        return clientAcquereur;
    }

    public void setClientAcquereur(ClientAcquereur clientAcquereur) {
        this.clientAcquereur = clientAcquereur;
    }

    public TypeMainlevee getTypeMainlevee() {
        return typeMainlevee;
    }

    public void setTypeMainlevee(TypeMainlevee typeMainlevee) {
        this.typeMainlevee = typeMainlevee;
    }

    @XmlTransient
    public List<ClientAcquereur> getClientAcquereurList() {
        return clientAcquereurList;
    }

    public void setClientAcquereurList(List<ClientAcquereur> clientAcquereurList) {
        this.clientAcquereurList = clientAcquereurList;
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
        if (!(object instanceof Mainlevee)) {
            return false;
        }
        Mainlevee other = (Mainlevee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.Mainlevee[ id=" + id + " ]";
    }
    
}
