package jezrel.poo;

import java.util.List;
import java.util.ArrayList;

public class JogosLista {

    protected List<VideoGame> listaJogos;

    public JogosLista() {

        this.listaJogos = new ArrayList<>();

    }

    public JogosLista(List listaJogos) {

        this.listaJogos = listaJogos;

    }

    public void cadastrarJogo(VideoGame jogo) throws jogoJaCadastradoException {

        for (VideoGame j : this.listaJogos) {

            if (j.equals(jogo)) {

                throw new jogoJaCadastradoException("O jogo já esta cadastrado no sistema");

            }
        }

        this.listaJogos.add(jogo);

    }
}