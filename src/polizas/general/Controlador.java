package polizas.general;

import javax.swing.JLabel;
import polizas.marcas.*;

public class Controlador {

    //atributos
    protected Bienvenida vista;
    protected MarcasVista mascasVista;

    //constructor
    public Controlador(Bienvenida vista) {
        this.vista = vista;
        this.eventos();
    }
//metodo

    public void eventos() {
        vista.mensaje.addActionListener(
                e -> vista.c1.show(vista.pc, "mensaje")
        );
        vista.home.addActionListener(e -> {
            vista.pc.add(new JLabel("Panel Home"), "home");
            vista.c1.show(vista.pc, "home");
        });
        vista.marcas.addActionListener(e -> {
            //instancia de marca vista
            this.mascasVista = new MarcasVista();
            new MarcasControl(mascasVista);
            vista.pc.add(mascasVista, "mk");
            vista.c1.show(vista.pc, "mk");
        });

    }
}
