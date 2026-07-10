package br.ufpb.dcx.Jezrel.turismo;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class SistemaAtrativosMap implements SistemaAtrativos{

    private Map<String, AtrativoTuristico> atrativos;

    public SistemaAtrativosMap() {
        this.atrativos = new HashMap<>();
    }

    public SistemaAtrativosMap(Map<String, AtrativoTuristico> atrativos) {
        this.atrativos = atrativos;
    }

    public boolean cadastraAtrativo(AtrativoTuristico atrativo) throws AtrativoJaExisteException {
        if(this.atrativos.containsValue(atrativo)) {
            throw new AtrativoJaExisteException("Já existe um atrativo cadastrado com esse nome no sistema");
        }
        else {
            atrativos.put(atrativo.getNome(), atrativo);
            return true;
        }
    }

    public boolean cadastraAtrativo(String nome, String descricao, TipoAtrativo tipo) throws AtrativoJaExisteException{
        if(this.atrativos.containsKey(nome)) { throw new AtrativoJaExisteException("Já existe um atrativo cadastrado com esse nome no sistema");}
        atrativos.put(nome, new AtrativoTuristico(nome, descricao, tipo, null));
        return true;
    }

    public boolean removeAtrativo(AtrativoTuristico atrativo) throws AtrativoNaoExisteException{
        if(this.atrativos.containsValue(atrativo)) {
            atrativos.remove(atrativo.getNome());
            return true;
        }
        else {
            throw new AtrativoNaoExisteException("O atrativo não foi encontrado");
        }
    }

    public boolean removeAtrativo(String nome) throws AtrativoNaoExisteException{
        if(this.atrativos.containsKey(nome)) {
            atrativos.remove(nome);
            return true;
        }
        else {
            throw new AtrativoNaoExisteException("Não foi encontrado nenhum atrativo com esse nome");
        }
    }

    public AtrativoTuristico pesquisaAtrativo(String nome) throws AtrativoNaoExisteException {
        if(this.atrativos.containsKey(nome)) {
            return this.atrativos.get(nome);
        }
        else {
            throw new AtrativoNaoExisteException("Não há nenhum atrativo com esse nome cadastrado no sistema");
        }
    }

    public List<AtrativoTuristico> pesquisaAtrativosDoTipo(TipoAtrativo tipoAtrativo) {
        List<AtrativoTuristico> listaAtrativos = new ArrayList<>();
        for(AtrativoTuristico a : this.atrativos.values()) {
            if(a.ehDoTipo(tipoAtrativo)) {
                listaAtrativos.add(a);
            }
        }
        return listaAtrativos;
    }

    public List<String> pesquisaSitesComMaisInformacoesSobreAtrativo(String nome) throws AtrativoNaoExisteException {
        return this.atrativos.get(nome).getSitesParaMaisInfo();
    }

    public int contaAtrativosDoTipo(TipoAtrativo tipoAtrativo) {
        int contador = 0;
        for(AtrativoTuristico a : this.atrativos.values()) {
            if(a.getTipo().equals(tipoAtrativo)) {
                contador++;
            }
        }
        return contador;
    }

    public boolean existeAtrativo(String nome) {
        return this.atrativos.containsKey(nome);
    }
}
