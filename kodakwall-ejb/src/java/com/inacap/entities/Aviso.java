/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inacap.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ZALO
 */
@Entity
@Table(name = "aviso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aviso.findAll", query = "SELECT a FROM Aviso a")
    , @NamedQuery(name = "Aviso.findByIdaviso", query = "SELECT a FROM Aviso a WHERE a.idaviso = :idaviso")
    , @NamedQuery(name = "Aviso.findByMarca", query = "SELECT a FROM Aviso a WHERE a.marca = :marca")
    , @NamedQuery(name = "Aviso.findByModelo", query = "SELECT a FROM Aviso a WHERE a.modelo = :modelo")
    , @NamedQuery(name = "Aviso.findByLink", query = "SELECT a FROM Aviso a WHERE a.link = :link")
    , @NamedQuery(name = "Aviso.findByImagen", query = "SELECT a FROM Aviso a WHERE a.imagen = :imagen")
    , @NamedQuery(name = "Aviso.findByFecha", query = "SELECT a FROM Aviso a WHERE a.fecha = :fecha")})
public class Aviso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idaviso")
    private Integer idaviso;
    @Column(name = "marca")
    private String marca;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "link")
    private String link;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "fecha")
    private String fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "avisoIdaviso")
    private List<Favorito> favoritoList;

    public Aviso() {
    }

    public Aviso(Integer idaviso) {
        this.idaviso = idaviso;
    }

    public Integer getIdaviso() {
        return idaviso;
    }

    public void setIdaviso(Integer idaviso) {
        this.idaviso = idaviso;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<Favorito> getFavoritoList() {
        return favoritoList;
    }

    public void setFavoritoList(List<Favorito> favoritoList) {
        this.favoritoList = favoritoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaviso != null ? idaviso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aviso)) {
            return false;
        }
        Aviso other = (Aviso) object;
        if ((this.idaviso == null && other.idaviso != null) || (this.idaviso != null && !this.idaviso.equals(other.idaviso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inacap.entities.Aviso[ idaviso=" + idaviso + " ]";
    }
    
}
