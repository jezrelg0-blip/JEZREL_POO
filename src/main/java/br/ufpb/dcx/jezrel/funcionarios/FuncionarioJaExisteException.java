package br.ufpb.dcx.jezrel.funcionarios;

public class FuncionarioJaExisteException extends RuntimeException {
    public FuncionarioJaExisteException(String message) {
        super(message);
    }
}
