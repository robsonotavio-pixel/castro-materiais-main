

package com.castromateriais.castro_materiais.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pedidos")

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "data")
    private String data;

    @Column(name = "valor_total")
    private double valorTotal;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Pedido() {

    }

    public void setId(long id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public long getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public Cliente getCliente(){
        return cliente;
    }
}
