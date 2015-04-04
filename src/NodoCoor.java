/**
 * Created by lezs on 2/04/15.
 */
public class NodoCoor {

    int X, Y;
    String Nombre, Tipo;

    public NodoCoor(String Nombre, String Tipo, int X, int Y){
        Nombre = this.Nombre;
        Tipo = this.Tipo;
        X = this.X;
        Y = this.Y;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

}
