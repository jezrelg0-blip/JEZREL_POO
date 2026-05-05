package jezrel.poo;

import java.util.Objects;

public class VideoGame
{

    private String nome;
    private double preco;

    public VideoGame()
    {

        this.nome = null;
        this.preco = 0;

    }

    public VideoGame(String nome, double preco)
    {

        this.nome = nome;
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

        return getPreco() > 350;

    }

}
