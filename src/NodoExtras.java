/**
 * Created by lezs on 26/03/15.
 */
public class NodoExtras {
    String Nombre, Ruta, Tipo;
    int Puntos;

    public NodoExtras(String Nombre, String Ruta, String Tipo, int Puntos){
        Nombre = this.Nombre;
        Ruta = this.Ruta;
        Tipo = this.Tipo;
        Puntos = this.Puntos;

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

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public int getPuntos() {
        return Puntos;
    }

    public void setPuntos(int puntos) {
        Puntos = puntos;
    }
}
