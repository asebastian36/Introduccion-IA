package mx.com.recomendador.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.com.recomendador.datos.Conexion;
import mx.com.recomendador.datos.RedSocialDAO;
import mx.com.recomendador.domain.RedSocial;

/**
 *
 * @author Angel Franco
 */
public class Test {
    public static void main(String[] args) {
        Connection conexion = null;
        List<RedSocial> redes = new ArrayList<>();
        
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) conexion.setAutoCommit(false);
                
            RedSocialDAO consulta = new RedSocialDAO(conexion);
            redes = consulta.seleccionar();
            
            System.out.println("se ha hecho commit de la transaccion");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
        
        //  testeo cuestionario
        List<String> preguntas = new ArrayList<>();
    }
}
