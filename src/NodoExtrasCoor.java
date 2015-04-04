import sun.security.krb5.internal.crypto.Des;

/**
 * Created by lezs on 26/03/15.
 */
public class NodoExtrasCoor {

    String Ruta, Tipo;
    int X, Y, Puntos;

    public NodoExtrasCoor(String Ruta, String Tipo, int X, int _Y, int Puntos){
        Tipo = this.Tipo;
        Ruta = this.Ruta;
        Puntos = this.Puntos;
        X = this.X;
        Y = this.Y;
    }

    public int getPuntos() {
        return Puntos;
    }

    public void setPuntos(int puntos) {
        Puntos = puntos;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getRuta() {
        return Ruta;
    }

    public void setRuta(String ruta) {
        Ruta = ruta;
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
}
