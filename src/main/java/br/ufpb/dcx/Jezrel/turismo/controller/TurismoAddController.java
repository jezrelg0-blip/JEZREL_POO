package br.ufpb.dcx.Jezrel.turismo.controller;

import br.ufpb.dcx.Jezrel.turismo.AtrativoJaExisteException;
import br.ufpb.dcx.Jezrel.turismo.SistemaAtrativosMap;
import br.ufpb.dcx.Jezrel.turismo.TipoAtrativo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static br.ufpb.dcx.Jezrel.turismo.TipoAtrativo.*;

public class TurismoAddController implements ActionListener {

    private SistemaAtrativosMap sistema;
    private JFrame janelaPrincipal;

    public TurismoAddController(SistemaAtrativosMap sistema, JFrame janelaPrincipal) {
        this.sistema = sistema;
        this.janelaPrincipal = janelaPrincipal;
    }

    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog(janelaPrincipal, "Qual é o nome do atrativo?");
        String descricao = JOptionPane.showInputDialog(janelaPrincipal, "Descreva o atrativo");
        TipoAtrativo tipo = null;
        int opcao = Integer.parseInt(JOptionPane.showInputDialog("Qual é o tipo do atrativo?(Digite o número correspondente)\n\n" +
                "Opções:\n1 - Formação rochosa\n2 - Cachoeira\n3 - Praia\n4 - Floresta/Bosque\n5 - Igreja\n6 - Museu"));

        switch (opcao) {
            case 1:
                tipo = FORMACAO_ROCHOSA;
            case 2:
                tipo = CACHOEIRA;
            case 3:
                tipo = PRAIA;
            case 4:
                tipo = FLORESTA_BOSQUE;
            case 5:
                tipo = IGREJA;
            case 6:
                tipo = MUSEU;
        }
        try {
            sistema.cadastraAtrativo(nome, descricao, tipo);
            JOptionPane.showMessageDialog(janelaPrincipal, "Atrativo cadastrado com sucesso!");
        } catch(AtrativoJaExisteException a) {
            JOptionPane.showMessageDialog(janelaPrincipal, a.getMessage());
        }

    }
}