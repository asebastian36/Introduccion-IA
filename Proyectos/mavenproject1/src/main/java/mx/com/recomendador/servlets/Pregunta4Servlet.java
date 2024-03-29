package mx.com.recomendador.servlets;

import java.io.IOException;
import java.sql.SQLException;
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
import mx.com.recomendador.domain.Usuario;
import mx.com.recomendador.service.UsuarioService;

/**
 *
 * @author Angel Franco
 */

@WebServlet("/Pregunta4")
public class Pregunta4Servlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  obtenemos la respuesta
        String respuesta = request.getParameter("enfoque");
        
        //  obtenemos las opciones a filtrar
        ServletContext application = getServletContext();
        Set<RedSocial> redes = (Set<RedSocial>) application.getAttribute("resultados2");

        Set<RedSocial> resultados = redes.stream().filter(red -> red.getEnfoque().contains(respuesta)).collect(Collectors.toSet());
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
            Set<String> funcionalidades = new HashSet<>();
            resultados.forEach(instancia -> funcionalidades.add(instancia.getFuncionalidades()));
            
            application.setAttribute("resultadosFunciones", resultados);
            request.setAttribute("funcionalidades", funcionalidades);
            RequestDispatcher dispatcher = request.getRequestDispatcher("pregunta4.jsp");
            dispatcher.forward(request, response);
        }
    }
}

