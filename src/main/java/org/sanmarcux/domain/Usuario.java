/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sanmarcux.domain;

import java.io.Serializable;

/**
 * @author cesardl
 */
public class Usuario implements Serializable {

    private static final long serialVersionUID = 337603119890405695L;

    public static final String ID_USUARIO = "idUsuario";
    public static final String USUARIO = "usuario";
    public static final String NOMBRES = "nombres";
    public static final String APELLIDOS = "apellidos";
    public static final String CLAVE = "clave";
    public static final String DNI = "dni";
    public static final String DIRECCION = "direccion";
    public static final String TELEFONO_FIJO = "telefonoFijo";
    public static final String TELEFONO_MOVIL = "telefonoMovil";
    public static final String CONFIRMADO = "confirmado";

    private final Integer idUsuario;
    private final String usuario;
    private final String nombres;
    private final String apellidos;
    private final String clave;
    private final String dni;
    private final String direccion;
    private final String telefonoFijo;
    private final String telefonoMovil;
    private final String confirmado;

    public static class Builder {
        private Integer idUsuario;
        private String usuario;
        private String nombres;
        private String apellidos;
        private String clave;
        private String dni;
        private String direccion;
        private String telefonoFijo;
        private String telefonoMovil;
        private String confirmado;

        public Builder idUsuario(Integer val) {
            idUsuario = val;
            return this;
        }

        public Builder usuario(String val) {
            usuario = val;
            return this;
        }

        public Builder nombres(String val) {
            nombres = val;
            return this;
        }

        public Builder apellidos(String val) {
            apellidos = val;
            return this;
        }

        public Builder clave(String val) {
            clave = val;
            return this;
        }

        public Builder dni(String val) {
            dni = val;
            return this;
        }

        public Builder direccion(String val) {
            direccion = val;
            return this;
        }

        public Builder telefonoFijo(String val) {
            telefonoFijo = val;
            return this;
        }

        public Builder telefonoMovil(String val) {
            telefonoMovil = val;
            return this;
        }

        public Builder confirmado(String val) {
            confirmado = val;
            return this;
        }

        public Usuario build() {
            return new Usuario(this);
        }
    }

    private Usuario(Builder builder) {
        idUsuario = builder.idUsuario;
        usuario = builder.usuario;
        nombres = builder.nombres;
        apellidos = builder.apellidos;
        clave = builder.clave;
        dni = builder.dni;
        direccion = builder.direccion;
        telefonoFijo = builder.telefonoFijo;
        telefonoMovil = builder.telefonoMovil;
        confirmado = builder.confirmado;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getClave() {
        return clave;
    }

    public String getDni() {
        return dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public String getConfirmado() {
        return confirmado;
    }

    @Override
    public String toString() {
        return "org.sanmarcux.domain.Usuario[idUsuario=" + idUsuario + "]";
    }
}
