package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import model.WordleModel;

public class WordleView extends JFrame{
    private PanelTitulo panelTitulo;
	private PanelCuadricula panelCuadricula;
    private PanelTeclado panelTeclado;

	public WordleView(WordleModel model) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
        this.setTitle("Wordle");
        this.setIconImage(new ImageIcon("src/images/Icono.png").getImage());
        this.panelTitulo = new PanelTitulo();
		this.panelCuadricula = new PanelCuadricula(model);
        this.panelTeclado = new PanelTeclado();
        panelCuadricula.asignarPanelTeclado(panelTeclado);
        this.add(panelTitulo,BorderLayout.NORTH);
        this.add(panelCuadricula,BorderLayout.CENTER);
        this.add(panelTeclado,BorderLayout.SOUTH);
        this.pack();
        this.setLocationRelativeTo(null);
        this.actualizar();
	}

    public void actualizar(){
        this.revalidate();
        this.repaint();
    }
    public void actualizarTitulo(){
        panelTitulo.revalidate();
        panelTitulo.repaint();
    }
    public void actualizarCuadricula(){
        panelCuadricula.revalidate();
        panelCuadricula.repaint();
    }
    public void actualizarTeclado(){
        panelTeclado.revalidate();
        panelTeclado.repaint();
    }

    public void mostrarTexto(String texto){
        panelTitulo.etiquetaMensajes.setText(texto);
    }

    public void asignarAccionReiniciar(ActionListener accion){
        panelCuadricula.botonReiniciar.addActionListener(accion);
    }
    public void habilitarReiniciar(){
        panelCuadricula.botonReiniciar.setEnabled(true);
        panelCuadricula.botonReiniciar.setBorder(Bordes.bordeVerde);
        panelCuadricula.botonReiniciar.setBackground(Colores.Verde);
    }
    public void actualizarColores(){
        panelCuadricula.actualizarColores();
        return;
    }

    public void inicializar(){
        panelCuadricula.botonReiniciar.setFocusable(false);
        panelCuadricula.botonReiniciar.setEnabled(false);
        panelCuadricula.botonReiniciar.setBackground(Colores.Negro);
        panelCuadricula.botonReiniciar.setBorder(Bordes.bordeNegro);
        panelCuadricula.reiniciarColores();
        panelTeclado.reiniciarColores();
        this.mostrarTexto("Intentos restantes: 6");
        actualizarTitulo();
        actualizarCuadricula();
        actualizarTeclado();
        actualizar();
    }

    public void asignarOyenteTeclado(KeyListener kl){
        this.addKeyListener(kl);
    }
}
