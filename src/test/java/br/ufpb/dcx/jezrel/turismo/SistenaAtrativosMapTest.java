package br.ufpb.dcx.jezrel.turismo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SistenaAtrativosMapTest {

    private SistemaAtrativos sistema;

    @BeforeEach
    public void setUp() {
        this.sistema = new SistemaAtrativosMap();
    }

    @Test
    public void testaCadastroPesquisaERemocao() {
        try{
            sistema.cadastraAtrativo("Pico da Neblina","Ponto mais alto do Brasil", TipoAtrativo.FORMACAO_ROCHOSA);
            sistema.cadastraAtrativo("Basílica de São Pedro", "Monumento histórico", TipoAtrativo.IGREJA);
            List<AtrativoTuristico> listaIgrejas = sistema.pesquisaAtrativosDoTipo(TipoAtrativo.IGREJA);
            List<AtrativoTuristico> listaFormacoesRochosas = sistema.pesquisaAtrativosDoTipo(TipoAtrativo.FORMACAO_ROCHOSA);
            assertEquals(1, listaIgrejas.size());
            assertEquals(1, listaFormacoesRochosas.size());
            sistema.removeAtrativo("Basílica de São Pedro");
            List<AtrativoTuristico> listaIgrejas2 = sistema.pesquisaAtrativosDoTipo(TipoAtrativo.IGREJA);
            assertEquals(1, listaIgrejas.size());
            assertEquals(0, listaIgrejas2.size());

        } catch(AtrativoJaExisteException e) {
            fail("Não deveria disparar exceção");
        }
    }

    @Test
    public void testaCadastroAtrativosDuplicadosExcecao() {
        try {
            sistema.cadastraAtrativo("Pico da Neblina", "Ponto mais alto do Brasil", TipoAtrativo.FORMACAO_ROCHOSA);
        } catch(AtrativoJaExisteException e) {
            fail("Não deveria disparar exceção,");
        }

        assertThrows(AtrativoJaExisteException.class, () -> {
            sistema.cadastraAtrativo("Pico da Neblina", "Descrição diferente", TipoAtrativo.FLORESTA_BOSQUE);
        }, "O sistema deve impedir o cadastro de um atrativo com um nome igual ao de um outro atrativo cadastrado anteriormente");
    }

}
