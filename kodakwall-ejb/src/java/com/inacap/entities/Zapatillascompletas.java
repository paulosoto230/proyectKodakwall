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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ZALO
 */
@Entity
@Table(name = "zapatillascompletas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zapatillascompletas.findAll", query = "SELECT z FROM Zapatillascompletas z")
    , @NamedQuery(name = "Zapatillascompletas.findByIdaviso", query = "SELECT z FROM Zapatillascompletas z WHERE z.idaviso = :idaviso")
    , @NamedQuery(name = "Zapatillascompletas.findByMarca", query = "SELECT z FROM Zapatillascompletas z WHERE z.marca = :marca")
    , @NamedQuery(name = "Zapatillascompletas.findByModelo", query = "SELECT z FROM Zapatillascompletas z WHERE z.modelo = :modelo")
    , @NamedQuery(name = "Zapatillascompletas.findByLink", query = "SELECT z FROM Zapatillascompletas z WHERE z.link = :link")
    , @NamedQuery(name = "Zapatillascompletas.findByImagen", query = "SELECT z FROM Zapatillascompletas z WHERE z.imagen = :imagen")
    , @NamedQuery(name = "Zapatillascompletas.findByFecha", query = "SELECT z FROM Zapatillascompletas z WHERE z.fecha = :fecha")
    , @NamedQuery(name = "Zapatillascompletas.findByIdfavorito", query = "SELECT z FROM Zapatillascompletas z WHERE z.idfavorito = :idfavorito")
    , @NamedQuery(name = "Zapatillascompletas.findByUsuarioidUsuario", query = "SELECT z FROM Zapatillascompletas z WHERE z.usuarioidUsuario = :usuarioidUsuario")
    , @NamedQuery(name = "Zapatillascompletas.findByAvisoIdaviso", query = "SELECT z FROM Zapatillascompletas z WHERE z.avisoIdaviso = :avisoIdaviso")
    , @NamedQuery(name = "Zapatillascompletas.findByEstado", query = "SELECT z FROM Zapatillascompletas z WHERE z.estado = :estado")})
public class Zapatillascompletas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idaviso")
    private int idaviso;
    @Size(max = 45)
    @Column(name = "marca")
    private String marca;
    @Size(max = 200)
    @Column(name = "modelo")
    private String modelo;
    @Size(max = 400)
    @Column(name = "link")
    private String link;
    @Size(max = 400)
    @Column(name = "imagen")
    private String imagen;
    @Size(max = 45)
    @Column(name = "fecha")
    private String fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idfavorito")
    private int idfavorito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Usuario_idUsuario")
    @Id
    private int usuarioidUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aviso_idaviso")
    private int avisoIdaviso;
    @Column(name = "estado")
    private Short estado;

    public Zapatillascompletas() {
    }

    public int getIdaviso() {
        return idaviso;
    }

    public void setIdaviso(int idaviso) {
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

    public int getIdfavorito() {
        return idfavorito;
    }

    public void setIdfavorito(int idfavorito) {
        this.idfavorito = idfavorito;
    }

    public int getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(int usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    public int getAvisoIdaviso() {
        return avisoIdaviso;
    }

    public void setAvisoIdaviso(int avisoIdaviso) {
        this.avisoIdaviso = avisoIdaviso;
    }

    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
    }
    
}
