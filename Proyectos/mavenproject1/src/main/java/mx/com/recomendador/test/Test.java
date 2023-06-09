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
            
            //  primera pregunta
            Set<String> audiencias = new HashSet<>();
            redes.forEach(red -> {
                String[] palabras = red.getAudiencia().toLowerCase().split(",?\\s+(,\\s+)?(y\\s+)?");
                for(String palabra : palabras) audiencias.add(palabra);
            });
            // mostrar las audiencias
            audiencias.forEach(System.out::println);
            System.out.println("");
            System.out.println("copia y pega la opcion deseada: ");
            String respuesta = sc.next();
            System.out.println("");
            
            //  primer filtro
            //  segunda pregunta
            Set<RedSocial> filtro1 = redes.stream().filter(red -> red.getAudiencia().toLowerCase().contains(respuesta)).collect(Collectors.toSet());
            Set<String> tematicas = new HashSet<>();
            filtro1.forEach(instancia -> tematicas.add(instancia.getTematica()));
            
            //  mostrar tematicas filtradas
            tematicas.forEach(System.out::println);
            System.out.println("");
            System.out.println("copia y pega la opcion deseada: ");
            String respuesta1 = sc.next();
            System.out.println("");
            
            //  tercer pregunta
            Set<RedSocial> filtro2 = filtro1.stream().filter(red -> red.getTematica().contains(respuesta1)).collect(Collectors.toSet());
            if(filtro2.size() == 1) System.out.println("Tu red social predilecta es: " + filtro2);
            else {
                Set<String> enfoques = new HashSet<>();
                filtro2.forEach(instancia -> enfoques.add(instancia.getEnfoque()));
                enfoques.forEach(System.out::println);
                System.out.println("");
                System.out.println("copia y pega la opcion deseada: ");
                String respuesta2 = sc.next();
                System.out.println("");
                
                //  cuarta pregunta
                Set<RedSocial> filtro3 = redes.stream().filter(red -> red.getEnfoque().contains(respuesta2)).collect(Collectors.toSet());
                if(filtro3.size() == 1) System.out.println("Tu red social predilecta es: " + filtro3);
                else {
                    Set<String> funcionalidades = new HashSet<>();
                    filtro2.forEach(instancia -> enfoques.add(instancia.getFuncionalidades()));
                    enfoques.forEach(System.out::println);
                    System.out.println("");
                    System.out.println("copia y pega la opcion deseada: ");
                    String respuesta4 = sc.next();
                    System.out.println("");
                }
            }
            
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
