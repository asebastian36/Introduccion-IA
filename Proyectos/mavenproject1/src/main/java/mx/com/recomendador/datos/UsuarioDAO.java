package mx.com.recomendador.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.com.recomendador.domain.Usuario;

/**
 *
 * @author Angel Franco
 */

public class UsuarioDAO {
     private static final String SQL_SELECT_BY_ID = "SELECT idusuario, recomendacion " + "FROM usuario WHERE idusuario = ?";
     private static final String SQL_SELECT = "SELECT idusuario, recomendacion" + " FROM usuario";
     private static final String SQL_INSERT = "INSERT INTO usuario(recomendacion) " + " VALUES(?)";
     private static final String SQL_UPDATE = "UPDATE usuario " + "SET recomendacion=? WHERE idusuario=?";
     private static final String SQL_DELETE = "DELETE FROM usuario WHERE idusuario=?";
     private Connection conexionTransacciones;

    public UsuarioDAO(Connection conexionTransacciones) {
        this.conexionTransacciones = conexionTransacciones;
    }
    
    public UsuarioDAO() {
    }
    
    public List<Usuario> seleccionar() throws SQLException {
        Connection conexion = null;
        PreparedStatement instruccion = null;
        ResultSet resultado = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            conexion = this.conexionTransacciones != null ? this.conexionTransacciones : Conexion.getConnection();
            instruccion = conexion.prepareStatement(SQL_SELECT);
            resultado = instruccion.executeQuery();

            while (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(resultado.getInt("idusuario"));
                usuario.setRecomendacion(resultado.getInt("recomendacion"));
                usuarios.add(usuario);
            }
        } finally {
            Conexion.close(resultado);
            Conexion.close(instruccion);
            if (this.conexionTransacciones == null) {
                Conexion.close(conexion);
            }
        }
        return usuarios;
    }
    
    public Usuario buscar(int id) throws SQLException {
        Connection conexion = null;
        PreparedStatement instruccion = null;
        ResultSet resultado = null;
        Usuario usuario = null;

        try {
            conexion = this.conexionTransacciones != null ? this.conexionTransacciones : Conexion.getConnection();
            instruccion = conexion.prepareStatement(SQL_SELECT_BY_ID);
            instruccion.setInt(1, id);
            resultado = instruccion.executeQuery();

            resultado.absolute(1);
            int idusuario = resultado.getInt("idusuario");
            int recomendacion = resultado.getInt("recomendacion");
            
            usuario.setIdUsuario(idusuario);
            usuario.setRecomendacion(recomendacion);
            
        } finally {
            Conexion.close(resultado);
            Conexion.close(instruccion);
            if (this.conexionTransacciones == null) {
                Conexion.close(conexion);
            }
        }
        return usuario;
    }
    
    public void insertar(Usuario usuario) throws SQLException  {
        Connection conexion = null;
        PreparedStatement instruccion = null;

        try {
            conexion = this.conexionTransacciones != null ? this.conexionTransacciones : Conexion.getConnection();
            instruccion = conexion.prepareStatement(SQL_INSERT);
            instruccion.setInt(1, usuario.getRecomendacion());
            instruccion.executeUpdate();
            
        } finally {
            Conexion.close(instruccion);
            if (this.conexionTransacciones == null) {
                Conexion.close(conexion);
            }
        }
    }
    
    public void actualizar(Usuario usuario) throws SQLException {
        Connection conexion = null;
        PreparedStatement instruccion = null;

        try {
            conexion = this.conexionTransacciones != null ? this.conexionTransacciones : Conexion.getConnection();
            instruccion = conexion.prepareStatement(SQL_UPDATE);

            instruccion.setInt(1, usuario.getRecomendacion());
            instruccion.setInt(2, usuario.getIdUsuario());
            instruccion.executeUpdate();
            
        } finally {
            Conexion.close(instruccion);
            if (this.conexionTransacciones == null) {
                Conexion.close(conexion);
            }
        }
    }
    
    public void eliminar(Usuario usuario) throws SQLException {
        Connection conexion = null;
        PreparedStatement instruccion = null;

        try {
            conexion = this.conexionTransacciones != null ? this.conexionTransacciones : Conexion.getConnection();
            instruccion = conexion.prepareStatement(SQL_DELETE);

            instruccion.setInt(1, usuario.getIdUsuario());
            instruccion.executeUpdate();
            
        } finally {
            Conexion.close(instruccion);
            if (this.conexionTransacciones == null) {
                Conexion.close(conexion);
            }
        }
    }
}    
