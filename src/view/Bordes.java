package view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Bordes {
    public static Border bordeGrisClaro = BorderFactory.createMatteBorder(3,3,3,3,Color.LIGHT_GRAY);
    public static Border bordeGrisOscuro = BorderFactory.createMatteBorder(3,3,3,3,Color.GRAY);
    public static Border bordeVerde = BorderFactory.createMatteBorder(3,3,3,3,Colores.Verde);
    public static Border bordeAmarillo = BorderFactory.createMatteBorder(3,3,3,3,Colores.Amarillo);
    public static Border bordeNegro = BorderFactory.createMatteBorder(3,3,3,3,Colores.Negro);
    public static Border bordeTeclado = BorderFactory.createRaisedBevelBorder();
}
