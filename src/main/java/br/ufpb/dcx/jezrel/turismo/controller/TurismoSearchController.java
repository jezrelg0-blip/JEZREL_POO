package br.ufpb.dcx.jezrel.turismo.controller;

import br.ufpb.dcx.jezrel.turismo.AtrativoTuristico;
import br.ufpb.dcx.jezrel.turismo.SistemaAtrativosMap;
import br.ufpb.dcx.jezrel.turismo.TipoAtrativo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static br.ufpb.dcx.jezrel.turismo.TipoAtrativo.*;
public class TurismoSearchController implements ActionListener {

    private SistemaAtrativosMap sistema;
    private JFrame janelaPrincipal;

    public TurismoSearchController(SistemaAtrativosMap sistema, JFrame janelaPrincipal) {
        this.sistema = sistema;
        this.janelaPrincipal = janelaPrincipal;
    }

    public void actionPerformed(ActionEvent e) {
        TipoAtrativo tipo = null;
        int opcao = Integer.parseInt(JOptionPane.showInputDialog("Qual é o tipo do atrativo você deseja pesquisar?(Digite o número correspondente)\n\n" +
                "Opções:\n1 - Formação rochosa\n2 - Cachoeira\n3 - Praia\n4 - Floresta/Bosque\n5 - Igreja\n6 - Museu"));

        switch (opcao) {
            case 1:
                tipo = FORMACAO_ROCHOSA;
                break;
            case 2:
                tipo = CACHOEIRA;
                break;
            case 3:
                tipo = PRAIA;
                break;
            case 4:
                tipo = FLORESTA_BOSQUE;
                break;
            case 5:
                tipo = IGREJA;
                break;
            case 6:
                tipo = MUSEU;
                break;
            default:
                return;
        }
        if (sistema.pesquisaAtrativosDoTipo(tipo).size() > 0) {
            String textoCompleto = "Atrativos turísticos do tipo escolhido:(" + (tipo.toString() + ")\n");
            for (AtrativoTuristico a : sistema.pesquisaAtrativosDoTipo(tipo)) {
                textoCompleto += a.toString() + "\n";
            }
            JOptionPane.showMessageDialog(janelaPrincipal, textoCompleto);
        }
        else {
            JOptionPane.showMessageDialog(janelaPrincipal, "Não há nenhum atrativo desse tipo cadastrado no sistema.");
        }
    }
}

