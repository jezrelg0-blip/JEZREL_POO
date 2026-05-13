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
    }



}
