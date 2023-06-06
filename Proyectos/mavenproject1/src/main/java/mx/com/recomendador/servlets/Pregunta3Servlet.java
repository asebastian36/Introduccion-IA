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
import mx.com.recomendador.domain.Usuario;

/**
 *
 * @author Angel Franco
 */

@WebServlet("/Pregunta3")
public class Pregunta3Servlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String respuesta = request.getParameter("tematica");
        
        //  pregunta 3
        List<RedSocial> redes = new ArrayList<>();
        RedSocialDAO consulta = new RedSocialDAO();
        redes = consulta.seleccionar();
        
        Set<RedSocial> filtro2 = redes.stream().filter(red -> red.getTematica().contains(respuesta)).collect(Collectors.toSet());
        if(filtro2.size() == 1) {
            RedSocial red = filtro2.stream().collect(Collectors.toList()).get(0);
            int idUsuario = 0;
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(idUsuario);
            usuario.setRecomendacion(red.getIdRedSocial());
            
            //  mandar infor de la red
            request.setAttribute("redSocial", red);
            
            //  mandar infor del usuario
            request.setAttribute("usuario", usuario);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("resultado.jsp");
            dispatcher.forward(request, response);
        } else {
            Set<String> enfoques = new HashSet<>();
            filtro2.forEach(instancia -> enfoques.add(instancia.getEnfoque()));
            
            request.setAttribute("enfoques", enfoques);

            RequestDispatcher dispatcher = request.getRequestDispatcher("pregunta3.jsp");
            dispatcher.forward(request, response);
        }
    }
}
