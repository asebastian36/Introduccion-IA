package mx.com.recomendador.datos;

import java.sql.*;

/**
 *
 * @author Angel Franco
 */

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/uaem_introduccion_ia?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "L4c1b0rgv4c4#";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
    
    public static void close(ResultSet resultado) throws SQLException {
        resultado.close();
    }
    
    public static void close(PreparedStatement instruccion) throws SQLException {
        instruccion.close();
    }
    
    public static void close(Statement instruccion) throws SQLException {
        instruccion.close();
    }
    
    public static void close(Connection conexion) throws SQLException {
        conexion.close();
    }    
}
