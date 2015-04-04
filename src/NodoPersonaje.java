/**
 * Created by lezs on 2/04/15.
 */
public class NodoPersonaje {
    String Nombre, Ruta, Descripcion, Tipo;
    int Vida;

    public NodoPersonaje(String Nombre, String Ruta,  int Vida ,String Descripcion, String Tipo){
        Nombre = this.Nombre;
        Ruta = this.Ruta;
        Descripcion = this.Descripcion;
        Tipo = this.Tipo;
        Vida = this.Vida;
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

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public int getVida() {
        return Vida;
    }

    public void setVida(int vida) {
        Vida = vida;
    }
}
