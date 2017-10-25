/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynapsys.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.Basic;
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
@SequenceGenerator(name="SEQ_ASSUREUR",sequenceName="S_ASSUREUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assureur.findAll", query = "SELECT a FROM Assureur a")})
public class Assureur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_ASSUREUR")
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(nullable = false, length = 254)
    private String abreviation;
    @Size(max = 254)
    @Column(name = "RAISON_SOCIAL", length = 254)
    private String raisonSocial;
    @Size(max = 254)
    @Column(name = "ADRESSE_SIEGE", length = 254)
    private String adresseSiege;
    @Column(name = "NUM_TEL")
    private BigInteger numTel;
    @Column(name = "NUM_FAX")
    private BigInteger numFax;
    @OneToMany(mappedBy = "assureur", fetch = FetchType.LAZY)
    private List<Assurance> assuranceList;

    public Assureur() {
    }

    public Assureur(Integer code) {
        this.code = code;
    }

    public Assureur(Integer code, String abreviation) {
        this.code = code;
        this.abreviation = abreviation;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getAbreviation() {
        return abreviation;
    }

    public void setAbreviation(String abreviation) {
        this.abreviation = abreviation;
    }

    public String getRaisonSocial() {
        return raisonSocial;
    }

    public void setRaisonSocial(String raisonSocial) {
        this.raisonSocial = raisonSocial;
    }

    public String getAdresseSiege() {
        return adresseSiege;
    }

    public void setAdresseSiege(String adresseSiege) {
        this.adresseSiege = adresseSiege;
    }

    public BigInteger getNumTel() {
        return numTel;
    }

    public void setNumTel(BigInteger numTel) {
        this.numTel = numTel;
    }

    public BigInteger getNumFax() {
        return numFax;
    }

    public void setNumFax(BigInteger numFax) {
        this.numFax = numFax;
    }

    @XmlTransient
    public List<Assurance> getAssuranceList() {
        return assuranceList;
    }

    public void setAssuranceList(List<Assurance> assuranceList) {
        this.assuranceList = assuranceList;
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
        if (!(object instanceof Assureur)) {
            return false;
        }
        Assureur other = (Assureur) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.Assureur[ code=" + code + " ]";
    }
    
}
