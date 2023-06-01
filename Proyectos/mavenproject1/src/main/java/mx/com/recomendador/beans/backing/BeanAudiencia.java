package mx.com.recomendador.beans.backing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import mx.com.recomendador.datos.RedSocialDAO;
import mx.com.recomendador.domain.RedSocial;

/**
 *
 * @author Angel Franco
 */

@ManagedBean
@RequestScoped
public class BeanAudiencia {
    private String respuesta;
    private Set<String> audiencias;

    public BeanAudiencia() {
        audiencias = new HashSet<>();
        List<RedSocial> redes = new ArrayList<>();
        RedSocialDAO consulta = new RedSocialDAO();
        redes = consulta.seleccionar();
        redes.forEach(red -> {
            String[] palabras = red.getAudiencia().toLowerCase().split(",?\\s+(,\\s+)?(y\\s+)?");
            for (String palabra : palabras) audiencias.add(palabra);
        });
    }

    public Set<String> getAudiencias() {
        return audiencias;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
}
