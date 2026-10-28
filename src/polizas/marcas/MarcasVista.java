package polizas.marcas;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import polizas.marcas.MarcasMT;

public class MarcasVista extends JPanel {
    
    //atributos
    protected JButton btn1, btn_a, btnmd, btnmu;
    protected JTextField txt1;
    protected JLabel lbl1, lbl2;

    protected JTable tabla;
    protected MarcasMT marcasModelo;
    protected String[] columnas = {"id", "nombre"};

    protected JComboBox cmbMarcas;
    
    //constructor

    public MarcasVista() {
        setLayout(null);
        //titulos
        this.lbl1 = new JLabel("Welcome to Marcas Admin.");
        lbl1.setBounds(350, 40, 150, 30);

        this.lbl2 = new JLabel("Ingresa tu nombre: ");
        lbl2.setBounds(50, 40, 150, 30);

        //texto
        this.txt1 = new JTextField("Marca 1");
        txt1.setBounds(170, 40, 150, 30);
        
        this.cmbMarcas = new JComboBox();
        cmbMarcas.setBounds(500, 40, 250, 30);

        //botones
        this.btn1 = new JButton("Consultar");
        btn1.setBounds(150, 90, 100, 30);

        this.btn_a = new JButton("Agregar");
        btn_a.setBounds(250, 90, 100, 30);

        this.btnmu = new JButton("Actualizar");
        btnmu.setBounds(350, 90, 100, 30);

        this.btnmd = new JButton("Eliminar");
        btnmd.setBounds(450, 90, 100, 30);
        
        //tabla
        this.marcasModelo = new MarcasMT();
        marcasModelo.fireTableDataChanged();

        this.tabla = new JTable(marcasModelo);
        JScrollPane sc = new JScrollPane(tabla);
        sc.setBounds(200, 150, 800, 500);
        
        //todos los add
        this.add(sc, BorderLayout.CENTER);
        this.add(cmbMarcas);
        this.add(btn1);
        this.add(btn_a);
        this.add(btnmu);
        this.add(btnmd);
        this.add(lbl1);
        this.add(lbl2);
        this.add(txt1);
 
    }

    //metodo borra tabla
    public void actualizarVista(List<Marcas> lista) {
        marcasModelo.vaciarLista();
        marcasModelo.fireTableDataChanged();
        marcasModelo.llenar(lista);

        cmbMarcas.removeAllItems();
        for (Marcas m : lista) {
            cmbMarcas.addItem(m);
        }
    }

}
