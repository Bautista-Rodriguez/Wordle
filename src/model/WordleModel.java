package model;

public class WordleModel {
    public enum ColorLetra {
        VERDE,AMARILLO,NEGRO
    }
    private ListaPalabras palabras;
    private boolean gameOver;
    private boolean[] vectorRespuesta = new boolean[5];
    private ColorLetra[] vectorUsuario = new ColorLetra[5];
    private int columnaActual, filaActual;
    private final int numeroFilas, numeroColumnas;
    private char[] palabraRespuesta=new char[5];
    private char [] palabraUsuario=new char[5];

    private char cuadricula[][] = new char[6][5];

    public WordleModel(){
        this.numeroColumnas=5;
        this.numeroFilas=6;
        this.inicializar();
    }

    public void inicializar(){
        gameOver=false;
        this.columnaActual=0;
        this.filaActual=0;
        palabras = new ListaPalabras();
        this.elegirPalabra();
        for (int i = 0; i < numeroFilas; i++) {
			for (int j = 0; j < numeroColumnas; j++) {
				cuadricula[i][j] = ' ';
			}
		}
        inicializarVectores();
    }

    public void inicializarVectores(){
        for(int i=0;i<5;i++){
            vectorRespuesta[i]=false;
            vectorUsuario[i]=null;
        }
        return;
    }

    public void elegirPalabra(){
        String palabra = palabras.getPalabra().toUpperCase();
        for(int i=0;i<5;i++){
            palabraRespuesta[i]=palabra.charAt(i);
        }
    }
    public boolean palabraEnLista(){
        return palabras.esValida(new String(palabraUsuario));
    }

    public boolean getGameOver(){
        return gameOver;
    }
    public void setGameOver(boolean valor){
        gameOver=valor;
    }
    public ColorLetra getPosVectorUsuario(int i){
        return vectorUsuario[i];
    }
    public String getPalabraRespuesta(){
        return new String(palabraRespuesta);
    }
    public int getColumnaActual(){
        return columnaActual;
    }
    public int getFilaActual(){
        return filaActual;
    }
    int getNumeroColumnas(){
        return numeroColumnas;
    }
    int getNumeroFilas(){
        return numeroFilas;
    }
    public boolean agregarLetraCuadricula(char letra){
        if(numeroColumnas-columnaActual==0)
            return false;
        palabraUsuario[columnaActual]=letra;
        cuadricula[filaActual][columnaActual]=letra;
        columnaActual++;
        return true;
    }
    public boolean quitarLetraCuadricula(){
        if(columnaActual==0)
            return false;
        columnaActual--;
        cuadricula[filaActual][columnaActual]=' ';
        return true;
    }
    public char getLetraEnCuadricula(int i, int j){
        return cuadricula[i][j];
    }
    public boolean compararPalabras(){
        int letrasCorrectas=0;		
		for (int i=0;i<numeroColumnas;i++) {
			if(palabraUsuario[i] == palabraRespuesta[i]){
                vectorRespuesta[i]=true;
                vectorUsuario[i]=ColorLetra.VERDE;
                letrasCorrectas++;
            }
			else if(contiene(palabraUsuario[i])){
                vectorUsuario[i]=ColorLetra.AMARILLO;
            }
            else
                vectorUsuario[i]=ColorLetra.NEGRO;
		}
		columnaActual=0;
		filaActual++;
		
		if(letrasCorrectas==5)
            return true;
        return false;
	}
    boolean contiene(char letra){
        for(int i=0;i<numeroColumnas;i++){
            if(palabraRespuesta[i]==letra && palabraRespuesta[i]!=palabraUsuario[i] && !vectorRespuesta[i]){
                vectorRespuesta[i]=true;
                return true;
            }
        }
        return false;
    }
}