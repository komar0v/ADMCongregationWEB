/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kelasJava.biodata_suster;
import kelasJava.koneksi_db;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "detailViewSuster_", urlPatterns = {"/detailViewSuster_"})
public class detailViewSuster_ extends HttpServlet {

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
        PrintWriter out = response.getWriter();

        try {
            biodata_suster datanya = new biodata_suster();
            Connection conn = koneksi_db.initializeDatabase();
            String motto="";

            PreparedStatement ps = conn.prepareStatement("SELECT * from biodata_suster WHERE id_suster=?");
            PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM minatbakat_suster WHERE id_suster=?");
            PreparedStatement ps3 = conn.prepareStatement("SELECT * FROM pendidikan_suster WHERE id_suster=?");
            PreparedStatement ps4 = conn.prepareStatement("SELECT * FROM seminar_suster WHERE id_suster=?");

            String id_suster = request.getParameter("id_suster");
            ps.setString(1, id_suster);
            ps2.setString(1, id_suster);
            ps3.setString(1, id_suster);
            ps4.setString(1, id_suster);

            ResultSet rs = ps.executeQuery();
            ResultSet rs2 = ps2.executeQuery();
            ResultSet rs3 = ps3.executeQuery();
            ResultSet rs4 = ps4.executeQuery();

            if (rs.next()) {
                datanya.setId_Suster(rs.getString("id_suster"));
                datanya.setNama_suster(rs.getString("nama_suster"));
                datanya.setNama_asal_suster(rs.getString("nama_asal_suster"));
                datanya.setNama_ayah_suster(rs.getString("nama_ayah_suster"));
                datanya.setNama_ibu_suster(rs.getString("nama_ibu_suster"));
                datanya.setJmlh_saudara(rs.getInt("jmlh_saudara"));
                datanya.setAnak_ke(rs.getInt("anak_ke"));
                datanya.setTempat_lahir_suster(rs.getString("tempat_lahir_suster"));
                datanya.setTanggal_lahir_suster(rs.getString("tanggal_lahir_suster"));
                motto=rs.getString("motto_suster");

            }

            String minat_bakat = "";
            if (rs2.next()) {
                minat_bakat = rs2.getString("minatbakat");
            }
            String arrMinatBakat[] = minat_bakat.split(",");

            String riwayat_pendidikan = "";
            if (rs3.next()) {
                riwayat_pendidikan = rs3.getString("pendidikan");
            }
            String arrRiwayatPendidikan[] = riwayat_pendidikan.split(",");

            String seminar_diikuti = "";
            String nama_sertif_seminar = "";
            if (rs4.next()) {
                seminar_diikuti = rs4.getString("seminar");
                nama_sertif_seminar = rs4.getString("sertifikat");
            }
            String arrSeminar[] = seminar_diikuti.split(",");
            String arrNamaSertif[] = nama_sertif_seminar.split(",");

            try {
                out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"
                        + "<head>\n"
                        + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n"
                        + "<title>Detail Suster</title>\n"
                        + "<link type=\"text/css\" rel=\"stylesheet\" href=\"css/blue.css\" />\n"
                        + "<link type=\"text/css\" rel=\"stylesheet\" href=\"css/print.css\" media=\"print\"/>\n"
                        + "<!--[if IE 7]>\n"
                        + "<link href=\"css/ie7.css\" rel=\"stylesheet\" type=\"text/css\" />\n"
                        + "<![endif]-->\n"
                        + "<!--[if IE 6]>\n"
                        + "<link href=\"css/ie6.css\" rel=\"stylesheet\" type=\"text/css\" />\n"
                        + "<![endif]-->\n"
                        + "<script type=\"text/javascript\" src=\"js/jquery-1.4.2.min.js\"></script>\n"
                        + "<script type=\"text/javascript\" src=\"js/jquery.tipsy.js\"></script>\n"
                        + "<script type=\"text/javascript\" src=\"js/cufon.yui.js\"></script>\n"
                        + "<script type=\"text/javascript\" src=\"js/scrollTo.js\"></script>\n"
                        + "<script type=\"text/javascript\" src=\"js/myriad.js\"></script>\n"
                        + "<script type=\"text/javascript\" src=\"js/jquery.colorbox.js\"></script>\n"
                        + "<script type=\"text/javascript\" src=\"js/custom.js\"></script>\n"
                        + "<script type=\"text/javascript\">\n"
                        + "		Cufon.replace('h1,h2');\n"
                        + "</script>"
                        + "<style>\n"
                        + ".topnav {\n"
                        + "  overflow: hidden;\n"
                        + "  background-color: #333;\n"
                        + "}\n"
                        + "\n"
                        + ".topnav a {\n"
                        + "  float: left;\n"
                        + "  color: #f2f2f2;\n"
                        + "  text-align: center;\n"
                        + "  padding: 10px 10px;\n"
                        + "  text-decoration: none;\n"
                        + "  font-size: 18px;\n"
                        + "}\n"
                        + "\n"
                        + ".topnav a:hover {\n"
                        + "  background-color: #ddd;\n"
                        + "  color: black;\n"
                        + "}\n"
                        + "\n"
                        + ".topnav a.active {\n"
                        + "  background-color: #4CAF50;\n"
                        + "  color: white;\n"
                        + "}\n"
                        + "</style>\n"
                        + "</head>\n"
                        + "<body>"
                        + "<div class=\"topnav\">\n"
                        + "  <a class=\"active\" href=\"./home_\">Home</a>\n"
                        + "</div>\n"
                        + "<!-- Begin Wrapper -->\n"
                        + "<div id=\"wrapper\">\n"
                        + "  <div class=\"wrapper-top\"></div>\n"
                        + "  <div class=\"wrapper-mid\">\n"
                        + "    <!-- Begin Paper -->\n"
                        + "    <div id=\"paper\">\n"
                        + "      <div class=\"paper-top\"></div>\n"
                        + "      <div id=\"paper-mid\">\n"
                        + "        <div class=\"entry\">\n"
                        + "          <!-- Begin Image -->\n"
                        + "          <img class=\"portrait\" src=\"getImagefromDB?id_suster=" + datanya.getId_Suster() + "\" />\n"
                        + "          <!-- End Image -->\n"
                        + "          <!-- Begin Personal Information -->\n"
                        + "          <div class=\"self\">\n"
                        + "            <h1 class=\"name\">" + datanya.getNama_suster() + "<br />\n"
                        + "              <span>" + datanya.getNama_asal_suster() + "</span></h1>\n"
                        + "            <ul>\n"
                        + "              <li style=\"font-size:16px\"> <img src=\"images/placeob.png\" style=\"width:20px;height:18px;\">   " + datanya.getTempat_lahir_suster() + "</li>\n"
                        + "              <li style=\"font-size:16px\"> <img src=\"images/dob.png\" style=\"width:20px;height:18px;\">   " + datanya.getTanggal_lahir_suster() + "</li>\n"
                        + "              <li style=\"font-size:16px\"> Nama Ayah : " + datanya.getNama_ayah_suster() + "</li>"
                        + "              <li style=\"font-size:16px\"> Nama Ibu : " + datanya.getNama_ibu_suster() + "</li>"
                        + "              </ul>\n"
                        + "          </div>\n"
                        + "          <!-- End Personal Information -->\n"
                        + "          <!-- Begin Social -->\n"
                        + "          <div class=\"social\">\n"
                        + "            <ul>\n"
                        + "              <li><a class='north' href=\"javascript:window.print()\" title=\"Print\"><img src=\"images/icn-print.jpg\"/></a></li>\n"
                        + "              <li><a class='north' href=\"editSusterView_?id_suster=" + datanya.getId_Suster() + "\" title=\"Edit\"> <img src=\"https://img.icons8.com/wired/25/000000/edit.png\"/></a></li>"
                        + "              </ul>\n"
                        + "          </div>\n"
                        + "          <!-- End Social -->\n"
                        + "        </div>\n"
                        + "        <!-- Begin 1st Row -->\n"
                        + "        <div class=\"entry\">\n"
                        + "          <h2>MOTTO HIDUP</h2>\n"
                        + "          <p>"+motto+"</p>\n"
                        + "        </div>\n"
                        + "        <!-- End 1st Row -->\n"
                        + "        <!-- Begin 2nd Row -->\n"
                        + "        <div class=\"entry\">\n"
                        + "          <h2>PENDIDIKAN</h2>\n"
                        + "          <div class=\"content\">\n"
                        + "            <h3>Riwayat Pendidikan</h3>\n"
                        + "              <ul class=\"info\">");
                for (int i = 0; i < arrRiwayatPendidikan.length; i++) {
                    out.println("<br><li>" + arrRiwayatPendidikan[i] + "</li><br>");
                }

                out.println("              </ul>"
                        + "          </div>\n"
                        + "        </div>\n"
                        + "        <!-- End 2nd Row -->\n"
                        + "        <!-- Begin 3rd Row -->\n"
                        + "        <div class=\"entry\">\n"
                        + "          <h2>Seminar</h2>\n"
                        + "          <div class=\"info\">\n");

                for (int i = 0; i < arrSeminar.length - 1; i++) {
                    
                    out.println("<p>"+arrSeminar[i]+"<br/>\n"
                            + "<em>"+arrNamaSertif[i]+"</em></p><br><br>");
                    out.println("<br>");
                }

                out.println("        </div>\n"
                        + "        </div>\n"
                        + "        <!-- End 3rd Row -->\n"
                        + "        <!-- Begin 4th Row -->\n"
                        + "        <div class=\"entry\">\n"
                        + "          <h2>MINAT & BAKAT</h2>\n"
                        + "          <div class=\"content\">\n"
                        + "            <h3>Keterampilan</h3>\n"
                        + "            <ul class=\"info\">\n");
                for (int i = 0; i < arrMinatBakat.length; i++) {
                    out.println("<br><li>" + arrMinatBakat[i] + "</li><br>");
                }
                out.println("          </ul>\n"
                        + "          </div>\n"
                        + "        </div>\n"
                        + "        <!-- End 4th Row -->\n"
                        + "      </div>\n"
                        + "      <div class=\"clear\"></div>\n"
                        + "      <div class=\"paper-bottom\"></div>\n"
                        + "    </div>\n"
                        + "    <!-- End Paper -->\n"
                        + "  </div>\n"
                        + "  <div class=\"wrapper-bottom\"></div>\n"
                        + "</div>\n"
                        + "<div id=\"message\"><a href=\"#top\" id=\"top-link\">Go to Top</a></div>\n"
                        + "<!-- End Wrapper -->\n"
                        + "</body>\n"
                        + "</html>");
            } finally {
                out.close();
            }

        } catch (Exception e) {
            Logger.getLogger(detailViewSuster_.class.getName()).log(Level.SEVERE, null, e);
        }

    }

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
