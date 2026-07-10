package br.ufpb.dcx.jezrel.sistemaVideoGame;

import java.util.List;
import java.util.ArrayList;

public class JogosLista {

    private List<VideoGame> listaJogos;

    public JogosLista() {

        this.listaJogos = new ArrayList<>();

    }

    public JogosLista(List listaJogos) {

        this.listaJogos = listaJogos;

    }

    public List<VideoGame> getListaJogos() {

        return this.listaJogos;

    }

    public void cadastrarJogo(VideoGame jogo) throws JogoJaCadastradoException {

        for (VideoGame j : this.listaJogos) {

            if (j.equals(jogo)) {

                throw new JogoJaCadastradoException("O jogo já esta cadastrado no sistema");

            }
        }

        this.listaJogos.add(jogo);

    }
}