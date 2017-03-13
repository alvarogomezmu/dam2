/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repaso2;

/**
 *
 * @author Alvaro
 */
public class Pedido {

    // código, descripción, fecha pedido, email contacto, telefonocliente., código_cliente
    public Integer codigo;
    public String descripcion;
    public Integer fechaPedido;
    public String emailContacto;
    public Integer telefonoCliente;
    public Integer codigoCliente;

    public void nuevoPedido(Integer cod, String desc, Integer fechPed, String eContacto, Integer telfCliente, Integer codCliente) {
        codigo = cod;
        descripcion = desc;
        fechaPedido = fechPed;
        emailContacto = eContacto;
        telefonoCliente = telfCliente;
        codigoCliente = codCliente;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Integer fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getEmailContacto() {
        return emailContacto;
    }

    public void setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }

    public Integer getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(Integer telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    @Override
    public String toString() {
        return "Pedido{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", fechaPedido=" + fechaPedido + ", emailContacto=" + emailContacto + ", telefonoCliente=" + telefonoCliente + ", codigoCliente=" + codigoCliente + '}';
    }

}
