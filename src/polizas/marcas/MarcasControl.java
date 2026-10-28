package polizas.marcas;

import java.awt.event.MouseAdapter;
import java.util.List;
import javax.swing.JOptionPane;

public class MarcasControl {

    //atributo
    private MarcasVista mv;
    private MarcasModelo mm;
    private List<Marcas> lista;

    //constructor
    public MarcasControl(MarcasVista marcasVista) {
        this.mv = marcasVista;
        this.mm = new MarcasModelo();
        marcasEventos();
    }

    //metodos donde se conectan con los metodos crud
    public void marcasEventos() {
        mv.btn1.addActionListener(
                e -> {
                    lista = mm.read();
                    mv.actualizarVista(lista);
                }
        );

        mv.btn_a.addActionListener(
                e -> {
                    Object marca = new Marcas(0, mv.txt1.getText());
                    JOptionPane.showMessageDialog(null, mm.create(marca));
                    mv.actualizarVista(mm.read());
                }
        );
        mv.btnmd.addActionListener(
                e -> {
                    int fila = mv.tabla.getSelectedRow();
                    Object valorId = mv.tabla.getValueAt(fila, 0);
                    int id = Integer.parseInt(valorId.toString());
                    int resp = mm.delate(id);
                    mv.actualizarVista(mm.read());
                }
        );

        mv.btnmu.addActionListener(e -> {
            int fila = mv.tabla.getSelectedRow();

            Object valorId = mv.tabla.getValueAt(fila, 0);

            int id = Integer.parseInt(valorId.toString());
            String nuevoNombre = mv.txt1.getText();

            Marcas marcaEditar = new Marcas(id, nuevoNombre);
            int resp = mm.update(marcaEditar);
            mv.actualizarVista(mm.read());

            javax.swing.JOptionPane.showMessageDialog(null, "El registro seleccionado no tiene un ID válido.");

            javax.swing.JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila de la tabla primero.");
        });

        mv.tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println("Registro: " + mv.marcasModelo.getValueAt(mv.tabla.getSelectedRow(), 1));
                mv.txt1.setText((String) mv.marcasModelo.getValueAt(mv.tabla.getSelectedRow(), 1));
            }
        }
        );
        mv.tabla.getSelectionModel().addListSelectionListener(
                e -> {
                    if (!e.getValueIsAdjusting()) {
                        int fila = mv.tabla.getSelectedRow();
                        System.out.println("ReGistro: " + fila + " Valor: " + mv.tabla.getValueAt(fila, 1));
                    }
                }
        );
        mv.cmbMarcas.addActionListener(
                e -> {
                    Marcas marca = (Marcas) mv.cmbMarcas.getSelectedItem();
                }
        );
    }

}
