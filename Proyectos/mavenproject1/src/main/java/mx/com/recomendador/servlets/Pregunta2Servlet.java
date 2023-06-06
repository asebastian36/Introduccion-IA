package mx.com.recomendador.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.recomendador.datos.RedSocialDAO;
import mx.com.recomendador.domain.RedSocial;

/**
 *
 * @author Angel Franco
 */
@WebServlet("/Pregunta2")
public class Pregunta2Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String respuesta = request.getParameter("audiencia");
        
        //  pregunta 2
        List<RedSocial> redes = new ArrayList<>();
        RedSocialDAO consulta = new RedSocialDAO();
        redes = consulta.seleccionar();

        Set<RedSocial> filtro1 = redes.stream().filter(red -> red.getAudiencia().toLowerCase().contains(respuesta)).collect(Collectors.toSet());
        Set<String> tematicas = new HashSet<>();
        filtro1.forEach(instancia -> tematicas.add(instancia.getTematica()));
        
        request.setAttribute("tematicas", tematicas);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("pregunta2.jsp");
        dispatcher.forward(request, response);
    }
}
