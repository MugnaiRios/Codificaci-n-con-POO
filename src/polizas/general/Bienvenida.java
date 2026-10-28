package polizas.general;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Bienvenida extends JFrame {
    //Atributos

    protected JMenuBar bm;
    protected JMenu miArchivo, mBD;
    protected JMenuItem home, mensaje, marcas, mBD_C, mBD_r, mBD_u, mBD_d;
    protected JPanel pi, pd, ps, pc;
    protected CardLayout c1;

    // constructor
    public Bienvenida() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.menu();

        JLabel titulo = new JLabel("Sistema de Gestion....");
        titulo.setForeground(Color.white);
        Font fuente = new Font("Arial", Font.BOLD, 18);
        titulo.setFont(fuente);
        
        //panel izquierod
        pi = new JPanel();
        pi.setBackground(Color.blue);
        pi.add(new JLabel("Panel izquiersdo"));
        pi.setPreferredSize(new Dimension(200, getHeight()));

        this.add(pi, BorderLayout.WEST);

        //panel derecho
        pd = new JPanel();
        pd.setBackground(Color.red);
        pd.add(new JLabel("Panel derecho"));
        pd.setPreferredSize(new Dimension(200, getHeight()));

        this.add(pd, BorderLayout.EAST);
        
        c1 = new CardLayout();
        
        //panel superior
        ps = new JPanel();
        ps.setBackground(Color.green);
        ps.add(titulo);
        this.add(ps, BorderLayout.NORTH);
        
       //panel central
        pc = new JPanel(c1);
        pc.add(new JLabel("Welcome to java...."));
        pc.add(new Mensaje(), "mensaje");
        this.add(pc, BorderLayout.CENTER);
  
        
        this.setVisible(true);
       
        
    }
    // metodo para los menus
    public void menu() {
        bm = new JMenuBar();
        this.setJMenuBar(bm);

        miArchivo = new JMenu("Archivo");
        bm.add(miArchivo);

        home = new JMenuItem("HOME");
        miArchivo.add(home);

        mensaje = new JMenuItem("MENSAJE");
        miArchivo.add(mensaje);

        mBD = new JMenu("Base de datos");
        bm.add(mBD);

        marcas = new JMenuItem("MARCAS");
        mBD.add(marcas);
    }
}
