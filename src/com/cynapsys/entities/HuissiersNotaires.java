/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynapsys.entities;

import java.io.Serializable;
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
@Table(name = "HUISSIERS_NOTAIRES")
@SequenceGenerator(name="SEQ_HUISSIERS_NOTAIRES",sequenceName="S_HUISSIERS_NOTAIRES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HuissiersNotaires.findAll", query = "SELECT h FROM HuissiersNotaires h")})
public class HuissiersNotaires implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_HUISSIERS_NOTAIRES")
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
    @Size(max = 254)
    @Column(name = "NOM_FR", length = 254)
    private String nomFr;
    @Size(max = 254)
    @Column(length = 254)
    private String prenom;
    @Size(max = 254)
    @Column(length = 254)
    private String adresse;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 12)
    @Column(length = 12)
    private String phone;
    @Size(max = 254)
    @Column(name = "NOM_AR", length = 254)
    private String nomAr;
    @OneToMany(mappedBy = "huissiersNotaires", fetch = FetchType.LAZY)
    private List<Precontentieu> precontentieuList;

    public HuissiersNotaires() {
    }

    public HuissiersNotaires(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomFr() {
        return nomFr;
    }

    public void setNomFr(String nomFr) {
        this.nomFr = nomFr;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNomAr() {
        return nomAr;
    }

    public void setNomAr(String nomAr) {
        this.nomAr = nomAr;
    }

    @XmlTransient
    public List<Precontentieu> getPrecontentieuList() {
        return precontentieuList;
    }

    public void setPrecontentieuList(List<Precontentieu> precontentieuList) {
        this.precontentieuList = precontentieuList;
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
        if (!(object instanceof HuissiersNotaires)) {
            return false;
        }
        HuissiersNotaires other = (HuissiersNotaires) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.HuissiersNotaires[ id=" + id + " ]";
    }
    
}
