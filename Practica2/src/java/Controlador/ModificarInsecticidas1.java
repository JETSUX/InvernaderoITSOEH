/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import dao.HibernateInsecticidaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Insecticida;

/**
 *
 * @author 51737
 */
@WebServlet(name = "ModificarInsecticidas1", urlPatterns = {"/ModificarInsecticidas1"})
public class ModificarInsecticidas1 extends HttpServlet {

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
       
        int id = Integer.parseInt(request.getParameter("id"));
        
        try (PrintWriter out = response.getWriter()) {
            
            Insecticida objInsecticida = new Insecticida();
            HibernateInsecticidaDAO insecticidaDAO = new HibernateInsecticidaDAO();

            objInsecticida.setIdInsecticida(id);            
            //   plantaDAO.selectById(id);                        
            Insecticida insecticida = insecticidaDAO.selectById(id);
            
            /* TODO output your page here. You may use following sample code. */            
          /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Modificar Insecticida</title>");            
            out.println("</head>");
            out.println("<body>");
                               
            out.println("<h1>Modificar Insecticida</h1>");
            System.out.println("Insecticida");
            
             out.println("<form class='form-horizontal' method='post' action='ModificarInsecticidas11'>");

            out.println("     <div class='form-group'>");
            out.println("<label for='inputName' class='control-label col-xs-2'>Id_Insecticida:</label>");
            out.println("<div class='col-xs-6'>");
            out.println("<input type='text' name='id' class='form-control' value='"+insecticida.getIdInsecticida() +"' />");
            out.println("</div>");
            out.println("</div>");
            
            out.println("     <div class='form-group'>");
            out.println("<label for='inputName' class='control-label col-xs-2'>Nombre:</label>");
            out.println("<div class='col-xs-6'>");
            out.println("<input type='text' name='nombre' class='form-control' value='"+insecticida.getNomInsecticida() +"' />");
            out.println("</div>");
            out.println("</div>");

            out.println("<div class='form-group'>");
            out.println("<label for='inputName' class='control-label col-xs-2'>Cantidad:</label>");
            out.println("<div class='col-xs-6'>");
            out.println("<input name='cantidad' type='text'  value='"+insecticida.getCantInsecticida()+"'/>");
            out.println("</div>");
            out.println("</div>");

            out.println("<div class='form-group'>");
            out.println("<label for='inputName' class='control-label col-xs-2'>Presentacion:</label>");
            out.println("<div class='col-xs-6'>");
            out.println("<input type='text' name='presentacion' class='form-control' value='"+insecticida.getPresentacionInsec()+"' />");
            out.println("</div>");
            out.println("</div>");
          
            out.println("<div class='form-group'>");
            out.println("<div class='col-xs-offset-2 col-xs-10'>");
            out.println("<button type='submit class='btn btn-primary'>Modificar</button>");
            out.println("</div>");
            out.println("</div>");
            out.println("</form>");
            
           
        
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
