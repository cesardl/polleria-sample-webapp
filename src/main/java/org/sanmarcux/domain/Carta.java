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
@Table(name = "carta", catalog = "polleria", schema = "")
@NamedQueries({
        @NamedQuery(name = "Carta.findAll", query = "SELECT c FROM Carta c"),
        @NamedQuery(name = "Carta.findByIdCarta", query = "SELECT c FROM Carta c WHERE c.idCarta = :idCarta"),
        @NamedQuery(name = "Carta.findByVariedad", query = "SELECT c FROM Carta c WHERE c.variedad = :variedad")})
public class Carta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_carta", nullable = false)
    private Integer idCarta;
    @Column(name = "variedad", length = 50)
    private String variedad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carta", fetch = FetchType.EAGER)
    private Collection<Variedades> variedadesCollection;

    public Carta() {
    }

    public Carta(Integer idCarta) {
        this.idCarta = idCarta;
    }

    public Integer getIdCarta() {
        return idCarta;
    }

    public void setIdCarta(Integer idCarta) {
        this.idCarta = idCarta;
    }

    public String getVariedad() {
        return variedad;
    }

    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }

    public Collection<Variedades> getVariedadesCollection() {
        return variedadesCollection;
    }

    public void setVariedadesCollection(Collection<Variedades> variedadesCollection) {
        this.variedadesCollection = variedadesCollection;
    }

    public int getTotalVariedadesCollection() {
        return this.variedadesCollection == null ? 0
                : this.variedadesCollection.size();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarta != null ? idCarta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carta)) {
            return false;
        }
        Carta other = (Carta) object;
        if ((this.idCarta == null && other.idCarta != null) || (this.idCarta != null && !this.idCarta.equals(other.idCarta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.sanmarcux.domain.Carta[idCarta=" + idCarta + "]";
    }
}
