/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "FONC_GROUP_USER")
@SequenceGenerator(name="SEQ_FONC_GROUP_USER",sequenceName="S_FONC_GROUP_USER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FoncGroupUser.findAll", query = "SELECT f FROM FoncGroupUser f")})
public class FoncGroupUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_FONC_GROUP_USER")
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
    @JoinColumn(name = "FONCTIONNALITE", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Fonctionnalite fonctionnalite;
    @JoinColumn(name = "GROUPE_UTILISATEUR", referencedColumnName = "CODE", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GroupeUtilisateur groupeUtilisateur;

    public FoncGroupUser() {
    }

    public FoncGroupUser(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Fonctionnalite getFonctionnalite() {
        return fonctionnalite;
    }

    public void setFonctionnalite(Fonctionnalite fonctionnalite) {
        this.fonctionnalite = fonctionnalite;
    }

    public GroupeUtilisateur getGroupeUtilisateur() {
        return groupeUtilisateur;
    }

    public void setGroupeUtilisateur(GroupeUtilisateur groupeUtilisateur) {
        this.groupeUtilisateur = groupeUtilisateur;
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
        if (!(object instanceof FoncGroupUser)) {
            return false;
        }
        FoncGroupUser other = (FoncGroupUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.FoncGroupUser[ id=" + id + " ]";
    }
    
}
