import javax.swing.*;
import java.awt.*;

/**
 * Created by lezs on 19/03/15.
 */
public class VentanaGame extends JFrame {

    JFrame ven = new JFrame("Maze Game");
    Grafico pnl = new Grafico();

    JLabel lblnombre = new JLabel(pnl.nombrejug);

    public VentanaGame(){
        ven.setSize(700, 725);
        ven.setLocationRelativeTo(this);
        ven.setResizable(false);
        ven.getContentPane().setBackground(Color.DARK_GRAY);
        ven.setLayout(null);

        ven.add(pnl);
        ven.add(lblnombre);
        ven.add(pnl.vidaenemigo);
        ven.add(pnl.vidajug);

        lblnombre.setBounds(25, 10, 200, 20);
        lblnombre.setForeground(Color.white);
        lblnombre.setFont(new Font("Arial Rounded", Font.BOLD, 20));

        pnl.vidajug.setBounds(250, 10, 200, 20);
        pnl.vidajug.setForeground(Color.white);
        pnl.vidajug.setFont(new Font("Arial Rounded", Font.BOLD, 20));

        pnl.vidaenemigo.setBounds(500, 10, 200, 20);
        pnl.vidaenemigo.setForeground(Color.white);
        pnl.vidaenemigo.setFont(new Font("Arial Rounded", Font.BOLD, 20));

        pnl.setBounds(25, 40, 650, 650);
        ven.setVisible(true);
    }
}
