package br.ufpb.dcx.Jezrel.amigosecreto;

public class TestaSistemaAmigo {

    public static void main(String[] args) {

        SistemaAmigo sistema = new SistemaAmigo();

        sistema.cadastrarAmigo("José", "jose0@gmail.com");
        sistema.cadastrarAmigo("Maria", "maria0@gmail.com");

        try {
            sistema.configuraAmigoSecretoDe("jose0@gmail.com", "maria0@gmail.com");
            sistema.configuraAmigoSecretoDe("maria0@gmail.com", "jose0@gmail.com");
        } catch (AmigoInexistenteException o) {
            System.out.println(o.getMessage());
        }

        sistema.enviarMensagemParaAlguem("kkk otário", "maria0@gmail.com","jose0@gmail.com", true );
        sistema.enviarMensagemParaTodos("Nextage bb", "maria0@gmail.com", true);

        for(Mensagem m : sistema.pesquisaMensagensAnonimas()) {
            System.out.println(m.getTextoCompletoAExibir());
        }

        try {
            if (sistema.pesquisaAmigoSecretoDe("jose0@gmail.com").equals("maria0@gmail.com"))
                System.out.println("Ok");
        } catch(AmigoNaoSorteadoException o) {
            System.out.println(o.getMessage());
        } catch(AmigoInexistenteException o) {
            System.out.println(o.getMessage());
        }

    }

}
