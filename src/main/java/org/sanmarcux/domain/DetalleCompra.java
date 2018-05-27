/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sanmarcux.domain;

import java.io.Serializable;

/**
 * @author cesardl
 */
public class DetalleCompra implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idDetalleCompra;
    private Integer cantidad;
    private Double importe;
    private Compra idCompra;
    private Variedades idVariedad;

    public DetalleCompra() {
    }

    public DetalleCompra(Integer idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }

    public Integer getIdDetalleCompra() {
        return idDetalleCompra;
    }

    public void setIdDetalleCompra(Integer idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Compra getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Compra idCompra) {
        this.idCompra = idCompra;
    }

    public Variedades getIdVariedad() {
        return idVariedad;
    }

    public void setIdVariedad(Variedades idVariedad) {
        this.idVariedad = idVariedad;
    }

    @Override
    public String toString() {
        return "org.sanmarcux.domain.DetalleCompra[idDetalleCompra=" + idDetalleCompra + "]";
    }

}
