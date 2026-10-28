package polizas;

import polizas.general.Bienvenida;
import javax.swing.SwingUtilities;
import polizas.general.Controlador;

public class Inicio {

    //Atributods
   private Bienvenida vista;
    private Controlador controlador;

    //consttructor
    Inicio() {
        //Bienvenida instancia
        vista = new Bienvenida();
        controlador = new Controlador(vista);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Inicio::new);
    }
}
