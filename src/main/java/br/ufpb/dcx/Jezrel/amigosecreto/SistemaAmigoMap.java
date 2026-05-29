package br.ufpb.dcx.Jezrel.amigosecreto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class SistemaAmigoMap {

    private Map<Integer, Mensagem> mensagens = new HashMap<>();
    private Map<String, Amigo> amigos = new HashMap<>();
    private static int numeroDaMensagem = 0;


    public Map<String, Amigo> getAmigos() {
        return amigos;
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException {
        if (this.amigos.containsKey(emailAmigo)) {
            throw new AmigoJaExisteException ("Esse amigo já está cadastrado no sistema");
        }
        else {
            this.amigos.put(emailAmigo, new Amigo(nomeAmigo, emailAmigo, null));
        }
    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException {
        if (this.amigos.containsKey(emailAmigo)) {
            return this.amigos.get(emailAmigo);
        }
        else {
            throw new AmigoInexistenteException("Pessoa não encontrada no sistema.");
        }
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> mensagensAnonimas = new ArrayList<>();
        for (Mensagem m : this.mensagens.values()) {
            if (m.ehAnonima()) {
                mensagensAnonimas.add(m);
            }
        }
        return mensagensAnonimas;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        if (this.amigos.containsKey(emailDaPessoa) && this.amigos.containsKey(emailAmigoSorteado)) {
            this.amigos.get(emailDaPessoa).setEmailAmigoSorteado(emailAmigoSorteado);
        }
        else {
            throw new AmigoInexistenteException("pessoa ou amigo não encontrado no sistema.");
        }
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        List<Mensagem> lista = new ArrayList<>(this.mensagens.values());
        return lista;
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        if (this.amigos.containsKey(emailDaPessoa)) {
            if (this.amigos.get(emailDaPessoa).getEmailAmigoSorteado() != null) {
                return this.amigos.get(emailDaPessoa).getEmailAmigoSorteado();
            }
            else {
                throw new AmigoNaoSorteadoException("O amigo secreto dessa pessoa ainda não foi sorteado.");
            }
        }
        else {
            throw new AmigoInexistenteException("Amigo não encontrado.");
        }
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima) {
        this.mensagens.put(numeroDaMensagem, new MensagemParaAlguem(texto, emailRemetente, anonima, emailDestinatario));
        numeroDaMensagem++;
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean anonima) {
        this.mensagens.put(numeroDaMensagem, new MensagemParaTodos(texto, emailRemetente, anonima));
        numeroDaMensagem++;
    }
    public void sortear() throws AmigoInexistenteException{
        List<Amigo> amigosNaoSorteados = new ArrayList<>(this.amigos.values());
        for(Amigo p : this.amigos.values()) {
            int posicaoDaListaSorteada = (int)(Math.random()*amigosNaoSorteados.size());
            configuraAmigoSecretoDe(p.getEmail(), amigosNaoSorteados.get(posicaoDaListaSorteada).getEmail());
            amigosNaoSorteados.remove(posicaoDaListaSorteada);
        }
    }

}