package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.WordleModel;
import view.WordleView;

public class WordleController {
    WordleModel model;
    WordleView view;
    public WordleController(WordleModel model, WordleView view){
        this.model = model;
        this.view = view;
        view.asignarAccionReiniciar(accionReiniciar);
        view.asignarOyenteTeclado(oyenteTeclado);
    }

    public void manejarCodigo(int code){
        if(model.getGameOver())
            return;
        if(code>=65 && code<=90){
            boolean respuesta=model.agregarLetraCuadricula((char)code);
            if(respuesta)
                view.actualizar();
        }
        else if(code==8){
            boolean respuesta=model.quitarLetraCuadricula();
            if(respuesta)
                view.actualizar();
        }
        else if(code==10){
            int colActual = model.getColumnaActual();
            if(colActual!=5){
                view.mostrarTexto("No hay suficientes letras");
                view.actualizar();
                return;
            }
            if(!model.palabraEnLista()){
                view.mostrarTexto("La palabra no está en la lista");
                view.actualizar();
                return;
            }
            view.mostrarTexto("Intentos restantes: "+(5-model.getFilaActual()));
            model.inicializarVectores();
            boolean respuesta=model.compararPalabras();
            if(respuesta){
                model.setGameOver(true);
                view.mostrarTexto("¡Ganaste!");
                view.habilitarReiniciar();
            }
            else if(model.getFilaActual()==6){
                model.setGameOver(true);
                view.mostrarTexto("¡Perdiste! La palabra era: "+model.getPalabraRespuesta());
                view.habilitarReiniciar();
            }
            view.actualizarColores();
        }
        view.actualizar();
        return;
    }
    ActionListener accionReiniciar = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            model.inicializar();
            view.inicializar();
        }   
    };
    KeyListener oyenteTeclado = new KeyListener(){
        @Override
        public void keyTyped(KeyEvent e) {}
        @Override
        public void keyPressed(KeyEvent e) {
            int code=e.getKeyCode();
            manejarCodigo(code);
        }
        @Override
        public void keyReleased(KeyEvent e) {}
        };
}
