package br.ufpb.dcx.Jezrel.amigosecreto;

public class MensagemParaAlguem extends Mensagem {

    private String emailDestinatario;

    public MensagemParaAlguem(String texto, String emailRemetente, boolean anonima, String emailDestinatario) {
        super(texto, emailRemetente, anonima);
        this.emailDestinatario = emailDestinatario;
    }

    public String getEmailDestinatario() {
        return this.emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public String getTextoCompletoAExibir() {
        if(ehAnonima())
            return String.format("Mensagem anônima para %s. Texto: %s", this.emailDestinatario, getTexto());
        else
            return String.format("Mensagem de %s para %s. Texto: %s", getEmailRemetente(), getEmailDestinatario(), getTexto());
    }

}