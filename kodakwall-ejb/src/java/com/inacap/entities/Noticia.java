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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ZALO
 */
@Entity
@Table(name = "noticia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Noticia.findAll", query = "SELECT n FROM Noticia n")
    , @NamedQuery(name = "Noticia.findByIdnoticia", query = "SELECT n FROM Noticia n WHERE n.idnoticia = :idnoticia")
    , @NamedQuery(name = "Noticia.findByFecha", query = "SELECT n FROM Noticia n WHERE n.fecha = :fecha")
    , @NamedQuery(name = "Noticia.findByDescripcion", query = "SELECT n FROM Noticia n WHERE n.descripcion = :descripcion")})
public class Noticia implements Serializable {

    @Size(max = 10)
    @Column(name = "fecha")
    private String fecha;
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnoticia")
    private Integer idnoticia;
    @JoinColumn(name = "Usuario_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuarioidUsuario;

    public Noticia() {
    }

    public Noticia(Integer idnoticia) {
        this.idnoticia = idnoticia;
    }

    public Integer getIdnoticia() {
        return idnoticia;
    }

    public void setIdnoticia(Integer idnoticia) {
        this.idnoticia = idnoticia;
    }


    public Usuario getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(Usuario usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnoticia != null ? idnoticia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Noticia)) {
            return false;
        }
        Noticia other = (Noticia) object;
        if ((this.idnoticia == null && other.idnoticia != null) || (this.idnoticia != null && !this.idnoticia.equals(other.idnoticia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inacap.entities.Noticia[ idnoticia=" + idnoticia + " ]";
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
