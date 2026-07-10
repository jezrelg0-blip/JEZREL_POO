package br.ufpb.dcx.jezrel.turismo;

import java.io.*;
import java.util.Map;

public class GravadorDeAtrativos {

    public final String nomeArquivo;

    public GravadorDeAtrativos(String nomeArquivo) {this. nomeArquivo = nomeArquivo;}

    public Map<String, AtrativoTuristico> recuperarAtrativos() throws IOException {
        try(ObjectInputStream leitor = new ObjectInputStream(new FileInputStream(nomeArquivo));){
            Object objeto = leitor.readObject();
            if(objeto instanceof Map<?, ?>) {
                Map<String, AtrativoTuristico> atrativos = (Map<String, AtrativoTuristico>) objeto;
                return atrativos;
            }
            throw new IOException("Não foi possível ler o arquivo");
        } catch(ClassNotFoundException e ) {
            throw new IOException("A classe de dados lidos não é compatível",e);
        }
    }

    public boolean gravarAtrativos(Map<String, AtrativoTuristico> atrativos) throws IOException{
        if(atrativos == null) {
                throw new IOException("Não há nenhum atrativo para salvar");
        }
        try(ObjectOutputStream gravador = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
                gravador.writeObject(atrativos);
            return true;
        }
    }
}
