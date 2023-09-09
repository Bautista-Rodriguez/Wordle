package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelTitulo extends JPanel{
    JLabel etiquetaTitulo = new JLabel(new ImageIcon("src\\images\\Title.png"));
    JLabel etiquetaMensajes = new JLabel(new ImageIcon("src\\images\\Mensajes.png"));

    public PanelTitulo(){
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        this.setPreferredSize(new Dimension(700, 130));
        this.mostrarTitulo();
        this.add(etiquetaTitulo);
        this.add(etiquetaMensajes);
    }

    public void mostrarTitulo(){
        etiquetaTitulo.setBounds(284,20,132,37);
        etiquetaMensajes.setBounds(175,73,349,40);
        etiquetaMensajes.setText("Intentos restantes: 6");
        etiquetaMensajes.setFont(Fuentes.FuenteMensajes);
        etiquetaMensajes.setForeground(Color.WHITE);
        etiquetaMensajes.setHorizontalTextPosition(JLabel.CENTER);
        etiquetaMensajes.setVerticalTextPosition(JLabel.CENTER);
        etiquetaMensajes.setOpaque(true);
    }
}
