package wxlter97;

import com.mysql.jdbc.Driver;
import java.io.Serializable;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion implements Serializable {

    private String url = "jdbc:mysql://localhost:3306/analisisFinanciero";
    private String login = "root";
    private String password = "12345";
    private Connection cnx = null;
    protected ResultSet rsts = null;
    protected Statement sttm = null;
    protected ResultSet rst = null;

    public Connection conexion() throws SQLException {

        DriverManager.registerDriver(new Driver());
        cnx = DriverManager.getConnection(url, login, password);
        return cnx;

    }

    public void closeConexion() {
        try {
            cnx.close();
            sttm.close();
            rst.close();
        } catch (Exception e) {
        }
    }

}
