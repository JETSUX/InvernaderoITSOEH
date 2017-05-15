/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import dao.HibernatePlantaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "ModificarPlantas11", urlPatterns = {"/ModificarPlantas11"})
public class ModificarPlantas11 extends HttpServlet {

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
SimpleDateFormat formato = new SimpleDateFormat("yyy-MM-dd");
        Date fechaDate = new Date();

        int id =Integer.parseInt(request.getParameter("id")) ;
        String fecha = request.getParameter("fecha");
        String nombre = request.getParameter("nom_planta");
        String descripcion = request.getParameter("descripcion");
        String imagen = request.getParameter("foto");

        byte[] img = imagen.getBytes();
        try {
            fechaDate = formato.parse(fecha);
        } catch (ParseException e) {
            System.out.println(e);
        }

        try (PrintWriter out = response.getWriter()) {
            Planta objPlanta = new Planta();
            HibernatePlantaDAO plantaDAO = new HibernatePlantaDAO();

            objPlanta.setIdPlanta(id);
            objPlanta.setNomPlanta(nombre);
            objPlanta.setImagenPlanta(img);
            objPlanta.setFechaCultivo(fechaDate);
            objPlanta.setDescripcionPlanta(descripcion);

            plantaDAO.update(objPlanta);
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ModificarPlanta</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Datos Modificados Correctamente a la Tabla Planta</h1>");
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
