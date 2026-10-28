package polizas.marcas;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import polizas.general.*;

public class MarcasModelo extends Conexion implements DAO {

    //atributos
    public MarcasModelo() {
        super();
    }
    
    //metodos crud
    @Override
    public List read() {
        List<Marcas> lista = new ArrayList<>();
        try {

            this.conectar();
            ps = cnx.prepareStatement("SELECT * FROM marcas");
            rs = ps.executeQuery();
            //lista.clear();
            while (rs.next()) {
                lista.add(new Marcas(rs.getInt("id"), rs.getString("nombre")));
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                cnx.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        return lista;
    }

    @Override
    public int create(Object obj) {
        try {
            this.conectar();
            Marcas marca = (Marcas) obj;
            ps = cnx.prepareStatement("insert into marcas(nombre) values (?) ");
            ps.setString(1, marca.getNombre());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                cnx.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        return 1;
    }

    @Override
    public int update(Object lista) {
        try {
            this.conectar();
            Marcas marca = (Marcas) lista;
            ps = cnx.prepareStatement("UPDATE marcas SET nombre = ? WHERE id = ?");
            ps.setString(1, marca.getNombre());
            ps.setInt(2, marca.getId());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                cnx.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        return 1;
    }

    @Override
    public int delate(Object obj) {
        try {
            this.conectar();
            int id = (int) obj;
            ps = cnx.prepareStatement("DELETE FROM marcas WHERE id = ?");
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar: " + ex.getMessage());
        } finally{
            try {
                cnx.close();
            } catch (SQLException ex) {
            System.out.println("Error al eliminar: " + ex.getMessage());
            }
        }
        return 1;
    }

}
