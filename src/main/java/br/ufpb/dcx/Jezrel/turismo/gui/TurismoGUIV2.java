package br.ufpb.dcx.Jezrel.turismo.gui;

import javax.swing.*;
import java.awt.*;

public class TurismoGUIV2 extends JFrame {

    JLabel linha1, linha2;
    ImageIcon paisagem = new ImageIcon("./imgs/praia.jpg");
    public TurismoGUIV2() {

        super.setTitle("Sistema Turismo");
        super.setSize(500, 500);
        super.getContentPane().setBackground(Color.BLUE);
        super.setResizable(true);
        super.setLocation(0, 0);
        linha1 = new JLabel("Meu plano de turismo", JLabel.CENTER);
        linha1.setForeground(Color.YELLOW);
        linha1.setFont(new Font("Serif", Font.BOLD, 26));
        linha2 = new JLabel(paisagem, JLabel.CENTER);
        getContentPane().setLayout(new GridLayout(3, 1));
        getContentPane().add(linha1);
        getContentPane().add(linha2);
    }

    public static void main(String[] args) {

        JFrame janela = new TurismoGUIV2();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}