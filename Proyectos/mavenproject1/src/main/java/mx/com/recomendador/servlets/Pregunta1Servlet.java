package mx.com.recomendador.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
@WebServlet("/Pregunta1")
public class Pregunta1Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RedSocial> redes = new ArrayList<>();
        RedSocialDAO consulta = new RedSocialDAO();
        redes = consulta.seleccionar();

        //  1era audiencia, 2da tematica, 3era enfoque, 4ta funcionalidades
        //  primera pregunta
        Set<String> audiencias = new HashSet<>();
        redes.forEach(red -> {
            String[] palabras = red.getAudiencia().toLowerCase().split(",?\\s+(,\\s+)?(y\\s+)?");
            for (String palabra : palabras) audiencias.add(palabra);
        });
        
        request.setAttribute("audiencias", audiencias);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("pregunta1.jsp");
        dispatcher.forward(request, response);
    }
}
