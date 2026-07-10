package br.ufpb.dcx.jezrel.turismo;

public class AtrativoNaoExisteException extends RuntimeException {
    public AtrativoNaoExisteException(String message) {
        super(message);
    }
}
