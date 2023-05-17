package mx.com.recomendador.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.com.recomendador.domain.RedSocial;

/**
 *
 * @author Angel Franco
 */
public class RedSocialDAO {

    private static final String SQL_SELECT_BY_ID = "SELECT nombre, enfoque, contenido, tematica, audiencia, funcionalidades, ruta, descripcion " + "FROM red_social WHERE idredsocial = ?";
    private static final String SQL_SELECT = "SELECT idredsocial, nombre, enfoque, contenido, tematica, audiencia, funcionalidades, ruta, descripcion" + " FROM red_social";
    private static final String SQL_INSERT = "INSERT INTO red_social(nombre, enfoque, contenido, tematica, audiencia, funcionalidades, ruta, descripcion) " + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE red_social " + "SET nombre=?, enfoque=?, contenido=?, tematica=?, audiencia=?, funcionalidades=?, ruta=?, descripcion=? WHERE idredsocial=?";
    private static final String SQL_DELETE = "DELETE FROM red_social WHERE idredsocial=?";
    private Connection conexionTransacciones;

    public RedSocialDAO(Connection conexionTransacciones) {
        this.conexionTransacciones = conexionTransacciones;
    }

    public RedSocialDAO() {
    }

    public List<RedSocial> seleccionar() {
        Connection conexion = null;
        PreparedStatement instruccion = null;
        ResultSet resultado = null;
        List<RedSocial> redes = new ArrayList<>();

        try {
            conexion = this.conexionTransacciones != null ? this.conexionTransacciones : Conexion.getConnection();
            instruccion = conexion.prepareStatement(SQL_SELECT);
            resultado = instruccion.executeQuery();

            while (resultado.next()) {
                RedSocial red = new RedSocial();
                red.setIdRedSocial(resultado.getInt("idredsocial"));
                red.setNombre(resultado.getString("nombre"));
                red.setEnfoque(resultado.getString("enfoque"));
                red.setContenido(resultado.getString("contenido"));
                red.setTematica(resultado.getString("tematica"));
                red.setAudiencia(resultado.getString("audiencia"));
                red.setFuncionalidades(resultado.getString("funcionalidades"));
                red.setRuta(resultado.getString("ruta"));
                red.setDescripcion(resultado.getString("descripcion"));

                redes.add(red);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(resultado);
                Conexion.close(instruccion);
                if (this.conexionTransacciones == null) {
                    Conexion.close(conexion);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return redes;
    }

    public RedSocial buscar(RedSocial red) {
        Connection conexion = null;
        PreparedStatement instruccion = null;
        ResultSet resultado = null;

        try {
            conexion = this.conexionTransacciones != null ? this.conexionTransacciones : Conexion.getConnection();
            instruccion = conexion.prepareStatement(SQL_SELECT_BY_ID);
            instruccion.setInt(1, red.getIdRedSocial());
            resultado = instruccion.executeQuery();

            if(resultado.next()) {
                String nombre = resultado.getString("nombre");
                String enfoque = resultado.getString("enfoque");
                String contenido = resultado.getString("contenido");
                String tematica = resultado.getString("tematica");
                String audiencia = resultado.getString("audiencia");
                String funcionalidades = resultado.getString("funcionalidades");
                String ruta = resultado.getString("ruta");
                String descripcion = resultado.getString("descripcion");

                red.setNombre(nombre);
                red.setEnfoque(enfoque);
                red.setContenido(contenido);
                red.setTematica(tematica);
                red.setAudiencia(audiencia);
                red.setFuncionalidades(funcionalidades);
                red.setRuta(ruta);
                red.setDescripcion(descripcion);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(resultado);
                Conexion.close(instruccion);
                if (this.conexionTransacciones == null) Conexion.close(conexion);
            } catch(SQLException e) {
                e.printStackTrace();
            }
            return red;
        }
    }

    public void insertar(RedSocial red) throws SQLException {
        Connection conexion = null;
        PreparedStatement instruccion = null;

        try {
            conexion = this.conexionTransacciones != null ? this.conexionTransacciones : Conexion.getConnection();
            instruccion = conexion.prepareStatement(SQL_INSERT);

            instruccion.setString(1, red.getNombre());
            instruccion.setString(2, red.getEnfoque());
            instruccion.setString(3, red.getContenido());
            instruccion.setString(4, red.getTematica());
            instruccion.setString(5, red.getAudiencia());
            instruccion.setString(6, red.getFuncionalidades());
            instruccion.setString(7, red.getRuta());
            instruccion.setString(8, red.getDescripcion());

            instruccion.executeUpdate();
        } finally {
            Conexion.close(instruccion);
            if (this.conexionTransacciones == null) {
                Conexion.close(conexion);
            }
        }
    }

    public void actualizar(RedSocial red) {
        Connection conexion = null;
        PreparedStatement instruccion = null;

        try {
            conexion = this.conexionTransacciones != null ? this.conexionTransacciones : Conexion.getConnection();
            instruccion = conexion.prepareStatement(SQL_UPDATE);

            instruccion.setString(1, red.getNombre());
            instruccion.setString(2, red.getEnfoque());
            instruccion.setString(3, red.getContenido());
            instruccion.setString(4, red.getTematica());
            instruccion.setString(5, red.getAudiencia());
            instruccion.setString(6, red.getFuncionalidades());
            instruccion.setString(7, red.getRuta());
            instruccion.setString(8, red.getDescripcion());
            instruccion.setInt(9, red.getIdRedSocial());

            instruccion.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(instruccion);
                if (this.conexionTransacciones == null) {
                    Conexion.close(conexion);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public void eliminar(RedSocial red) throws SQLException {
        Connection conexion = null;
        PreparedStatement instruccion = null;

        try {
            conexion = this.conexionTransacciones != null ? this.conexionTransacciones : Conexion.getConnection();
            instruccion = conexion.prepareStatement(SQL_DELETE);

            instruccion.setInt(1, red.getIdRedSocial());
            instruccion.executeUpdate();

        } finally {
            Conexion.close(instruccion);
            if (this.conexionTransacciones == null) {
                Conexion.close(conexion);
            }
        }
    }
}
