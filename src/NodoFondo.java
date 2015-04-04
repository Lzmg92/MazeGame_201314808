/**
 * Created by lezs on 2/04/15.
 */
public class NodoFondo {
    String Nombre, Ruta;

    public NodoFondo(String Nombre, String Ruta){
        Nombre = this.Nombre;
        Ruta = this.Ruta;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getRuta() {
        return Ruta;
    }

    public void setRuta(String ruta) {
        Ruta = ruta;
    }
}
