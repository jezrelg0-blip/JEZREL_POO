package br.ufpb.dcx.jezrel.turismo.gui;

import br.ufpb.dcx.jezrel.turismo.SistemaAtrativosMap;
import br.ufpb.dcx.jezrel.turismo.controller.TurismoAddController;
import br.ufpb.dcx.jezrel.turismo.controller.TurismoRemoveController;
import br.ufpb.dcx.jezrel.turismo.controller.TurismoSearchController;

import javax.swing.*;
import java.awt.*;

public class TurismoGUIV3ComMenu extends JFrame {

    JLabel linha1, linha2;
    ImageIcon paisagem = new ImageIcon("./imgs/paisagem.jpg");
    JMenuBar barraDeMenu = new JMenuBar();
    SistemaAtrativosMap sistema = new SistemaAtrativosMap();

    public TurismoGUIV3ComMenu (){

        setSize(800, 800);
        setResizable(true);
        setLocation(getWidth()/2, getHeight()/4);
        setBackground(Color.YELLOW);
        linha1 = new JLabel("Meu plano de Turismo", JLabel.CENTER);
        linha1.setForeground(Color.BLUE);
        linha1.setFont(new Font("Serif", Font.BOLD, 24));
        linha2 = new JLabel(paisagem, JLabel.CENTER);
        setLayout(new GridLayout(3,1));
        add(linha1);
        add(linha2);
        add(new JLabel());
        JMenu menuCadastrar = new JMenu("Cadastrar");
        JMenuItem menuCadastrarAtrativo = new JMenuItem("Cadastrar atrativo");
        menuCadastrar.add(menuCadastrarAtrativo);
        JMenu menuRemover = new JMenu("Remover");
        JMenuItem menuRemoverAtrativo = new JMenuItem("Remover atrativo");
        menuRemover.add(menuRemoverAtrativo);
        JMenu menuPesquisar = new JMenu("Pesquisar");
        JMenuItem menuPesquisarAtrativo = new JMenuItem("Pesquisar atrativo");
        menuPesquisar.add(menuPesquisarAtrativo);
        menuCadastrarAtrativo.addActionListener(new TurismoAddController(sistema, this));
        menuRemoverAtrativo.addActionListener(new TurismoRemoveController(sistema, this));
        menuPesquisarAtrativo.addActionListener(new TurismoSearchController(sistema, this));
        barraDeMenu.add(menuCadastrar);
        barraDeMenu.add(menuRemover);
        barraDeMenu.add(menuPesquisar);
        setJMenuBar(barraDeMenu);
    }

    public static void main(String[] args) {
        JFrame janela = new TurismoGUIV3ComMenu();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}