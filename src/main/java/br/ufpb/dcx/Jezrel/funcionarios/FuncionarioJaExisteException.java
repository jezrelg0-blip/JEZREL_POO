package br.ufpb.dcx.Jezrel.funcionarios;

public class FuncionarioJaExisteException extends RuntimeException {
    public FuncionarioJaExisteException(String message) {
        super(message);
    }
}
