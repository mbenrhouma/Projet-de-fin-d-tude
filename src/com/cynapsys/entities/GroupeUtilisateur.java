/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynapsys.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UC057
 */
@Entity
@Table(name = "GROUPE_UTILISATEUR")
@SequenceGenerator(name="SEQ_GROUPE_UTILISATEUR",sequenceName="S_GROUPE_UTILISATEUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupeUtilisateur.findAll", query = "SELECT g FROM GroupeUtilisateur g")})
public class GroupeUtilisateur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_GROUPE_UTILISATEUR")
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer code;
    @Size(max = 254)
    @Column(length = 254)
    private String nom;
    @Size(max = 254)
    @Column(length = 254)
    private String nature;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupeUtilisateur", fetch = FetchType.LAZY)
    private List<Utilisateur> utilisateurList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupeUtilisateur", fetch = FetchType.LAZY)
    private List<FoncGroupUser> foncGroupUserList;

    public GroupeUtilisateur() {
    }

    public GroupeUtilisateur(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    @XmlTransient
    public List<Utilisateur> getUtilisateurList() {
        return utilisateurList;
    }

    public void setUtilisateurList(List<Utilisateur> utilisateurList) {
        this.utilisateurList = utilisateurList;
    }

    @XmlTransient
    public List<FoncGroupUser> getFoncGroupUserList() {
        return foncGroupUserList;
    }

    public void setFoncGroupUserList(List<FoncGroupUser> foncGroupUserList) {
        this.foncGroupUserList = foncGroupUserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupeUtilisateur)) {
            return false;
        }
        GroupeUtilisateur other = (GroupeUtilisateur) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.GroupeUtilisateur[ code=" + code + " ]";
    }
    
}