package br.ufpb.dcx.Jezrel.funcionarios;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
public class SistemaFuncionariosBomPrato implements SistemaFuncionarios{

    private Map<String, Funcionario> funcionarios;

    public Map<String, Funcionario> pesquisaFuncionarios() {
        return this.funcionarios;
    }

    public SistemaFuncionariosBomPrato() {
        this.funcionarios = new HashMap<>();
    }

    public void cadastrarFuncionario(Funcionario funcionario) throws FuncionarioJaExisteException{
        if(funcionarioJaExiste(funcionario)) {
            throw new FuncionarioJaExisteException("Esse funcionário já está cadastrado no sistema");
        }
        this.funcionarios.put(funcionario.getCpf(), funcionario);
    }

    public void cadastrarFuncionario(String cpf, String nome, TipoFuncionario tipoFuncionario, double salario) throws FuncionarioJaExisteException{
        if(funcionarioJaExiste(cpf)) {
            throw new FuncionarioJaExisteException("Esse funcionário já está cadastrado no sistema");
        }
        this.funcionarios.put(cpf, new Funcionario(cpf, nome, tipoFuncionario, salario));
    }

    public void alterarSalarioDeFuncionario(String cpf, double novoSalario) throws FuncionarioInexistenteException {
        if(funcionarioJaExiste(cpf)) {
            this.funcionarios.get(cpf).setSalario(novoSalario);
        }
        throw new FuncionarioInexistenteException("Esse funcionário não está cadastrado no sistema");
    }

    public int contarFuncionariosDoTipo(TipoFuncionario tipoFuncionario) {
        int contador = 0;
        for(Funcionario f : this.funcionarios.values()) {
            if(f.getTipo().equals(tipoFuncionario)) {
                contador ++;
            }
        }
        return contador;
    }

    public boolean funcionarioJaExiste(String cpfFuncionario) {
        return this.funcionarios.containsKey(cpfFuncionario);
    }

    public boolean funcionarioJaExiste(Funcionario funcionario) {
        return this.funcionarios.containsValue(funcionario);
    }

    public List<Funcionario> pesquisarFuncionariosPorTipo(TipoFuncionario tipo) {
        List<Funcionario> funcionariosSelecionados = new ArrayList<>();
        for(Funcionario f : this.funcionarios.values()) {
            if(f.getTipo().equals(tipo)) {
                funcionariosSelecionados.add(f);
            }
        }
        return funcionariosSelecionados;
    }

    public Funcionario pesquisarFuncionario(String cpf) {
        return this.funcionarios.get(cpf);
    }

    public List<Funcionario> pesquisarFuncionariosComSalarioMaiorQue(double valor) {
        List<Funcionario> funcionariosSelecionados = new ArrayList<>();
        for(Funcionario f : this.funcionarios.values()) {
            if(f.getSalario() > valor) {
                funcionariosSelecionados.add(f);
            }
        }
        return funcionariosSelecionados;
    }
}