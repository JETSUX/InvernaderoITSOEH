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
@WebServlet(name = "ModificarInsecticidas11", urlPatterns = {"/ModificarInsecticidas11"})
public class ModificarInsecticidas11 extends HttpServlet {

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
       
        int id =Integer.parseInt(request.getParameter("id")) ;   
        String nombre = request.getParameter("nombre");
        int cantidad =Integer.parseInt(request.getParameter("cantidad"));
        String presentacion = request.getParameter("presentacion");
        
        try (PrintWriter out = response.getWriter()) {
            Insecticida objInsecticida = new Insecticida();
            HibernateInsecticidaDAO insecticidaDAO = new HibernateInsecticidaDAO();

            objInsecticida.setIdInsecticida(id);
            objInsecticida.setNomInsecticida(nombre);
            objInsecticida.setCantInsecticida(cantidad);
            objInsecticida.setPresentacionInsec(presentacion);            

            insecticidaDAO.update(objInsecticida);
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ModificarInsecticida</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Datos Modificados Correctamente a la Tabla Insecticida</h1>");
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
