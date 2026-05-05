package jezrel.poo;

public class SistemaLoja {


    public static void main(String[] args) {

        JogosLista sistema = new JogosLista();

        VideoGame Minecraft = new VideoGame("Minecraft", 100);
        VideoGame ZeldaBoTW = new VideoGame("The legend of Zelda: Breath of the Wild", 400);

        sistema.cadastrarJogo(Minecraft);
        sistema.cadastrarJogo(ZeldaBoTW);
        sistema.cadastrarJogo(Minecraft);

        System.out.println("Jogos triplo A cadastrados no sistema");
        for (VideoGame jogo : sistema.listaJogos) {

            if(jogo.ehAAA()) {

                jogo.toString();

            }
        }
    }
}
