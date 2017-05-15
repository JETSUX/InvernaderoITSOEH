/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import dao.HibernateHerbicidaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Herbicida;

/**
 *
 * @author 51737
 */
@WebServlet(name = "EliminarHerbicidas", urlPatterns = {"/EliminarHerbicidas"})
public class EliminarHerbicidas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             
            HibernateHerbicidaDAO hibernateHerbicidaDAO= new HibernateHerbicidaDAO();
            hibernateHerbicidaDAO.SelectAll();
            List<Herbicida> herbicida= hibernateHerbicidaDAO.SelectAll();
            
            /* TODO output your page here. You may use following sample code. */            
          /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Consultar Herbicida</title>");            
            out.println("</head>");
            out.println("<body>");
                               
            out.println("<h1>Consulta Herbicida</h1>");
            System.out.println("Herbicida");
            
            out.println("<form class='form-horizontal' method='post' action='EliminarHerbicidas1'>");

            out.println("<div class='form-group'>");
            out.println("<label for='inputName' class='control-label col-xs-2'>Id:</label>");
            out.println("<div class='col-xs-6'>");
            out.println("<input type='text' name='id' class='form-control' placeholder='id_Herbicida'/>");
            out.println("</div>");
            out.println("</div>");

            out.println("<div class='form-group'>");
            out.println("<div class='col-xs-offset-2 col-xs-10'>");
            out.println("<button type='submit' class='btn btn-primary'>Eliminar</button>");

            out.println("</div>");
            out.println("</div>");

            out.println("</form>");

            
            out.println("<table border='1px'>");
            out.println("<tr>");
            out.println("<td>Id_Herbicida</td>");
            out.println("<td>Nombre_Herbicida</td>");            
            out.println("<td>Cantidad</td>");
            out.println("<td>Presentacion</td>");                        
            out.println("</tr>");
        for (Herbicida herbicidas : herbicida){
     
            
            
            out.println("<tr>");
            out.println("<td>"+ herbicidas.getIdHerbicida()+"</td>");
            out.println("<td>"+ herbicidas.getNomHerbicida()+"</td>");
            out.println("<td>"+ herbicidas.getCantHerbicida()+"</td>");
            out.println("<td>"+ herbicidas.getPresentacionHer()+"</td>");                       
            out.println("</tr>");

        
        }
        out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
