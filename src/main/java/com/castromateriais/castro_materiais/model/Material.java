
package com.castromateriais.castro_materiais.model;
  import jakarta.persistence.*;
  @Entity
  @Table(name = "materiais")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "nome")
    private String nome;

    @Column (name = "unidade")
    private String unidade;

    @Column (name = "preco")
    private double preco;

    @Column (name = "estoque")
    private int estoque;

    public Material() {

    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public String getUnidade() {
        return unidade;
    }

    public long getId() {
        return id;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }
}
