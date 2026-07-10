package br.ufpb.dcx.jezrel.funcionarios;

public class FuncionarioInexistenteException extends RuntimeException {
    public FuncionarioInexistenteException(String message) {
        super(message);
    }
}
