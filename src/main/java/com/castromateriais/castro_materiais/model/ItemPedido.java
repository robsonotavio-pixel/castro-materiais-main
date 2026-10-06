
package com.castromateriais.castro_materiais.model;

import jakarta.persistence.*;

@Entity
@Table (name = "intens_pedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column (name = "quantidade")
    private int quantidade;

    @ManyToOne
    @JoinColumn (name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn (name = "material_id")
    private Material material;

    public ItemPedido() {

    }

    public void setId(long id) {
        this.id = id;

    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPedido( Pedido pedido){
        this.pedido = pedido;
    } 
    public void setMaterial( Material material) {
        this.material = material;
    }

    public long getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public Pedido getPedido() {
        return pedido;
    }
    public Material getMaterial(){
        return material;
    }
}
