package com.jdenner.model;

/**
 *
 * @author Juliano
 */
public class Contato {

    private int codigo;
    private String nome;
    private String telefone;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome.trim().length() < 3){
            throw new IllegalArgumentException("Nome inválido");
        }
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if(telefone.trim().length() < 9){
            throw new IllegalArgumentException("Telefone inválido");
        }
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return getNome();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Contato) {
            return ((Contato) obj).getCodigo() == getCodigo();
        }
        return false;
    }

}
