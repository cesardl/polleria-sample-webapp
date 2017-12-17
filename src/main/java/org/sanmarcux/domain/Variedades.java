/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sanmarcux.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * @author cesardl
 */
@Entity
@Table(name = "variedades", catalog = "polleria", schema = "")
@NamedQueries({
        @NamedQuery(name = "Variedades.findAll", query = "SELECT v FROM Variedades v"),
        @NamedQuery(name = "Variedades.findByIdVariedad", query = "SELECT v FROM Variedades v WHERE v.idVariedad = :idVariedad"),
        @NamedQuery(name = "Variedades.findByNombre", query = "SELECT v FROM Variedades v WHERE v.nombre = :nombre"),
        @NamedQuery(name = "Variedades.findByDescripcion", query = "SELECT v FROM Variedades v WHERE v.descripcion = :descripcion"),
        @NamedQuery(name = "Variedades.findByPrecio", query = "SELECT v FROM Variedades v WHERE v.precio = :precio")})
public class Variedades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_variedad", nullable = false)
    private Integer idVariedad;
    @Column(name = "Nombre", length = 50)
    private String nombre;
    @Column(name = "descripcion", length = 100)
    private String descripcion;
    @Column(name = "precio", precision = 22)
    private Double precio;
    @JoinColumn(name = "id_carta", referencedColumnName = "id_carta", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Carta carta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVariedad", fetch = FetchType.LAZY)
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
    public int hashCode() {
        int hash = 0;
        hash += (idVariedad != null ? idVariedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Variedades)) {
            return false;
        }
        Variedades other = (Variedades) object;
        return !((this.idVariedad == null && other.idVariedad != null) || (this.idVariedad != null && !this.idVariedad.equals(other.idVariedad)));
    }

    @Override
    public String toString() {
        return "org.sanmarcux.domain.Variedades[idVariedad=" + idVariedad + "]";
    }
}
