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
 * @author ZALO
 */
@Entity
@Table(name = "tipo_de_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDeUsuario.findAll", query = "SELECT t FROM TipoDeUsuario t")
    , @NamedQuery(name = "TipoDeUsuario.findByIdtipoDeUsuario", query = "SELECT t FROM TipoDeUsuario t WHERE t.idtipoDeUsuario = :idtipoDeUsuario")
    , @NamedQuery(name = "TipoDeUsuario.findByDescripcion", query = "SELECT t FROM TipoDeUsuario t WHERE t.descripcion = :descripcion")})
public class TipoDeUsuario implements Serializable {

    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipo_de_usuario")
    private Integer idtipoDeUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDeUsuarioIdtipoDeUsuario")
    private List<Usuario> usuarioList;

    public TipoDeUsuario() {
    }

    public TipoDeUsuario(Integer idtipoDeUsuario) {
        this.idtipoDeUsuario = idtipoDeUsuario;
    }

    public Integer getIdtipoDeUsuario() {
        return idtipoDeUsuario;
    }

    public void setIdtipoDeUsuario(Integer idtipoDeUsuario) {
        this.idtipoDeUsuario = idtipoDeUsuario;
    }


    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoDeUsuario != null ? idtipoDeUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDeUsuario)) {
            return false;
        }
        TipoDeUsuario other = (TipoDeUsuario) object;
        if ((this.idtipoDeUsuario == null && other.idtipoDeUsuario != null) || (this.idtipoDeUsuario != null && !this.idtipoDeUsuario.equals(other.idtipoDeUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inacap.entities.TipoDeUsuario[ idtipoDeUsuario=" + idtipoDeUsuario + " ]";
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
