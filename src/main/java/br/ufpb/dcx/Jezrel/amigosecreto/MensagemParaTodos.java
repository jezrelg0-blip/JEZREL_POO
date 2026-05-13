package br.ufpb.dcx.Jezrel.amigosecreto;

public class MensagemParaTodos extends Mensagem{

    public MensagemParaTodos(String texto, String emailRemetente, boolean anonima) {
        super(texto, emailRemetente, anonima);
    }

    public String getTextoCompletoAExibir() {
        return String.format("Mensagem de %s para todos. Texto: %s", getEmailRemetente(), getTexto());
    }
}
