import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

/**
 * Created by lezs on 26/03/15.
 */
public class VentanaGameOver extends JFrame{

    JFrame ven = new JFrame("Game Over");

    String res;
    String nombre;
    String respts;

    JLabel resultado = new JLabel(res);
    JLabel lblnombre = new JLabel(nombre);
    JLabel resultadopts = new JLabel(respts);

    JButton btnvolver = new JButton("Volver");
    JButton btnsalir = new JButton("Salir");

    public VentanaGameOver(){

        ven.setSize(300, 300);
        ven.setLocationRelativeTo(this);
        ven.setResizable(false);
        ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ven.getContentPane().setBackground(Color.DARK_GRAY);
        ven.setLayout(null);

        ven.add(resultado);
        ven.add(resultadopts);
        ven.add(btnsalir);
        ven.add(btnvolver);
        ven.add(lblnombre);

        resultado.setBounds(80, 50, 200, 75);
        resultado.setForeground(Color.white);
        resultado.setFont(new Font("Arial Rounded", Font.BOLD, 20));

        lblnombre.setBounds(70, 100, 200, 75);
        lblnombre.setForeground(Color.white);
        lblnombre.setFont(new Font("Arial Rounded", Font.BOLD, 15));

        resultadopts.setBounds(60, 150, 200, 50);
        resultadopts.setForeground(Color.white);
        resultadopts.setFont(new Font("Arial Rounded", Font.BOLD, 11));

        btnsalir.setBounds(30, 225, 100, 30);
        btnvolver.setBounds(160, 225, 100, 30);
        ven.setVisible(true);

        btnvolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Ventana n = new Ventana();
                ven.setVisible(false);

            }
        });

        btnsalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               System.exit(0);

            } });

    }
}
