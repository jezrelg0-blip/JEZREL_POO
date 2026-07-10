package br.ufpb.dcx.Jezrel.turismo;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class AtrativoTuristico implements Serializable {

    private String nome;
    private String descricao;
    private TipoAtrativo tipo;
    private List<String> sitesParaMaisInfo;

    public AtrativoTuristico() {
        this.nome = "";
        this.descricao = "";
        this.tipo = null;
        this.sitesParaMaisInfo = new ArrayList<>();
    }

    public AtrativoTuristico(String nome, String descricao, TipoAtrativo tipo, List<String> sitesParaMaisInfo) {
        this.nome = nome;
        this. descricao = descricao;
        this. tipo = tipo;
        this.sitesParaMaisInfo = sitesParaMaisInfo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoAtrativo getTipo() {
        return tipo;
    }

    public void setTipo(TipoAtrativo tipo) {
        this.tipo = tipo;
    }

    public List<String> getSitesParaMaisInfo() {
        return sitesParaMaisInfo;
    }

    public void setSitesParaMaisInfo(List<String> sitesParaMaisInfo) {
        this.sitesParaMaisInfo = sitesParaMaisInfo;
    }

    public boolean ehDoTipo(TipoAtrativo tipo) {
        return this.tipo.equals(tipo);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AtrativoTuristico that = (AtrativoTuristico) o;
        return Objects.equals(this.nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

    @Override
    public String toString() {
        String textoSites = (this.sitesParaMaisInfo == null) ? "Nenhum site cadastrado" : this.sitesParaMaisInfo.toString();
        return "• Nome: " + this.nome + "\n" +
                "  Descrição: " + this.descricao + "\n" +
                "  Tipo: " + this.tipo + "\n" +
                "  Sites para mais informações: " + textoSites + "\n" +
                "---------------------------------------------";
    }


}
