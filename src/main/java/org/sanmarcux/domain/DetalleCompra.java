/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sanmarcux.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author cesardl
 */
@Entity
@Table(name = "detalle_compra", catalog = "polleria", schema = "")
@NamedQueries({
        @NamedQuery(name = "DetalleCompra.findAll", query = "SELECT d FROM DetalleCompra d"),
        @NamedQuery(name = "DetalleCompra.findByIdDetalleCompra", query = "SELECT d FROM DetalleCompra d WHERE d.idDetalleCompra = :idDetalleCompra"),
        @NamedQuery(name = "DetalleCompra.findByCantidad", query = "SELECT d FROM DetalleCompra d WHERE d.cantidad = :cantidad"),
        @NamedQuery(name = "DetalleCompra.findByImporte", query = "SELECT d FROM DetalleCompra d WHERE d.importe = :importe")})
public class DetalleCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_compra", nullable = false)
    private Integer idDetalleCompra;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "importe", precision = 10, scale = 0)
    private Double importe;
    @JoinColumn(name = "id_compra", referencedColumnName = "id_compra", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Compra idCompra;
    @JoinColumn(name = "id_variedad", referencedColumnName = "id_variedad", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
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
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleCompra != null ? idDetalleCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCompra)) {
            return false;
        }
        DetalleCompra other = (DetalleCompra) object;
        if ((this.idDetalleCompra == null && other.idDetalleCompra != null) || (this.idDetalleCompra != null && !this.idDetalleCompra.equals(other.idDetalleCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.sanmarcux.domain.DetalleCompra[idDetalleCompra=" + idDetalleCompra + "]";
    }

}
