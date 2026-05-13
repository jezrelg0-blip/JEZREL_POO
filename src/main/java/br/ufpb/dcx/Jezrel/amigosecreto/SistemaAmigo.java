package br.ufpb.dcx.Jezrel.amigosecreto;

import java.util.List;
import java.util.ArrayList;
public class SistemaAmigo {

    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public List<Mensagem> pesquisaMensagensAnonimas() {

        List<Mensagem> mensagensAnonimas = new ArrayList<>();
        for(Mensagem m: mensagens) {
            if(m.ehAnonima())
                mensagensAnonimas.add(m);
        }
    return mensagensAnonimas;

    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        boolean pessoaEncontrada = false;
        boolean amigoSorteadoEncontrado = false;
        int posicaoListaAmigo = 0;

        for(Amigo a: amigos) {
            if(a.getEmail().equals(emailDaPessoa)) {
                pessoaEncontrada = true;
                posicaoListaAmigo = amigos.indexOf(a);
            }
            if(a.getEmailAmigoSorteado().equals(emailAmigoSorteado))
                amigoSorteadoEncontrado = true;
        }

        if(pessoaEncontrada && amigoSorteadoEncontrado)
            amigos.get(posicaoListaAmigo).setEmailAmigoSorteado(emailAmigoSorteado);
        else {
            throw new AmigoInexistenteException ("Algum dos emails inseridos não está associado à nenhum amigo cadastrado");
        }
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return this.mensagens;
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        for(Amigo a: amigos) {
            if(a.getEmail().equals(emailDaPessoa)) {
                if(a.getEmailAmigoSorteado() != null)
                    return a.getEmailAmigoSorteado();
                else {
                    throw new AmigoNaoSorteadoException("Esta pessoa ainda não sorteou seu amigo secreto");
                }
            }
        }

        throw new AmigoInexistenteException("Esta pessoa não está cadastrada como participante");
    }
}