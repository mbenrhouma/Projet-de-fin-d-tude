/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynapsys.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "TYPE_FRAIS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeFrais.findAll", query = "SELECT t FROM TypeFrais t")})
public class TypeFrais implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, precision = 22, scale = 0)
    private Integer id;
    @Size(max = 254)
    @Column(name = "LIBELLE_FR", length = 254)
    private String libelleFr;
    @Size(max = 254)
    @Column(name = "LIBELLE_AR", length = 254)
    private String libelleAr;
    @Column(name = "CODE_COMPTABLE")
    private BigInteger codeComptable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeFrais", fetch = FetchType.LAZY)
    private List<NoteDebit> noteDebitList;

    public TypeFrais() {
    }

    public TypeFrais(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelleFr() {
        return libelleFr;
    }

    public void setLibelleFr(String libelleFr) {
        this.libelleFr = libelleFr;
    }

    public String getLibelleAr() {
        return libelleAr;
    }

    public void setLibelleAr(String libelleAr) {
        this.libelleAr = libelleAr;
    }

    public BigInteger getCodeComptable() {
        return codeComptable;
    }

    public void setCodeComptable(BigInteger codeComptable) {
        this.codeComptable = codeComptable;
    }

    @XmlTransient
    public List<NoteDebit> getNoteDebitList() {
        return noteDebitList;
    }

    public void setNoteDebitList(List<NoteDebit> noteDebitList) {
        this.noteDebitList = noteDebitList;
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
        if (!(object instanceof TypeFrais)) {
            return false;
        }
        TypeFrais other = (TypeFrais) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cynapsys.entities.TypeFrais[ id=" + id + " ]";
    }
    
}
