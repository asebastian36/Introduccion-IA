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
import mx.com.recomendador.service.UsuarioService;

/**
 *
 * @author Angel Franco
 */

@WebServlet("/Pregunta3")
public class Pregunta3Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String respuesta = request.getParameter("tematica");

        //  pregunta 3
        ServletContext application = getServletContext();
        Set<RedSocial> redes = (Set<RedSocial>) application.getAttribute("resultados1");

        Set<RedSocial> resultados = redes.stream().filter(red -> red.getTematica().contains(respuesta)).collect(Collectors.toSet());
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
            Set<String> enfoques = new HashSet<>();
            resultados.forEach(red -> enfoques.add(red.getEnfoque()));
            application.setAttribute("resultados2", resultados);
            request.setAttribute("enfoques", enfoques);

            RequestDispatcher dispatcher = request.getRequestDispatcher("pregunta3.jsp");
            dispatcher.forward(request, response);
        }
    }
}
