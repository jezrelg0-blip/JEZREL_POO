package br.ufpb.dcx.Jezrel.sistemaVideoGame;

import java.util.Collection;
public class TestaSistemaLojaMap {

    public static void main(String[] args) {
        SistemaLoja sistema = new SistemaLoja();

        try {
            sistema.cadastrarJogo("Minecraft", 111, 90.0);
            sistema.cadastrarJogo("Super Mario Bros 2", 222, 60.0);
            sistema.cadastrarJogo("Pokémon Sword and Shield", 333, 400.0);
            sistema.salvarJogos();

            sistema.removerJogo(333);

            sistema.cadastrarJogo("The Legend of Zelda: Breath of the Wild", 444, 400.0);
            System.out.println(sistema.pesquisarJogo(111).getNome());
            Collection<VideoGame> jogosCaros = sistema.pesquisarJogosComPrecoMaiorQue(70);

            System.out.println("Jogos caros:");
            for(VideoGame v : jogosCaros) {
                System.out.println(v.getNome());
            }

            sistema.recuperarDados();
            Collection<VideoGame> jogosCaros2 = sistema.pesquisarJogosComPrecoMaiorQue(70);

            System.out.println("Jogos caros:");
            for(VideoGame v : jogosCaros2) {
                System.out.println(v.getNome());
            }


        } catch(JogoJaCadastradoException| JogoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }

    }

}