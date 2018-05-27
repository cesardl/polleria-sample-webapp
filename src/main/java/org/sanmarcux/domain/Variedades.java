/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sanmarcux.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author cesardl
 */
public class Variedades implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idVariedad;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Carta carta;
    private Collection<DetalleCompra> detalleCompraCollection;

    public Variedades() {
    }

    public Variedades(Integer idVariedad) {
        this.idVariedad = idVariedad;
    }

    public Integer getIdVariedad() {
        return idVariedad;
    }

    public void setIdVariedad(Integer idVariedad) {
        this.idVariedad = idVariedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public Collection<DetalleCompra> getDetalleCompraCollection() {
        return detalleCompraCollection;
    }

    public void setDetalleCompraCollection(Collection<DetalleCompra> detalleCompraCollection) {
        this.detalleCompraCollection = detalleCompraCollection;
    }

    @Override
    public String toString() {
        return "org.sanmarcux.domain.Variedades[idVariedad=" + idVariedad + "]";
    }
}
