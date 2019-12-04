/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv_catatanPribadi_novis_dua;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kelasJava.catatan_suster;
import kelasJava.koneksi_db;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "catPribadi_novis_dua_postulan_dua_save", urlPatterns = {"/catPribadi_novis_dua_postulan_dua_save"})
public class catPribadi_novis_dua_postulan_dua_save extends HttpServlet {


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
        PrintWriter out = response.getWriter();
        catatan_suster catatan = new catatan_suster();
        String idSust = request.getParameter("idSuster");
        catatan.setId_suster(idSust);
        String catatanTextArea = request.getParameter("catanPribadi");
        catatan.setCatatans(catatanTextArea);
        
        try{
            Connection con = koneksi_db.initializeDatabase();
            PreparedStatement ps = con.prepareStatement("UPDATE catatanpribadi_novis_dua_notes SET postulan2=? WHERE id_suster=?");
            ps.setString(1, catatan.getCatatans());
            ps.setString(2, catatan.getId_suster());
            
            ps.executeUpdate();
            ps.close();
            con.close();
            
            try {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Data catatan berhasil diedit!');");
                out.println("location='./catPribadi_novis_dua_postulan_dua?id_suster="+catatan.getId_suster()+"';");
                out.println("</script>");

            } finally {
                out.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
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
