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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UC057
 */
@Entity
@SequenceGenerator(name="SEQ_EMPLOYEUR",sequenceName="S_EMPLOYEUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employeur.findAll", query = "SELECT e FROM Employeur e")})
public class Employeur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_EMPLOYEUR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODE_EMPLOYEUR", nullable = false)
    private Integer codeEmployeur;
    @Size(max = 254)
    @Column(name = "NOM_EMPLOYEUR_AR", length = 254)
    private String nomEmployeurAr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "NOM_EMPLOYEUR_FR", nullable = false, length = 254)
    private String nomEmployeurFr;
    @Size(max = 254)
    @Column(length = 254)
    private String abreviation;
    @Size(max = 254)
    @Column(name = "ADRESSE_EMPLOYEUR", length = 254)
    private String adresseEmployeur;
    @Size(max = 8)
    @Column(name = "NUM_PHONE", length = 8)
    private String numPhone;
    @Size(max = 8)
    @Column(name = "NUM_FAX", length = 8)
    private String numFax;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeur", fetch = FetchType.LAZY)
    private List<Cession> cessionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeur", fetch = FetchType.LAZY)
    private List<QuitanceEmployeur> quitanceEmployeurList;

    public Employeur() {
    }

    public Employeur(Integer codeEmployeur) {
        this.codeEmployeur = codeEmployeur;
    }

    public Employeur(Integer codeEmployeur, String nomEmployeurFr) {
        this.codeEmployeur = codeEmployeur;
        this.nomEmployeurFr = nomEmployeurFr;
    }

    public Integer getCodeEmployeur() {
        return codeEmployeur;
    }

    public void setCodeEmployeur(Integer codeEmployeur) {
        this.codeEmployeur = codeEmployeur;
    }

    public String getNomEmployeurAr() {
        return nomEmployeurAr;
    }

    public void setNomEmployeurAr(String nomEmployeurAr) {
        this.nomEmployeurAr = nomEmployeurAr;
    }

    public String getNomEmployeurFr() {
        return nomEmployeurFr;
    }

    public void setNomEmployeurFr(String nomEmployeurFr) {
        this.nomEmployeurFr = nomEmployeurFr;
    }

    public String getAbreviation() {
        return abreviation;
    }

    public void setAbreviation(String abreviation) {
        this.abreviation = abreviation;
    }

    public String getAdresseEmployeur() {
        return adresseEmployeur;
    }

    public void setAdresseEmployeur(String adresseEmployeur) {
        this.adresseEmployeur = adresseEmployeur;
    }

    public String getNumPhone() {
        return numPhone;
    }

    public void setNumPhone(String numPhone) {
        this.numPhone = numPhone;
    }

    public String getNumFax() {
        return numFax;
    }

    public void setNumFax(String numFax) {
        this.numFax = numFax;
    }

    @XmlTransient
    public List<Cession> getCessionList() {
        return cessionList;
    }

    public void setCessionList(List<Cession> cessionList) {
        this.cessionList = cessionList;
    }

    @XmlTransient
    public List<QuitanceEmployeur> getQuitanceEmployeurList() {
        return quitanceEmployeurList;
    }

    public void setQuitanceEmployeurList(List<QuitanceEmployeur> quitanceEmployeurList) {
        this.quitanceEmployeurList = quitanceEmployeurList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeEmployeur != null ? codeEmployeur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employeur)) {
            return false;
        }
        Employeur other = (Employeur) object;
        if ((this.codeEmployeur == null && other.codeEmployeur != null) || (this.codeEmployeur != null && !this.codeEmployeur.equals(other.codeEmployeur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.Employeur[ codeEmployeur=" + codeEmployeur + " ]";
    }
    
}
