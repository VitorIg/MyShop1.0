package com.example.myappbrq.Modelo;

public class Produto implements Cloneable {
    private int id;
    private String categoria;
    private String nome;
    private String codigo;
    private String quantidade;
    private String descricao;
    private String marca;
    private String custo;
    private String venda;




    public Produto(String categoria, String nome){
        this.categoria = categoria;
        this.nome = nome;
    }

    public Produto(int id, String nome, String categoriao){
        this.id = id;
        this.categoria = categoria;
        this.nome = nome;
    }

    public Produto (String categoria, String nome, String codigo, String quantidade, String descricao,
                    String marca, String custo, String venda){
        this.categoria = categoria;
        this.nome = nome;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.marca = marca;
        this.custo = custo;
        this.venda = venda;

    }

    public Produto (int id, String categoria, String nome, String codigo, String quantidade,
                    String descricao, String marca, String custo, String venda){
        this.id = id;
        this.categoria = categoria;
        this.nome = nome;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.marca = marca;
        this.custo = custo;
        this.venda = venda;
    }

    public Produto(Produto p){
        this.id = p.id;
        this.categoria = p.categoria;
        this.nome = p.nome;
        this.codigo = p.codigo;
        this.quantidade = p.quantidade;
        this.descricao = p.descricao;
        this.marca = p.marca;
        this.custo = p.custo;
        this.venda = p.venda;
    }



    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getQuantidade() {
        return this.quantidade;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setCusto(String custo) {
        this.custo = custo;
    }

    public String getCusto() {
        return this.custo;
    }

    public void setVenda(String venda) {
        this.venda = venda;
    }

    public String getVenda() {
        return this.venda;
    }

    @Override
    public Object clone(){
        Produto clone = new Produto(this);
        return clone;
    }
}