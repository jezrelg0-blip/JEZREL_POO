package br.ufpb.dcx.Jezrel.amigosecreto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class SistemaAmigoMap {

    private Map<String, Mensagem> mensagens = new HashMap<>();
    private Map<String, Amigo> amigos = new HashMap<>();

    public Map<String, String> getMensagens() {
        return mensagens;
    }

    public Map<String, Amigo> getAmigos() {
        return amigos;
    }

    public void cadastrarAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException {
        if (this.amigos.containsKey(emailAmigo)) {
            throw new AmigoJaExisteException ("Esse amigo já está cadastrado no sistema");
        }
        else {
            amigos.put(emailAmigo, new Amigo(nomeAmigo, emailAmigo, null));
        }
    }

    public Amigo pesquisaAmigo(String emailAmigo) {
        return this.amigos.get(emailAmigo);
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> mensagensAnonimas = new ArrayList<>();
        for(Mensagem m : this.mensagens.values()){
            if (m.ehAnonima()) {
            }
                mensagensAnonimas.add(m);
            }
        return mensagensAnonimas;
        }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) {

    }

}