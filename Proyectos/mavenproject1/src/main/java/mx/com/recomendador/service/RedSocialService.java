package mx.com.recomendador.service;

import java.sql.SQLException;
import java.util.List;
import mx.com.recomendador.datos.RedSocialDAO;
import mx.com.recomendador.domain.RedSocial;

/**
 *
 * @author Angel Franco
 */

public class RedSocialService {
    private static RedSocialDAO repositorio = new RedSocialDAO();
    
    public static List<RedSocial> seleccionar() {
        return repositorio.seleccionar();
    }
    
    public static RedSocial buscar(RedSocial red) {
        return repositorio.buscar(red);
    }
    
    public static void actualizar(RedSocial red) {
        repositorio.actualizar(red);
    }
    
    public static void eliminar(RedSocial red) throws SQLException {
        repositorio.eliminar(red);
    }
}
