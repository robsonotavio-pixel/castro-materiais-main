
package com.castromateriais.castro_materiais.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "valor")
    private double valor;

    @Column(name = "metodo")
    private String metodo;

    @Column(name = "status")
    private String status;

    @Column(name = "data")
    private String data;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public Pagamento() {

    }

    public void setId(long id) {
        this.id = id;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    public void setPedido( Pedido pedido) {
        this.pedido = pedido;
    }

    public  long getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public String getMetodo() {
        return metodo;
    }

    public String getStatus() {
        return status;
    }

    public String getData() {
        return data;
    }

    public Cliente  getCliente() {
        return cliente;
    }
    public Pedido getPedido() {
        return pedido;
    }
}
