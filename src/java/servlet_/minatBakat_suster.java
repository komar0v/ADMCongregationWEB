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
@WebServlet(name = "minatBakat_suster", urlPatterns = {"/minatBakat_suster"})
public class minatBakat_suster extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            biodata_suster datanya = new biodata_suster();

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = koneksi_db.initializeDatabase();

            PreparedStatement ps = conn.prepareStatement("SELECT * from biodata_suster WHERE id_suster=?");
            PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM minatbakat_suster WHERE id_suster=?");

            String idnyaSuster = request.getParameter("id_suster");
            ps.setString(1, idnyaSuster);
            ps2.setString(1, idnyaSuster);

            ResultSet rs = ps.executeQuery();
            ResultSet rs2 = ps2.executeQuery();
            if (rs.next()) {
                datanya.setId_Suster(rs.getString("id_suster"));

            }
            String minatBakat = "";
            if (rs2.next()) {
                minatBakat = rs2.getString("minatbakat");
            }
            String arrMinatBakat[] = minatBakat.split(",");

            try {
                out.println("<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "    <head>\n"
                        + "        <title>Edit Data</title>\n"
                        + "        <meta charset=\"utf-8\">\n"
                        + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                        + "        <link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n"
                        + "        <script src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\n"
                        + "        <script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n"
                        + "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n"
                        + "        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n"
                        + "        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n"
                        + "\n"
                        + "    </head>\n"
                        + "\n"
                        + "    <body>\n"
                        + "        <div class=\"container bootstrap snippet\">\n"
                        + "            <div class=\"row\">\n"
                        + "                <div class=\"col-sm-10\"><h1>Edit Data Suster</h1></div>\n"
                        + "\n"
                        + "            </div>\n"
                        + "            <div class=\"row\">\n"
                        + "                <div class=\"col-sm-3\"><!--left col-->\n"
                        + "\n"
                        + "\n"
                        + "                    <div class=\"text-center\">\n"
                        + "                        <img src=\"getImagefromDB?id_suster=" + datanya.getId_Suster() + "\"  height=\"200\" width=\"200\" >\n"
                        + "\n"
                        + "                    </div><br>\n"
                        + "\n"
                        + "\n"
                        + "\n"
                        + "\n"
                        + "                </div><!--/col-3-->\n"
                        + "                <div class=\"col-sm-9\">\n"
                        + "                    <ul class=\"nav nav-tabs\">\n"
                        + "                        <li ><a href=\"./editSusterView_?id_suster=" + datanya.getId_Suster() + "\">Informasi Dasar</a></li>\n"
                        + "			   <li class=\"active\"><a href=\"#\">Minat Bakat</a></li>"
                        + "                        <li><a href=\"./riwayatPendidikan_suster?id_suster=" + datanya.getId_Suster() + "\">Riwayat Pendidikan</a></li>\n"
                        + "                    </ul>\n"
                        + "\n"
                        + "\n"
                        + "                    <div class=\"tab-content\">\n"
                        + "                        <div class=\"tab-pane active\" id=\"home\">\n"
                        + "                            <hr>\n"
                        + "                                    \n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                   <h4>NIK Suster</h4>\n"
                        + "										<input type=\"text\"  class=\"form-control\" name=\"idSuster\" readonly value=\"" + datanya.getId_Suster() + "\">\n"
                        + "                                </div>\n"
                        + "								\n"
                        + "								<div class=\"field_wrapper\">\n"
                        + "                       <hr><h4>Minat & Bakat</h4> <div id=\"minat_bakat\">\n");
                for (int i = 1; i < arrMinatBakat.length; i++) {
                    out.println("<br><li>" + arrMinatBakat[i] + "</li><br>");
                }

                out.println("                     </div>\n"
                        + "                    </div>\n"
                        + "\n"
                        + "                                \n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <div class=\"col-xs-12\">\n"
                        + "                                        <br>\n"
                        + "<a href=\"./formAddMinatBakat_suster2?id_suster=" + datanya.getId_Suster() + "\">TAMBAH DATA</a>                                        "
                        + "<button class=\"button icon solid\" formaction=\"./#\" type=\"reset\"><i class=\"glyphicon glyphicon-edit\"></i> EDIT MINAT BAKAT</button>\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "                            <hr>\n"
                        + "                        </div><!--/tab-pane-->\n"
                        + "                    </div><!--/tab-content-->\n"
                        + "\n"
                        + "                </div><!--/col-9-->\n"
                        + "            </div><!--/row-->\n"
                        + "        </div>\n"
                        + "        <script>\n"
                        + "            $(\".custom-file-input\").on(\"change\", function () {\n"
                        + "                var fileName = $(this).val().split(\"\\\\\").pop();\n"
                        + "                $(this).siblings(\".custom-file-label\").addClass(\"selected\").html(fileName);\n"
                        + "            });\n"
                        + "        </script>\n"
                        + "		<script type=\"text/javascript\">\n"
                        + "                $(document).ready(function () {\n"
                        + "                    var maxField = 10; //Input fields increment limitation\n"
                        + "                    var addButton = $('.add_button'); //Add button selector\n"
                        + "                    var wrapper = $('.field_wrapper'); //Input field wrapper <img src=\"https://img.icons8.com/flat_round/64/000000/minus.png\">\n"
                        + "                    var fieldHTML = '<div><input type=\"text\" name=\"minatbakat[]\" value=\"\" size=\"30\"/><a href=\"javascript:void(0);\" class=\"remove_button\"><img src=\"https://img.icons8.com/pastel-glyph/64/000000/minus.png\" width=\"25\" height=\"25\"></a></div>'; //New input field html \n"
                        + "                    var x = 1; //Initial field counter is 1\n"
                        + "\n"
                        + "                    //Once add button is clicked\n"
                        + "                    $(addButton).click(function () {\n"
                        + "                        //Check maximum number of input fields\n"
                        + "                        if (x < maxField) {\n"
                        + "                            x++; //Increment field counter\n"
                        + "                            $(wrapper).append(fieldHTML); //Add field html\n"
                        + "                        }\n"
                        + "                    });\n"
                        + "\n"
                        + "                    //Once remove button is clicked\n"
                        + "                    $(wrapper).on('click', '.remove_button', function (e) {\n"
                        + "                        e.preventDefault();\n"
                        + "                        $(this).parent('div').remove(); //Remove field html\n"
                        + "                        x--; //Decrement field counter\n"
                        + "                    });\n"
                        + "                });\n"
                        + "            </script>\n"
                        + "    </body>\n"
                        + "\n"
                        + "</html>\n"
                        + "");
            } finally {
                out.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(minatBakat_suster.class.getName()).log(Level.SEVERE, null, ex);
        }

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
