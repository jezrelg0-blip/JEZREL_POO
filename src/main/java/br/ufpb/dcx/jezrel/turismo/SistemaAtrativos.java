package br.ufpb.dcx.jezrel.turismo;

import java.util.List;

public interface SistemaAtrativos {

    boolean cadastraAtrativo(AtrativoTuristico Atrativo) throws AtrativoJaExisteException;
    boolean cadastraAtrativo(String nome, String descricao, TipoAtrativo tipo) throws AtrativoJaExisteException;
    boolean removeAtrativo(AtrativoTuristico atrativo);
    boolean removeAtrativo(String nome);
    AtrativoTuristico pesquisaAtrativo(String nome) throws AtrativoNaoExisteException;
    List<AtrativoTuristico> pesquisaAtrativosDoTipo(TipoAtrativo tipoAtrativo);
    List<String> pesquisaSitesComMaisInformacoesSobreAtrativo(String nome) throws AtrativoNaoExisteException;
    int contaAtrativosDoTipo(TipoAtrativo tipoAtrativo);
    boolean existeAtrativo(String nome);

}
