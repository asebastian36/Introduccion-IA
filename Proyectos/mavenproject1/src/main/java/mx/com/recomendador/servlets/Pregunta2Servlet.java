package mx.com.recomendador.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
        //  obtener respuesta
        String respuesta = request.getParameter("audiencia");
        
        //  pregunta 2, obtener las opciones anteriores
        List<RedSocial> redes = new ArrayList<>();
        RedSocialDAO consulta = new RedSocialDAO();
        redes = consulta.seleccionar();

        //  filtrarlas por la opcion elegida
        Set<RedSocial> resultados = redes.stream().filter(red -> red.getAudiencia().toLowerCase().contains(respuesta)).collect(Collectors.toSet());
        Set<String> tematicas = new HashSet<>();
        resultados.forEach(red -> tematicas.add(red.getTematica()));
        
        //  aqui agregare las respuestas
        ServletContext application = getServletContext();
        application.setAttribute("resultadosAudiencia", resultados);

        request.setAttribute("tematicas", tematicas);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("pregunta2.jsp");
        dispatcher.forward(request, response);
    }
}
