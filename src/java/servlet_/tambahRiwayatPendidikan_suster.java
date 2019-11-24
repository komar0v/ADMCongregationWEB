/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "tambahRiwayatPendidikan_suster", urlPatterns = {"/tambahRiwayatPendidikan_suster"})
public class tambahRiwayatPendidikan_suster extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idSuster = request.getParameter("idSuster");
        String[] jenjang = request.getParameterValues("riwayatPendidikan1[]");
        String[] instansi = request.getParameterValues("riwayatPendidikan2[]");
        String[] tahun = request.getParameterValues("riwayatPendidikan3[]");
        
        String pendidikannya_suster="";

        for (int i = 0; i < jenjang.length; i++) {
            pendidikannya_suster = pendidikannya_suster + jenjang[i] + " " + instansi[i] + " " + tahun[i]+ " , ";
        }
        System.out.println(pendidikannya_suster);

        response.sendRedirect("./editSusterView_?id_suster=" + idSuster);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
