package br.ufpb.dcx.Jezrel.turismo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TurismoGUI extends JFrame {

    public TurismoGUI() {

        super.setTitle("Sistema turismo");
        super.setSize(500, 500);
        super.getContentPane().setBackground(Color.BLUE);
        super.setResizable(false);
        super.setLocation(0, 0);
    }

    public static void main(String[] args) {

        TurismoGUI janela = new TurismoGUI();
        janela.setVisible(true);

        WindowListener fechadorDeJanelaPrincipal =  new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        janela.addWindowListener(fechadorDeJanelaPrincipal);
    }
}