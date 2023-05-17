package mx.com.recomendador.domain;

/**
 *
 * @author Angel Franco
 */

public class Usuario {
    private int recomendacion;
    private int idUsuario;

    public int getRecomendacion() {
        return this.recomendacion;
    }

    public void setRecomendacion(int recomendacion) {
        this.recomendacion = recomendacion;
    }

    public int getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "recomendacion=" + this.recomendacion + ", idUsuario=" + this.idUsuario;
    }
}
