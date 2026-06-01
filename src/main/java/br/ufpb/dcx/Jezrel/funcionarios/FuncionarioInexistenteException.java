package br.ufpb.dcx.Jezrel.funcionarios;

public class FuncionarioInexistenteException extends RuntimeException {
    public FuncionarioInexistenteException(String message) {
        super(message);
    }
}
