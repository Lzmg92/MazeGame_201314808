import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

/**
 * Created by lezs on 23/03/15.
 */
public class Grafico extends JPanel implements Runnable,ActionListener, KeyListener {

    Datos d = new Datos();

    boolean running = true;
    boolean mov = false;
    boolean disparado = false;
    boolean creado = false;

    boolean mov1 = false;

    LinkedList<NodoExtrasCoor> ListaExtrasCoorCom = new LinkedList<NodoExtrasCoor>();
    LinkedList<NodoMuroCoor> ListaMuroCom = new LinkedList<NodoMuroCoor>();

    String rutafondo="";
    String rutaher="";

    private Timer timer;

    int nrelativo = d.Dimension;
    int dimension = Math.round(650/nrelativo);


    int tred = 1;

    int xd=0;
    int yd=0;

    int xca = 0;
    int yca = 0;
    int x = 0;
    int y = 0;

    public String nombrejug = d.NombreHer;

    int intvidajug = 0;
    int intvidaenem = 0;

    JLabel vidajug = new JLabel("Vida: 100");
    JLabel vidaenemigo = new JLabel("Enemigo: 100");


    //////////////////////////////////////////////////// METODOS DE BOTONES
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_A){
            disparado = true;
            xd = x;
            yd = y;
        }

        if (key == KeyEvent.VK_RIGHT) {
            xca = dimension;
        }
        if (key == KeyEvent.VK_LEFT) {
            xca = -dimension;
        }
        if (key == KeyEvent.VK_UP) {
            yca = -dimension;
        }
        if (key == KeyEvent.VK_DOWN) {
            yca = dimension;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_A){
            disparado=false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            xca = 0;
        }
        if (key == KeyEvent.VK_LEFT) {
            xca = 0;
        }
        if (key == KeyEvent.VK_UP) {
            yca = 0;
        }
        if (key == KeyEvent.VK_DOWN) {
            yca = 0;
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {

      if(intvidajug <= 0) {

            VentanaGameOver n = new VentanaGameOver();
            n.resultadopts.setText("Vida: "+intvidajug+" <----> Enemigo: "+intvidaenem+"");
            n.lblnombre.setText(nombrejug+" no lo ha logrado");
            n.resultado.setText("OH NO!");
            ListaExtrasCoorCom.clear();
            timer.stop();
        }


        if (x + xca> (650-dimension) || x + xca < 0){
            xca = 0;}
        if (y + yca> (650-dimension)  || y + yca < 0){
            yca = 0;}

        if(yd<=0){creado = false;}

        RestringirCentro(ListaMuroCom);
        RestringirExtras(ListaExtrasCoorCom);

        x = x + xca;
        y = y + yca;
        repaint();
    }


    //////////////////////////////////////////////////// CONSTRUCTOR


    public Grafico(){
        setSize(700, 700);
        addKeyListener(this);
        setFocusable(true);
        timer = new Timer(120, this);
        timer.start();

        int contex =0;

        for(int i = 0; i< d.ListaFondos.size(); i++){
        if (d.NombreFon.equals(d.ListaFondos.get(i).getNombre())){
            rutafondo = d.ListaFondos.get(i).getRuta();
            break;
        }}


        for(int i =0; i<d.ListaExtrasCoor.size(); i++){
            String tipo = d.ListaExtrasCoor.get(i).getTipo();

            if(tipo.equals("heroe")){
                for(int j = 0; j< d.ListaPersonajes.size(); j++){
                if(d.ListaExtrasCoor.get(i).getNombre().equals(d.ListaPersonajes.get(j).getNombre())){
                    rutaher = d.ListaPersonajes.get(j).getRuta();
                    x = d.XHer*dimension;
                    y = d.YHer*dimension;
                    intvidajug = d.ListaPersonajes.get(j).getVida();
                } }
            }else if(tipo.equals("villano")){
                for(int j = 0; j< d.ListaPersonajes.size(); j++){
                    if(d.ListaExtrasCoor.get(i).getNombre().equals(d.ListaPersonajes.get(j).getNombre())){

                        int vida = d.ListaPersonajes.get(j).getVida();

                        ListaExtrasCoorCom.add(new NodoExtrasCoor("","",0,0,0));
                        ListaExtrasCoorCom.get(contex).setTipo(tipo);
                        ListaExtrasCoorCom.get(contex).setRuta(d.ListaPersonajes.get(j).getRuta());
                        ListaExtrasCoorCom.get(contex).setX(d.ListaExtrasCoor.get(i).getX());
                        ListaExtrasCoorCom.get(contex).setY(d.ListaExtrasCoor.get(i).getY());
                        ListaExtrasCoorCom.get(contex).setPuntos(vida);

                        intvidaenem = intvidaenem + vida;

                        contex++;

                    }
                }
            }

            else{
            for(int j = 0; j< d.ListaExtras.size(); j++){

            if(d.ListaExtrasCoor.get(i).getNombre().equals(d.ListaExtras.get(j).getNombre())){

                ListaExtrasCoorCom.add(new NodoExtrasCoor("","",0,0,0));
                ListaExtrasCoorCom.get(contex).setTipo(tipo);
                ListaExtrasCoorCom.get(contex).setRuta(d.ListaExtras.get(j).getRuta());
                ListaExtrasCoorCom.get(contex).setX(d.ListaExtrasCoor.get(i).getX());
                ListaExtrasCoorCom.get(contex).setY(d.ListaExtrasCoor.get(i).getY());
                ListaExtrasCoorCom.get(contex).setPuntos(d.ListaExtras.get(j).getPuntos());
                contex++;
            }
        }}}

        int contmu = 0;

        for(int i = 0; i < d.ListaMuro.size(); i++){

            for(int j = 0; j<d.ListaExtras.size(); j++){

                if(d.ListaExtras.get(j).getTipo().equals("bloque")){

                if(d.ListaMuro.get(i).getNombre().equals(d.ListaExtras.get(j).getNombre())){

                    ListaMuroCom.add(new NodoMuroCoor("",true,0,0,0));

                    ListaMuroCom.get(contmu).setNombre(d.ListaExtras.get(j).getRuta());
                    ListaMuroCom.get(contmu).setHorizontal(d.ListaMuro.get(i).isHorizontal());
                    ListaMuroCom.get(contmu).setIni(d.ListaMuro.get(i).getIni());
                    ListaMuroCom.get(contmu).setFin(d.ListaMuro.get(i).getFin());
                    ListaMuroCom.get(contmu).setCte(d.ListaMuro.get(i).getCte());

                    contmu++;
                }}

            }
        }


    } ///////////////////----------------------------- termina constructor


    ////////////////////////////////////////////////////// METODOS GRAPHICS
    public void paint(Graphics g){
        update(g); }

    public void update(Graphics g){

        vidajug.setText("Vida: "+Integer.toString(intvidajug));
        vidaenemigo.setText("Enemigo: "+Integer.toString(intvidaenem));

        ImageIcon imgi = new ImageIcon(rutafondo);
        Image imge = imgi.getImage();
        ImageIcon imges = new ImageIcon(imge.getScaledInstance(650,650,Image.SCALE_SMOOTH));

        g.drawImage(imges.getImage(), 0, 0, null);

        if(disparado){

            g.drawOval(xd,yd, Math.round(dimension/3), Math.round(dimension/3));
            creado = true;
        }

        if(creado){

            g.drawOval(xd,yd, Math.round(dimension/3), Math.round(dimension/3));
            yd = yd-dimension;
        }


        PintarMuros(ListaMuroCom, g);
        PintarExtras(ListaExtrasCoorCom, g);
        PintarCaminante(rutaher ,g);

        repaint();
    }

    ///////////////////////////////////////////////////////********************** METODOS PINTADO RELATIVO

    //////////////////////////////////////////////// muros recibe n de (nxn) , ruta , lista

    public void PintarMuros(LinkedList<NodoMuroCoor> lista, Graphics g) {

        ///////////////////////////////////////////////// MUROS DEL CENTRO

        for (int cont = 0; cont < lista.size(); cont++) {

            ImageIcon imgi = new ImageIcon(lista.get(cont).getNombre());
            Image imge = imgi.getImage();
            ImageIcon imges = new ImageIcon(imge.getScaledInstance(dimension, dimension, Image.SCALE_SMOOTH));


            if (lista.get(cont).isHorizontal()) {

                for (int i = (lista.get(cont).getIni() * dimension); i < (lista.get(cont).getFin() * dimension); i = i + dimension) {
                    g.drawImage(imges.getImage(), i, lista.get(cont).getCte() * dimension, null);
                }

            } else {

                for (int i = (lista.get(cont).getIni() * dimension); i < (lista.get(cont).getFin() * dimension); i = i + dimension) {
                    g.drawImage(imges.getImage(), lista.get(cont).getCte() * dimension, i, null);
                } }  }
    }
    /////////////////////////////////////////////////////////////////////////// caminante

    public void PintarCaminante(String ruta, Graphics g){

        ImageIcon imgi = new ImageIcon(ruta);
        Image imge = imgi.getImage();
        ImageIcon imges = new ImageIcon(imge.getScaledInstance(dimension,dimension,Image.SCALE_SMOOTH));
        g.drawImage(imges.getImage() , x, y, null);

    }

    //////////////////////////////////////////////////////////////////////////////// pintar extras
    public void PintarExtras(LinkedList<NodoExtrasCoor> lista, Graphics g){


        for(int i = 0; i<lista.size();i++){
            String ruta = lista.get(i).getRuta();



                if(lista.get(i).getTipo().equals("villano")){
            int pos = 0;
            if(mov && mov1){
                pos = lista.get(i).getX() + 1;
                lista.get(i).setX(pos);
                mov = false;
            } else {
                pos = lista.get(i).getX() - 1;
                lista.get(i).setX(pos);
                mov=true;
            }mov1 = true;

                }

            ImageIcon imgi = new ImageIcon(ruta);
            Image imge = imgi.getImage();
            ImageIcon imges = new ImageIcon(imge.getScaledInstance(dimension,dimension,Image.SCALE_SMOOTH));

            g.drawImage(imges.getImage() , lista.get(i).getX()*dimension, lista.get(i).getY()*dimension, null);
        }
    }

    //////////////////////////////////////////////////////////////////////***************  METODOS RESTRICCION RELATIVA

    ////////////////////////////////////////////////////////////////// RESTRICCION DE MUROS
    public void RestringirCentro(LinkedList<NodoMuroCoor> lista){

        for (int cont =0 ; cont < lista.size(); cont++ ){

            if(lista.get(cont).isHorizontal()){
                if(y + yca > lista.get(cont).getCte()*dimension - dimension && y+yca < lista.get(cont).getCte()*dimension + dimension &&
                        x+xca > lista.get(cont).getIni()*dimension-dimension && x+xca < lista.get(cont).getFin()*dimension )
                {yca=0; xca=0;}

            } else {
                if(x + xca > lista.get(cont).getCte()*dimension - dimension && x+xca < lista.get(cont).getCte()*dimension + dimension &&
                        y+yca > lista.get(cont).getIni()*dimension-dimension && y+yca < lista.get(cont).getFin()*dimension )
                {yca=0; xca=0;}

            }
        }
    }

    //////////////////////////////////////////////////////////////// RESTRICCION DE EXTRAS

    public void RestringirExtras(LinkedList<NodoExtrasCoor> lista) {

        for (int i = 0; i < lista.size(); i++) {

            if(x +xca == lista.get(i).getX()*dimension && y+yca == lista.get(i).getY()*dimension){

                String tipo = lista.get(i).getTipo();

                if(tipo.equals("bomba")){
                   intvidajug = intvidajug - lista.get(i).getPuntos();
                    lista.remove(i);
                    i--;
                } else if (tipo.equals("arma")){
                    intvidaenem = intvidaenem - lista.get(i).getPuntos();
                    lista.remove(i);
                    i--;
                } else if (tipo.equals("bonus")){
                    intvidajug = intvidajug + lista.get(i).getPuntos();
                    lista.remove(i);
                    i--;
                } else if (tipo.equals("meta")){
                    VentanaGameOver n = new VentanaGameOver();
                    n.resultadopts.setText("Vida: "+intvidajug+" <----> Enemigo: "+intvidaenem+"");
                    n.lblnombre.setText(nombrejug+" lo ha logrado");
                    n.resultado.setText("FELICIDADES!");
                    lista.clear();
                    timer.stop();
                } else if(tipo.equals("villano")){
                    intvidajug = intvidajug - 5;

                }
            }

        }
    }



    ///////////////////////////////////////////////////////// METODO RUN
    @Override
    public void run() {


        while(running) {

                try {
                    Thread.sleep(tred);
                } catch (InterruptedException ex) {
                }

        }
    }
}