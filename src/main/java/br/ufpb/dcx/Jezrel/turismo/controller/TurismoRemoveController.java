package br.ufpb.dcx.Jezrel.turismo.controller;

import br.ufpb.dcx.Jezrel.turismo.AtrativoNaoExisteException;
import br.ufpb.dcx.Jezrel.turismo.SistemaAtrativosMap;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TurismoRemoveController implements ActionListener {

    private SistemaAtrativosMap sistema;
    private JFrame janelaPrincipal;

    public TurismoRemoveController(SistemaAtrativosMap sistema, JFrame janelaPrincipal) {
        this.sistema = sistema;
        this.janelaPrincipal = janelaPrincipal;
    }

    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog(janelaPrincipal, "Qual é o nome do atrativo que você deseja remover?");
        try {
            sistema.removeAtrativo(nome);
            JOptionPane.showMessageDialog(janelaPrincipal, "Atrativo removido com sucesso!");
        } catch(AtrativoNaoExisteException a) {
            JOptionPane.showMessageDialog(janelaPrincipal, a.getMessage());
        }
    }
}
