package mx.com.recomendador.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
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
        try {
            Scanner sc = new Scanner(System.in);
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) conexion.setAutoCommit(false);
            List<RedSocial> redes = new ArrayList<>();
            RedSocialDAO consulta = new RedSocialDAO();
            redes = consulta.seleccionar();
            
            //  1era audiencia, 2da tematica, 3era enfoque, 4ta funcionalidades
            Set<String> audiencias = new HashSet<>();
            redes.forEach(red -> {
                audiencias.add(red.getAudiencia());
            });
            
            audiencias.forEach(System.out::println);
            
            System.out.println("se ha hecho commit de la transaccion");
            
            //  simulacion de respuesta
            Set<RedSocial> first = redes.stream().filter(red -> red.getAudiencia().toLowerCase().contains("jóvenes")).collect(Collectors.toSet());
            first.forEach(opcion -> {
               System.out.println(opcion.getEnfoque());
            });
            System.out.println(first.size());
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
}
