package mx.com.recomendador.domain;

/**
 *
 * @author Angel Franco
 */

public class RedSocial {
    private int idRedSocial;
    private String nombre;
    private String enfoque;
    private String contenido;
    private String tematica;
    private String audiencia;
    private String funcionalidades;
    private String ruta;
    private String descripcion;
    
    public RedSocial(int id) {
        this.idRedSocial = id;
    }
    
    public RedSocial() {
    }

    public int getIdRedSocial() {
        return this.idRedSocial;
    }

    public void setIdRedSocial(int idRedSocial) {
        this.idRedSocial = idRedSocial;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEnfoque() {
        return this.enfoque;
    }

    public void setEnfoque(String enfoque) {
        this.enfoque = enfoque;
    }

    public String getContenido() {
        return this.contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTematica() {
        return this.tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public String getAudiencia() {
        return this.audiencia;
    }

    public void setAudiencia(String audiencia) {
        this.audiencia = audiencia;
    }

    public String getFuncionalidades() {
        return this.funcionalidades;
    }

    public void setFuncionalidades(String funcionalidades) {
        this.funcionalidades = funcionalidades;
    }

    public String getRuta() {
        return this.ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("idRedSocial = ").append(idRedSocial);
        sb.append(", nombre = ").append(nombre).append("\n");
        sb.append(", enfoque = ").append(enfoque).append("\n");
        sb.append(", contenido = ").append(contenido).append("\n");
        sb.append(", tematica = ").append(tematica).append("\n");
        sb.append(", audiencia = ").append(audiencia).append("\n");
        sb.append(", funcionalidades = ").append(funcionalidades).append("\n");
        sb.append(", ruta = ").append(ruta);
        sb.append(", descripcion = ").append(descripcion).append("\n");
        return sb.toString();
    }
    
    
}
