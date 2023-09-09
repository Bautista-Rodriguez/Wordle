package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class ListaPalabras {
    Random rand;
    final File archivoPalabras = new File("src\\model\\Palabras.txt");
	BufferedReader buffer;

    public String getPalabra(){
        try{
        rand = new Random();
        int lineaNum = rand.nextInt(4221)+1;
        int contador=0;
		buffer=new BufferedReader(new FileReader(archivoPalabras));
        String lineaTexto ="";
		while(contador!=lineaNum)
		{
			lineaTexto=buffer.readLine();
            contador++;
		}
        return lineaTexto;
	} 
	catch (IOException e) {
		e.printStackTrace();
	}
    return "";
	}

    public boolean esValida(String palabra){
		String lineaTexto="";	

		try {
			buffer=new BufferedReader(new FileReader(archivoPalabras));
			while((lineaTexto=buffer.readLine())!=null)
			{
				if(palabra.equals(lineaTexto.toUpperCase()))
					return true;
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
