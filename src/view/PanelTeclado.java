package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelTeclado extends JPanel{
    JLabel listaEtiquetas[] = new JLabel[26];
    public String letrasTeclado[] = 
        {"Q","W","E","R","T","Y","U","I","O","P",
         "A","S","D","F","G","H","J","K","L",
         "Z","X","C","V","B","N","M"};
    public PanelTeclado(){
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(700, 250));
        agregarLetrasALista();
        for(int i=0;i<26;i++){
            this.add(listaEtiquetas[i]);
        }
    }

    void agregarLetrasALista(){
        inicializarLetrasQ();
        inicializarLetrasA();
        inicializarLetrasZ();
        return;
    }
    void inicializarLetrasQ(){
        for(int i=0;i<10;i++){
                agregarEtiquetaALista(i,0, 77, 0);
        }
        return;
    }
    void inicializarLetrasA(){
        for(int j=10;j<19;j++){
                agregarEtiquetaALista(j,10, 105, 75);
        }
        return;
    }
    void inicializarLetrasZ(){
        for(int k=19;k<26;k++){
                agregarEtiquetaALista(k, 19, 160, 150);
        }
        return;
    }
    void agregarEtiquetaALista(int i,int resto,int posicionX,int posicionY){
        listaEtiquetas[i]= new JLabel((letrasTeclado[i]));
        listaEtiquetas[i].setBackground(Colores.Gris);
        listaEtiquetas[i].setOpaque(true);
        listaEtiquetas[i].setBorder(Bordes.bordeTeclado);
        listaEtiquetas[i].setHorizontalAlignment(SwingConstants.CENTER);
        listaEtiquetas[i].setBounds((i-resto)*55+posicionX, posicionY, 50, 70);
        listaEtiquetas[i].setFont(Fuentes.FuenteTeclado);
        return;
    }

    public void actualizarColores(String letra, Color color){
        int index=Arrays.asList(letrasTeclado).indexOf(letra);
        if(listaEtiquetas[index].getBackground()==Colores.Gris || color==Colores.Verde)
        {
            listaEtiquetas[index].setBackground(color);
            listaEtiquetas[index].setForeground(Color.WHITE);
        }
    }
    void reiniciarColores(){
        for(int i=0;i<26;i++){
            listaEtiquetas[i].setBackground(Colores.Gris);
            listaEtiquetas[i].setForeground(Color.BLACK);
        }
        return;
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
