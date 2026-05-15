package br.ufpb.dcx.Jezrel.amigosecreto;

import java.util.Scanner;
public class TestaSistemaAmigoGUI {

    public static void main(String[] args) {

        SistemaAmigo sistema = new SistemaAmigo();
        Scanner leitor = new Scanner(System.in);

        System.out.println("Quantos amigos vão participar da brincadeira?");
        int quantidadeAmigos = leitor.nextInt();
        leitor.nextLine();
        for(int k = 0; k < quantidadeAmigos; k++) {
            System.out.println("Digite o nome do " + (k+1) + " amigo");
            String nome = leitor.nextLine();
            System.out.println("Digite o email do " + (k+1) + " amigo");
            String emailAmigo = leitor.nextLine();
            sistema.cadastrarAmigo(nome, emailAmigo);
        }

        for(int i = 0; i < quantidadeAmigos; i++) {
            System.out.println("Digite o email da pessoa que sorteou o amigo secreto.");
            String emailAmigo = leitor.nextLine();
            System.out.println("Digite o email do amigo sorteado.");
            String emailAmigoSorteado = leitor.nextLine();
            try {
                sistema.configuraAmigoSecretoDe(emailAmigo, emailAmigoSorteado);
            } catch(AmigoInexistenteException o) {
                System.out.println(o.getMessage());
            }
        }

        System.out.println("Enviando mensagem...");
        System.out.println("Digite o email do remetente");
        String emailRemetente = leitor.nextLine();
        System.out.println("Digite o texto da mensagem");
        String texto = leitor.nextLine();
        System.out.println("Digite '1' se a mensagem for anônima e '2' se a mensagem não for anônima");
        int opcao = leitor.nextInt();
        boolean anonima = false;
        if(opcao == 1)
            anonima = true;
        else
            anonima = false;

        sistema.enviarMensagemParaTodos(emailRemetente, texto, anonima);
        leitor.close();
    }

}