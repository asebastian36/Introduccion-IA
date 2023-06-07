package mx.com.recomendador.servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.recomendador.domain.RedSocial;

/**
 *
 * @author Angel Franco
 */

@WebServlet("/Pregunta3")
public class Pregunta3Servlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String respuesta = request.getParameter("tematica");
        
        //  pregunta 3
        ServletContext application = getServletContext();
        Set<RedSocial> redes = (Set<RedSocial>) application.getAttribute("resultadosAudiencia");

        Set<RedSocial> resultados = redes.stream().filter(red -> red.getTematica().toLowerCase().contains(respuesta)).collect(Collectors.toSet());
        if(resultados.size() == 1) {
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("resultado.jsp");
            dispatcher.forward(request, response);
        } else {
            Set<String> enfoques = new HashSet<>();
            resultados.forEach(red -> enfoques.add(red.getEnfoque()));
            application.setAttribute("resultadosEnfoque", resultados);
            request.setAttribute("enfoques", enfoques);

            RequestDispatcher dispatcher = request.getRequestDispatcher("pregunta3.jsp");
            dispatcher.forward(request, response);
        }
    }
}
