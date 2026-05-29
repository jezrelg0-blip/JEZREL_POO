package jezrel.poo;

import java.io.*;
public class GravadorVideoGame {

    public static final String NOME_ARQUIVO = "videogames.txt";

    public <o extends Serializable> boolean gravarjogo(Object o) {
        try {
            ObjectOutputStream gravador = new ObjectOutputStream(new FileOutputStream(NOME_ARQUIVO));
            gravador.writeObject(o);
            return true;
        } catch (IOException e) {
            System.err.println("Erro ao gravar objeto: " + (e.getMessage()));
            return false;
        }
    }

    public <o extends Serializable> o ler(String nomeArquivo) {
        try {
            ObjectInputStream leitor = new ObjectInputStream(new FileInputStream(nomeArquivo));
            return (o) leitor.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao ler objeto: " + (e.getMessage()));
            return null;
        }
    }

}