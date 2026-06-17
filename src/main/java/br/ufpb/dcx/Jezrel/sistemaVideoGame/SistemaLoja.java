package br.ufpb.dcx.Jezrel.sistemaVideoGame;

import java.util.HashMap;
import java.util.Map;

public class SistemaLoja {

    private Map<Integer, VideoGame> jogos = new HashMap<>();


    public void salvarJogos() {
        GravadorVideoGame gravador = new GravadorVideoGame();
        for(VideoGame v : this.jogos.values()) {
            gravador.gravarJogo(v);
        }
    }

    public void recuperarDados() {
        Map<Integer, VideoGame> jogos = new HashMap<>();


    }
}