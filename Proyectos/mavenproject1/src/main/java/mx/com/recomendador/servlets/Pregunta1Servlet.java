package mx.com.recomendador.servlets;

import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mx.com.recomendador.domain.RedSocial;
import mx.com.recomendador.service.RedSocialService;

/**
 *
 * @author Angel Franco
 */

@WebServlet("/Pregunta1")
public class Pregunta1Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  accedo a la bd y obtengo las redes
        List<RedSocial> redes = new ArrayList<>();
        redes = RedSocialService.seleccionar();

        //  1era audiencia, 2da tematica, 3era enfoque, 4ta funcionalidades
        
        //  primera pregunta
        Set<String> audiencias = new HashSet<>();
        redes.forEach(red -> {
            //  para dar formato y no repetir palabras en audiencia
            String[] palabras = red.getAudiencia().toLowerCase().split(",?\\s+(,\\s+)?(y\\s+)?");
            for (String palabra : palabras) audiencias.add(palabra);
        });
        
        //  enviar al jsp
        request.setAttribute("audiencias", audiencias);
        RequestDispatcher dispatcher = request.getRequestDispatcher("pregunta1.jsp");
        dispatcher.forward(request, response);
    }
}
