package br.ufpb.dcx.jezrel.amigosecreto;

public class MensagemParaTodos extends Mensagem{

    public MensagemParaTodos(String texto, String emailRemetente, boolean anonima) {
        super(texto, emailRemetente, anonima);
    }

    public String getTextoCompletoAExibir() {
        if(ehAnonima())
            return String.format("Mensagem anônima para todos. Texto: %s", getTexto());
        else
            return String.format("Mensagem de %s para todos. Texto: %s", getEmailRemetente(), getTexto());
    }

}
