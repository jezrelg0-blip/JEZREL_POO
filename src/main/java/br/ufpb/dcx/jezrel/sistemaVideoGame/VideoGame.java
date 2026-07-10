package br.ufpb.dcx.jezrel.sistemaVideoGame;

import java.io.Serializable;
import java.util.Objects;

public class VideoGame implements Serializable
{
    private String nome;
    private int codigo;
    private double preco;

    public VideoGame()
    {

        this.nome = null;
        this.preco = 0;

    }

    public VideoGame(String nome,int codigo, double preco)
    {

        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;

    }

    public String getNome()
    {

        return this.nome;

    }

    public void setNome(String nome)
    {

        this.nome = nome;

    }

    public double getPreco()
    {

        return this.preco;

    }

    public void setPreco(double preco)
    {

        this.preco = preco;

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString()
    {

        return ("Nome: " + (this.nome) + "| Preço: " + (this.preco));

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        VideoGame videoGame = (VideoGame) o;
        return Objects.equals(nome, videoGame.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

    public boolean ehAAA()
    {

        return getPreco() >= 350;

    }

}