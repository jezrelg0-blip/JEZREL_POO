package br.ufpb.dcx.jezrel.sistemaVideoGame;

import java.util.*;


public class SistemaLoja {

    private Map<Integer, VideoGame> jogos = new HashMap<>();
    public static final String NOME_ARQUIVO = "arquivo.txt";


    public void salvarJogos() {
        GravadorVideoGame gravador = new GravadorVideoGame(NOME_ARQUIVO);
        gravador.gravarJogos((HashMap<Integer, VideoGame>)this.jogos);
    }

    public void recuperarDados() {
        GravadorVideoGame leitor = new GravadorVideoGame(NOME_ARQUIVO);
        this.jogos = leitor.ler(NOME_ARQUIVO);
    }

    public void cadastrarJogo(String nome, int codigo, double preco) throws JogoJaCadastradoException{
        if(this.jogos.containsKey(codigo)) {
            throw new JogoJaCadastradoException("Já existe um jogo cadastrado com esse código no sistema");
        }
        VideoGame jogo = new VideoGame(nome, codigo, preco);
        this.jogos.put(codigo, jogo);
    }

    public VideoGame pesquisarJogo(int codigo) throws JogoNaoEncontradoException{
        if(this.jogos.containsKey(codigo)) {
            return this.jogos.get(codigo);
        }
        else {
            throw new JogoNaoEncontradoException("Não há um jogo cadastrado com esse código no sistema");
        }
    }

    public Collection<VideoGame> pesquisarJogosComPrecoMaiorQue(double preco) {
        List<VideoGame> listaJogos = new ArrayList<>();
        for(VideoGame v : this.jogos.values()) {
            if(v.getPreco() >= preco) {
                listaJogos.add(v);
            }
        }
        return listaJogos;
    }

    public void removerJogo(int codigo) throws JogoNaoEncontradoException{
        if(this.jogos.containsKey(codigo)) {
            this.jogos.remove(codigo);
        }
        else {
            throw new JogoNaoEncontradoException("Não há um jogo cadastrado com esse código no sistema");
        }
    }

}