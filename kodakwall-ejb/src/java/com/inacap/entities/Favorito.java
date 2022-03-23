/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inacap.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ZALO
 */
@Entity
@Table(name = "favorito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Favorito.findAll", query = "SELECT f FROM Favorito f")
    , @NamedQuery(name = "Favorito.findByIdfavorito", query = "SELECT f FROM Favorito f WHERE f.idfavorito = :idfavorito")
    , @NamedQuery(name = "Favorito.findByEstado", query = "SELECT f FROM Favorito f WHERE f.estado = :estado")})
public class Favorito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfavorito")
    private Integer idfavorito;
    @Column(name = "estado")
    private Short estado;
    @JoinColumn(name = "Usuario_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuarioidUsuario;
    @JoinColumn(name = "aviso_idaviso", referencedColumnName = "idaviso")
    @ManyToOne(optional = false)
    private Aviso avisoIdaviso;

    public Favorito() {
    }

    public Favorito(Integer idfavorito) {
        this.idfavorito = idfavorito;
    }

    public Integer getIdfavorito() {
        return idfavorito;
    }

    public void setIdfavorito(Integer idfavorito) {
        this.idfavorito = idfavorito;
    }

    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
    }

    public Usuario getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(Usuario usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    public Aviso getAvisoIdaviso() {
        return avisoIdaviso;
    }

    public void setAvisoIdaviso(Aviso avisoIdaviso) {
        this.avisoIdaviso = avisoIdaviso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfavorito != null ? idfavorito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Favorito)) {
            return false;
        }
        Favorito other = (Favorito) object;
        if ((this.idfavorito == null && other.idfavorito != null) || (this.idfavorito != null && !this.idfavorito.equals(other.idfavorito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inacap.entities.Favorito[ idfavorito=" + idfavorito + " ]";
    }
    
}
