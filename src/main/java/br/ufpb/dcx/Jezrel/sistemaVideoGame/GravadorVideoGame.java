package br.ufpb.dcx.Jezrel.sistemaVideoGame;

import java.io.*;
public class GravadorVideoGame {

    public static final String NOME_ARQUIVO = "videogames.txt";

    public <O extends Serializable> boolean gravarJogo(O o) {
        ObjectOutputStream gravador = null;

        try {
            gravador = new ObjectOutputStream(new FileOutputStream(NOME_ARQUIVO));
            gravador.writeObject(o);
            return true;
        } catch (IOException e) {
            System.err.println("Erro ao gravar objeto: " + (e.getMessage()));
            return false;
        } finally {
            if(gravador != null) {
                try {
                    gravador.close();
                } catch(IOException e) {
                    System.err.println("Erro ao fechar o arquivo" + (e.getMessage()));
                }
            }
        }
    }

    public <O extends Serializable> O ler(String nomeArquivo) {
        ObjectInputStream leitor = null;

        try {
            leitor = new ObjectInputStream(new FileInputStream(nomeArquivo));
            return (O) leitor.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao ler objeto: " + (e.getMessage()));
            return null;
        } finally {
            if(leitor != null) {
                try{
                    leitor.close();
                } catch(IOException e) {
                    System.err.println("Erro ao fechar o arquivo: " + (e.getMessage()));
                }
            }
        }
    }
}