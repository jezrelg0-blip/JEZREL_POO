package br.ufpb.dcx.Jezrel.sistemaVideoGame;

public class TestaSistemaLojaLista {


    public static void main(String[] args) {

        JogosLista sistema = new JogosLista();

        VideoGame Minecraft = new VideoGame("Minecraft", 134, 100);
        VideoGame ZeldaBoTW = new VideoGame("The legend of Zelda: Breath of the Wild", 135, 400);


        try {
            sistema.cadastrarJogo(Minecraft);
            sistema.cadastrarJogo(ZeldaBoTW);
            sistema.cadastrarJogo(Minecraft);

        } catch(Exception JogoJaCadastrado) {

            System.out.println("Erro: " + JogoJaCadastrado.getMessage());

        }

        System.out.println("Jogos triplo A cadastrados no sistema");
        for (VideoGame jogo : sistema.getListaJogos()) {

            if(jogo.ehAAA()) {

                System.out.println(jogo.toString());

            }
        }
    }
}
