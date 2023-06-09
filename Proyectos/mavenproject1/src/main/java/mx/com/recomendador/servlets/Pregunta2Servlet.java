package mx.com.recomendador.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mx.com.recomendador.domain.RedSocial;
import mx.com.recomendador.domain.Usuario;
import mx.com.recomendador.service.RedSocialService;
import mx.com.recomendador.service.UsuarioService;

/**
 *
 * @author Angel Franco
 */

@WebServlet("/Pregunta2")
public class Pregunta2Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  obtener respuesta
        String respuesta = request.getParameter("audiencia");
        
        //  pregunta 2, obtener las opciones anteriores
        List<RedSocial> redes = new ArrayList<>();
        redes = RedSocialService.seleccionar();

        //  filtrarlas por la opcion elegida
        Set<RedSocial> resultados = redes.stream().filter(red -> red.getAudiencia().toLowerCase().contains(respuesta)).collect(Collectors.toSet());
        if(resultados.size() == 1) {
            try {
                Usuario usuario = new Usuario();
                usuario.setRecomendacion(resultados.iterator().next().getIdRedSocial());
                UsuarioService.insertar(usuario);
                request.setAttribute("resultadoFinal", resultados);
                RequestDispatcher dispatcher = request.getRequestDispatcher("resultado.jsp");
                dispatcher.forward(request, response);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            Set<String> tematicas = new HashSet<>();
            resultados.forEach(red -> tematicas.add(red.getTematica()));

            //  aqui agregare las respuestas
            ServletContext application = getServletContext();
            application.setAttribute("resultados1", resultados);

            request.setAttribute("tematicas", tematicas);

            RequestDispatcher dispatcher = request.getRequestDispatcher("pregunta2.jsp");
            dispatcher.forward(request, response);
        }
    }
}
