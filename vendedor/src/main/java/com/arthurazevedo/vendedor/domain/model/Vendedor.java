package com.arthurazevedo.vendedor.domain.model;

public class Vendedor {

    private Long codigo;
    private String cpfCnpj;
    private String nome;

    public Vendedor(Long codigo, String cpfCnpj, String nome) {
        this.codigo = codigo;
        this.cpfCnpj = cpfCnpj;
        this.nome = nome;
    }

    public Vendedor() {}

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
