package polizas.marcas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class MarcasMT extends AbstractTableModel {

//atributos
    protected List<Marcas> marcasLista;
    protected String[] encabezado = {"id", "nombre"};
//metodo

    public MarcasMT() {
        marcasLista = new ArrayList<>();
        this.setColumnNames(encabezado);
    }
//getters

    @Override
    public int getRowCount() {
        return marcasLista.size();
    }

    @Override
    public int getColumnCount() {
        return encabezado.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex != -1) {
            Marcas m = marcasLista.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return m.getId();
                case 1:
                    return m.getNombre();
                default:
                    return null;
            }
        }
        return null;
    }

    @Override
    public String getColumnName(int cantidad) {
        return encabezado[cantidad];
    }
    //Setters

    public void setColumnNames(String[] nuevoNombre) {
        if (nuevoNombre.length == encabezado.length) {
            this.encabezado = nuevoNombre;
            fireTableStructureChanged();
        } else {
            throw new IllegalArgumentException("Valida los campos");
        }
    }

    public Marcas getMarca(int fila) {
        return marcasLista.get(fila);
    }

    public void vaciarLista() {
        marcasLista.clear();
    }

    public void addMarca(Marcas m) {
        marcasLista.add(m);
        fireTableRowsInserted(marcasLista.size() - 1, marcasLista.size() - 1);
    }

    public void updateMarca(int fila, Marcas nueva) {
        marcasLista.set(fila, nueva);
        fireTableRowsUpdated(fila, fila);
    }

    public void removeMarcas(int fila) {
        marcasLista.remove(fila);
        fireTableRowsDeleted(fila, fila);
    }

    public void llenar(List<Marcas> lista) {
        this.marcasLista = lista;
    }

}
