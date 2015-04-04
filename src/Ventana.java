import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by lezs on 19/03/15.
 */
public class Ventana extends JFrame {

    Datos d = new Datos();

    int contimag = 0;
    String rutaarchivo = "";


    String rutaimagen = "img/nodisponible.png";


    ImageIcon imgicelemento = new javax.swing.ImageIcon(getClass().getResource(rutaimagen));
    Image imgelemento = imgicelemento.getImage();
    ImageIcon imgescelemento = new ImageIcon(imgelemento.getScaledInstance(150,200,Image.SCALE_SMOOTH));

    String nombre = "";
    String ruta;

    JLabel lblimaelemento = new JLabel();

    JFrame ven = new JFrame("Maze Game");

    JMenuBar barra = new JMenuBar();

    JLabel lblerrores = new JLabel("Errores");
    JLabel lblpersonajes = new JLabel("Seleccione un Elemento");

    JButton btnanterior = new JButton("Anterior");
    JButton btnsiguiente = new JButton("Siguiente");
    JButton btnmdatos = new JButton("Mostrar Datos");

    JPanel pnlpersonajes = new JPanel(null);

    JMenu archivo = new JMenu("Archivo");
    JMenu ejecutar = new JMenu("Ejecutar");
    JMenu ayuda = new JMenu("Ayuda");

    JMenuItem optabrir = new JMenuItem("Abrir");
    JMenuItem optnuevo = new JMenuItem("Nuevo");
    JMenuItem optguardar = new JMenuItem("Guardar");
    JMenuItem optguardarcomo = new JMenuItem("Guardar Como");
    JMenuItem optsalir = new JMenuItem("Salir");

    JMenuItem optconfig = new JMenuItem("Analizar Configuracion");
    JMenuItem optescenario = new JMenuItem("Analizar Escenario");
    JMenuItem optejecutar = new JMenuItem("Run");
    JMenuItem opterrores = new JMenuItem("Errores");
    JMenuItem opttabla = new JMenuItem("Tabla De Simbolos");

    JMenuItem optManualU = new JMenuItem("Manual de Usuario");
    JMenuItem optManualT = new JMenuItem("Manual Técnico");
    JMenuItem optAcercaD = new JMenuItem("Acerca de");

    JTextArea txtEditor = new JTextArea("");
    JTextArea txtErrores = new JTextArea("");
    JTextArea txtDetalles = new JTextArea("");

    JFileChooser fc = new JFileChooser();


