/**
 * Created by lezs on 2/04/15.
 */
public class NodoMuroCoor {

    String Nombre;
    boolean Horizontal;
    int Ini, Fin, Cte;

    public NodoMuroCoor(String Nombre, boolean Horizontal, int Ini, int Fin ,int Cte){

        Nombre = this.Nombre;
        Horizontal = this.Horizontal;
        Ini = this.Ini;
        Fin = this.Fin;
        Cte = this.Cte;

    }

    public boolean isHorizontal() {
        return Horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        Horizontal = horizontal;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getIni() {
        return Ini;
    }

    public void setIni(int ini) {
        Ini = ini;
    }

    public int getFin() {
        return Fin;
    }

    public void setFin(int fin) {
        Fin = fin;
    }

    public int getCte() {
        return Cte;
    }

    public void setCte(int cte) {
        Cte = cte;
    }

}
