
package polizas.general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
    //atributos
    public Connection cnx;
    public PreparedStatement ps;
    public ResultSet rs;

       //metodos
    public void conectar() {
        try {
            cnx = DriverManager.getConnection("jdbc:mysql://localhost/polizas", "root", "");
        } catch (SQLException ex) {
            System.getLogger("Error de conexion.");
        }

    }

    public void close() {
        try {
            cnx.close();
        } catch (SQLException ex) {
            System.getLogger(Conexion.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

}
