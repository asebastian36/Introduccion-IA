package mx.com.recomendador.service;

import java.sql.SQLException;
import java.util.List;
import mx.com.recomendador.datos.UsuarioDAO;
import mx.com.recomendador.domain.Usuario;

/**
 *
 * @author Angel Franco
 */

public class UsuarioService {
    private static UsuarioDAO repositorio = new UsuarioDAO();
    
    public static List<Usuario> seleccionar() throws SQLException {
        return repositorio.seleccionar();
    }
    
    public static Usuario buscar(int id) throws SQLException {
        return repositorio.buscar(id);
    }
    
    public static void insertar(Usuario usuario) throws SQLException {
        repositorio.insertar(usuario);
    }
    
    public static void actualizar(Usuario usuario) throws SQLException {
        repositorio.actualizar(usuario);
    }
    
    public static void eliminar(Usuario usuario) throws SQLException {
        repositorio.eliminar(usuario);
    }
}