    public Ventana() {

        JScrollPane scroll = new JScrollPane(txtEditor);
        JScrollPane scrollerrores = new JScrollPane(txtErrores);
        ven.setSize(950, 665);
        ven.setLocationRelativeTo(this);
        ven.setResizable(false);
        ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ven.getContentPane().setBackground(Color.DARK_GRAY);
        ven.setLayout(null);

       lblimaelemento.setIcon(imgescelemento);

        pnlpersonajes.setBounds(20,10, 250,610);

        pnlpersonajes.setBackground(Color.black);


        pnlpersonajes.add(lblpersonajes);
        pnlpersonajes.add(lblimaelemento);
        pnlpersonajes.add(btnanterior);
        pnlpersonajes.add(btnsiguiente);
        pnlpersonajes.add(btnmdatos);
        pnlpersonajes.add(txtDetalles);

        lblpersonajes.setBounds(40, 5, 200, 30);
        lblpersonajes.setForeground(Color.white);

        lblimaelemento.setBounds(50, 40, 150, 200);

        lblerrores.setBounds(300, 420, 100, 30);
        lblerrores.setForeground(Color.white);

        btnanterior.setBounds(10, 255, 110, 30);
        btnsiguiente.setBounds(130, 255, 110, 30);
        btnmdatos.setBounds(10 ,295, 230, 30);

        txtDetalles.setBounds(10, 350, 230, 250);
        txtDetalles.setBackground(Color.DARK_GRAY);
        txtDetalles.setForeground(Color.white);
        txtDetalles.setMargin(new Insets(10, 20, 30, 40));
        txtDetalles.setFont(new Font("Arial Rounded", Font.PLAIN, 15));
        //
        txtEditor.setBounds(300, 10, 625, 400);
        scroll.setBounds(new Rectangle(300, 10, 625, 400));
        txtEditor.setBackground(Color.black);
        txtEditor.setForeground(Color.white);

       // txtEditor.setEditable(false);

        //
        txtErrores.setBounds(300, 445, 625, 175);
        scrollerrores.setBounds(new Rectangle(300, 445, 625, 175));
        txtErrores.setBackground(Color.black);
        txtErrores.setForeground(Color.white);
        txtErrores.setEditable(false);


        ven.setJMenuBar(barra);
        ven.getContentPane().add(scroll, BorderLayout.CENTER);
        ven.getContentPane().add(scrollerrores, BorderLayout.CENTER);
        ven.add(lblerrores);
        ven.add(pnlpersonajes);


        barra.add(archivo);
        barra.add(ejecutar);
        barra.add(ayuda);

        archivo.add(optnuevo);
        archivo.add(optabrir);
        archivo.add(optguardar);
        archivo.add(optguardarcomo);
        archivo.add(optsalir);

        ejecutar.add(optejecutar);
        ejecutar.add(optconfig);
        ejecutar.add(optescenario);
        ejecutar.add(opterrores);
        ejecutar.add(opttabla);

        ayuda.add(optManualU);
        ayuda.add(optManualT);
        ayuda.add(optAcercaD);

        ven.setVisible(true);



        //////////////////////////////////////////////////////////////  BOTONES

        btnmdatos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                datos();
            }
        });

        btnsiguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblimaelemento.setIcon(imgescelemento);
                contimag++;
                if(contimag > d.ListaPersonajes.size()){contimag--;}
               datos();
            } });

        btnanterior.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblimaelemento.setIcon(imgescelemento);
                if(contimag < 0){contimag++;}
                contimag--;
                datos();
            } });

        ///////////////////////////////////////////////////////////// OPCIONES

        optejecutar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            VentanaGame n = new VentanaGame();
                ven.setVisible(false);

            } });

        ////////////////////////////////+++++++++++++++++++++++++++++ ABRIR
        optabrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nombre = "";
                try {
                    fc.showSaveDialog(fc);
                    int rest = fc.APPROVE_OPTION;
                    if (rest == JFileChooser.APPROVE_OPTION) {
                        File o = fc.getSelectedFile();
                        String b = o.toString();
                        String nombre2 = o.getName();
                        char[] nuevo = nombre2.toCharArray();
                        for (int i = 0; i < (nuevo.length - 6); i++) {
                            nombre = nombre + nuevo[i];
                        }
                        txtEditor.setText(leer(b));
                        ruta = o.getParent();
                        rutaarchivo = ruta+"/"+nombre+".xconf";
                    }
                    txtEditor.setEditable(true);
                } catch (Exception m){}
            }
        });

        //////////////////////////////////////+++++++++++++++++++++++++++++++ GUARDAR

        optguardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try{
                    escribir(nombre, ruta, txtEditor.getText());
                    rutaarchivo = ruta+"/"+nombre+".xconf";
                    JOptionPane.showMessageDialog(ven, "Los cambios han sido guardados");

                }catch (Exception l){

                    JOptionPane.showMessageDialog(ven,
                            "Error al guardar",
                            "Inane error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        ///////////////////////////////////////////////++++++++++++++++ NUEVO
        optnuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    nombre = JOptionPane.showInputDialog("Ingrese el nombre con el \nque desea guardar el archivo");
                    fc.showSaveDialog(fc);
                    int rest = fc.APPROVE_OPTION;
                    if(rest==JFileChooser.APPROVE_OPTION)
                    {
                        File o=fc.getSelectedFile();
                        ruta = o.getParent();
                        rutaarchivo = ruta+"/"+nombre+".xconf";
                    }
                    escribir(nombre, ruta, " ");
                    txtEditor.setEditable(true); }
                catch (Exception f){
                    JOptionPane.showMessageDialog(ven,
                            "Error al guardar",
                            "Inane error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        /////////////////////////////////++++++++++++++++++++++ GUARDAR COMO

        optguardarcomo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    nombre = JOptionPane.showInputDialog("Ingrese el nombre con el \nque desea guardar el archivo");
                    fc.showSaveDialog(fc);
                    int rest = fc.APPROVE_OPTION;
                    if(rest==JFileChooser.APPROVE_OPTION)
                    {
                        File o=fc.getSelectedFile();
                        ruta = o.getParent();
                        rutaarchivo = ruta+"/"+nombre+".xconf";
                    }
                    escribir(nombre, ruta, txtEditor.getText());
                    txtEditor.setEditable(true); }
                catch (Exception f){
                    JOptionPane.showMessageDialog(ven,
                            "Error al guardar",
                            "Inane error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        ///////////////////////////////////////////////////////////////////////////////// Opcines de ejecucion

        optconfig.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    d.ListaFondos.clear();
                    d.ListaPersonajes.clear();
                    d.ListaExtras.clear();

                    new Parser(new Scanner(new FileInputStream(rutaarchivo))).parse();
                    txtErrores.setText(d.errores);

                    if(d.errores.isEmpty()){
                        JOptionPane.showMessageDialog(ven, "Archivo analizado exitosamente");
                    } else {
                        JOptionPane.showMessageDialog(ven, "El archivo contiene errores");
                    }
                    d.errores = "";
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(ven, "Ha ocurrido un error con el archivo");
                    e1.printStackTrace();

                }
            } });

        optescenario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    d.ListaExtrasCoor.clear();
                    d.ListaMuro.clear();

                    new Parser2(new Scanner2(new FileInputStream(rutaarchivo))).parse();
                    txtErrores.setText(d.errores);

                    if(d.errores.isEmpty()){
                        JOptionPane.showMessageDialog(ven, "Archivo analizado exitosamente");
                    } else {
                        JOptionPane.showMessageDialog(ven, "El archivo contiene errores");
                    }
                    d.errores = "";
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(ven, "Ha ocurrido un error con el archivo");
                    e1.printStackTrace();
                }
            } });

    } //////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////// termina constructor

    /////////////////////////////////////////////////////// metodo para mostrar datos

    public void datos(){
        String detalle = "";

        try{
            if (contimag >= 0 && contimag < d.ListaPersonajes.size()){
              String  rut = d.ListaPersonajes.get(contimag).getRuta();

                try {

                    ImageIcon imgicelemento = new javax.swing.ImageIcon(rut);
                    Image imgelemento = imgicelemento.getImage();
                    ImageIcon icnt = new ImageIcon(imgelemento.getScaledInstance(150,200,Image.SCALE_SMOOTH));

                    lblimaelemento.setIcon(icnt);

                }catch (Exception e){}

                String desc = "";
                int contp = 0;
                char[] arr = d.ListaPersonajes.get(contimag).getDescripcion().toCharArray();
                for(int i=0; i<arr.length;i++){
                    if(arr[i]==' '){contp++;}
                    if(contp == 3){
                        desc = desc +"\n"+ arr[i];
                        contp = 0;}
                    desc = desc + arr[i];
                }

                detalle = "Nombre: "+d.ListaPersonajes.get(contimag).getNombre()+
                          "\nVida: "+d.ListaPersonajes.get(contimag).getVida()+
                          "\nDescripcion: \n"+desc;
            }

        }catch (Exception e){  }

        txtDetalles.setText(detalle);
    }


    //////////////////////////////////////////////////////// metodo para leer
    public String leer(String nombre){

        try{File f;
            FileReader lectorArchivo;

            f = new File(nombre);
            lectorArchivo = new FileReader(f);
            BufferedReader br = new BufferedReader(lectorArchivo);

            String l="";
            String aux;

            while(true)
            {   aux=br.readLine();
                if(aux!=null)  l=l+aux+"\n";
                else break;}

            br.close();
            lectorArchivo.close();
            return l;

        }catch(IOException e){
            System.out.println("Error:"+e.getMessage());}
        return null;}

    ////////////////////////////////////////////////////////////// metodo actualizar


    public void escribir(String nombreArchivo, String ruta, String contenido)
    {

        File f;
        f = new File(ruta+"/"+nombreArchivo+".xconf");

        try{
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.write(contenido);

            wr.close();
            bw.close();

        }catch(IOException e){}
    }


}
