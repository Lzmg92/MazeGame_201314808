import java.util.LinkedList;

/**
 * Created by lezs on 2/04/15.
 */
public class Datos {

    public static String errores = "";

    public static LinkedList<NodoFondo> ListaFondos = new LinkedList<NodoFondo>();
    public static LinkedList<NodoPersonaje> ListaPersonajes = new LinkedList<NodoPersonaje>();
    public static LinkedList<NodoExtras> ListaExtras = new LinkedList<NodoExtras>();


    public static String NombreHer = "";
    public static int XHer = 0;
    public static int YHer = 0;

    public static String NombreFon = "";

    public static int Dimension = 0;

    public static LinkedList<NodoCoor> ListaExtrasCoor = new LinkedList<NodoCoor>();
    public static LinkedList<NodoMuroCoor> ListaMuro = new LinkedList<NodoMuroCoor>();


    public Datos(){}
}
