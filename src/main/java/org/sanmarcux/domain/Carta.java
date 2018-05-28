/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sanmarcux.domain;

import java.util.Collection;

/**
 * @author cesardl
 */
public class Carta {

    private String keyCarta;
    private Integer idCarta;
    private String variedad;
    private Collection<Variedades> variedadesCollection;

    public Carta() {
    }

    public String getKeyCarta() {
        return keyCarta;
    }

    public void setKeyCarta(String keyCarta) {
        this.keyCarta = keyCarta;
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
    public String toString() {
        return "org.sanmarcux.domain.Carta[idCarta=" + idCarta + "]";
    }
}
