/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import dao.HibernatePlantaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Planta;

/**
 *
 * @author 51737
 */
@WebServlet(name = "EliminarPlantas", urlPatterns = {"/EliminarPlantas"})
public class EliminarPlantas extends HttpServlet {

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
            
            HibernatePlantaDAO hibernatePlantaDAO= new HibernatePlantaDAO();
            hibernatePlantaDAO.SelectAll();
            List<Planta> planta= hibernatePlantaDAO.SelectAll();
            
            /* TODO output your page here. You may use following sample code. */            
          /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Eliminar Planta</title>");            
            out.println("</head>");
            out.println("<body>");
                               
            out.println("<h1>Eliminar Planta</h1>");
            System.out.println("Planta");
            
            out.println("<form class='form-horizontal' method='post' action='EliminarPlantas1'>");

            out.println("<div class='form-group'>");
            out.println("<label for='inputName' class='control-label col-xs-2'>Id:</label>");
            out.println("<div class='col-xs-6'>");
            out.println("<input type='text' name='id' class='form-control' placeholder='id_Planta'/>");
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
            out.println("<td>Id_Planta</td>");
            out.println("<td>Nombre_Planta</td>");            
            out.println("<td>Descripcion</td>");
            out.println("<td>Imagen</td>");                        
            out.println("<td>Fecha cultivo</td>");                        
            out.println("</tr>");
        for (Planta plantas : planta){
     
            
            
            out.println("<tr>");
            out.println("<td>"+ plantas.getIdPlanta()+"</td>");
            out.println("<td>"+ plantas.getNomPlanta()+"</td>");
            out.println("<td>"+ plantas.getDescripcionPlanta()+"</td>");
            out.println("<td>"+ plantas.getImagenPlanta()+"</td>");                       
            out.println("<td>"+ plantas.getFechaCultivo()+"</td>");                       
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
