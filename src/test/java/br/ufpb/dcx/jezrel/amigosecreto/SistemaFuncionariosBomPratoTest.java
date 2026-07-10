package br.ufpb.dcx.jezrel.amigosecreto;

import br.ufpb.dcx.jezrel.funcionarios.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaFuncionariosBomPratoTest {

    @Test
    public void testaCadastroEPesquisa() {
        SistemaFuncionariosBomPrato sistema = new SistemaFuncionariosBomPrato();
        try {
            sistema.cadastrarFuncionario(new Funcionario("333.333.333-33", "Ayla Rebouças", TipoFuncionario.GERENTE, 3000));
            assertTrue(sistema.funcionarioJaExiste("333.333.333-33"));
            Funcionario f1 = sistema.pesquisarFuncionario("333.333.333-33");
            sistema.cadastrarFuncionario("222.222.222-22", "João Paulo Silva", TipoFuncionario.COZINHEIRO, 5000);
            assertTrue(sistema.pesquisarFuncionariosComSalarioMaiorQue(2000).size() == 2);
            assertTrue(sistema.pesquisarFuncionariosPorTipo(TipoFuncionario.COZINHEIRO).size() == 1);
        } catch(FuncionarioJaExisteException | FuncionarioInexistenteException e) {
            fail("Não deveria lançar exceção");
        }
    }

    @Test
    public void testaCadastroEExcecoes() {

        SistemaFuncionariosBomPrato sistema = new SistemaFuncionariosBomPrato();
        sistema.cadastrarFuncionario("999.999.999-99", "Jezrel Gomes de Oliveira", TipoFuncionario.FAXINEIRO, 50000);
        assertTrue(sistema.funcionarioJaExiste("999.999.999-99"));
        try {
            sistema.cadastrarFuncionario("999.999.999-99", "Jezrel Gomes de Oliveira", TipoFuncionario.GARCON, 20000);
            fail("deveria lançar exceção");
        } catch (FuncionarioJaExisteException e) {
            assertTrue(e.getMessage().equals("Esse funcionário já está cadastrado no sistema"));
        }

        try {
            sistema.alterarSalarioDeFuncionario("888.888.888-88", 5000);
            fail("Deveria lançar exceção");
        } catch(FuncionarioInexistenteException e) {
            assertTrue(e.getMessage().equals("Esse funcionário não está cadastrado no sistema"));
        }

    }

}