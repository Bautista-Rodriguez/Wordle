package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.WordleModel;
import model.WordleModel.ColorLetra;

public class PanelCuadricula extends JPanel{
    public JLabel tabla[][] = new JLabel[6][5];
    public WordleModel model;
    public PanelTeclado panelTeclado;
    public JButton botonReiniciar = new JButton();

    public PanelCuadricula(WordleModel model){
        this.model=model;
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(700, 490));
        botonReiniciar.setFont(Fuentes.FuenteBotones);
        botonReiniciar.setBounds(246, 435, 207, 40);
        botonReiniciar.setForeground(Color.WHITE);
        botonReiniciar.setBackground(Colores.Negro);
        botonReiniciar.setBorder(Bordes.bordeNegro);
        botonReiniciar.setOpaque(true);
        botonReiniciar.setText("Reiniciar");
        botonReiniciar.setFocusable(false);
        botonReiniciar.setEnabled(false);
        this.add(botonReiniciar);
        for(int i=0;i<6;i++){
            for(int j=0;j<5;j++){
                tabla[i][j] = new JLabel("",SwingConstants.CENTER);
                tabla[i][j].setBounds(j*71+175,i*71, 65, 65);
                tabla[i][j].setFont(Fuentes.FuenteCuadricula);
                tabla[i][j].setBackground(Color.WHITE);
                tabla[i][j].setOpaque(true);
                this.add(tabla[i][j]);
            }
        }
    }

    public void asignarPanelTeclado(PanelTeclado t){
        panelTeclado = t;
    }

    public void actualizarColores(){
        int fila = model.getFilaActual()-1;
        for(int i=0;i<5;i++){
            ColorLetra color = model.getPosVectorUsuario(i);
            switch(color){
                case VERDE:
                tabla[fila][i].setBorder(Bordes.bordeVerde);
                tabla[fila][i].setBackground(Colores.Verde);
                tabla[fila][i].setForeground(Color.WHITE);
                break;
                case AMARILLO:
                tabla[fila][i].setBorder(Bordes.bordeAmarillo);
                tabla[fila][i].setBackground(Colores.Amarillo);
                tabla[fila][i].setForeground(Color.WHITE);
                break;
                case NEGRO:
                tabla[fila][i].setBorder(Bordes.bordeNegro);
                tabla[fila][i].setBackground(Colores.Negro);
                tabla[fila][i].setForeground(Color.WHITE);
                break;
                default:
                break;
            }
            String letra = tabla[fila][i].getText();
            panelTeclado.actualizarColores(letra,tabla[fila][i].getBackground());
        }
    }

    public void reiniciarColores(){
        for(int i=0;i<6;i++){
            for(int j=0;j<5;j++){
                tabla[i][j].setBackground(Color.WHITE);
                tabla[i][j].setForeground(Color.BLACK);
            }
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i=0;i<6;i++){
            for(int j=0;j<5;j++){
                char letra = model.getLetraEnCuadricula(i,j);
                tabla[i][j].setText(Character.toString(letra));
                if(letra==' ')
                    tabla[i][j].setBorder(Bordes.bordeGrisClaro);
                else if(i>=model.getFilaActual())
                    tabla[i][j].setBorder(Bordes.bordeGrisOscuro);
            }
        }
    }
}
