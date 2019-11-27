/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "showSuster_", urlPatterns = {"/showSuster_"})
public class showSuster_ extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        PrintWriter output = response.getWriter();

        try {
            Connection con = koneksi_db.initializeDatabase();
            Statement stmt = con.createStatement();
            ResultSet resultset = stmt.executeQuery("SELECT id_suster, nama_suster, nama_asal_suster FROM biodata_suster");

            output.println("<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n"
                    + "<head>\n"
                    + "<meta charset=\"utf-8\">\n"
                    + "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                    + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                    + "<title>VIEW DATA SUSTER</title>\n"
                    + "<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Roboto|Varela+Round\">\n"
                    + "<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\">\n"
                    + "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n"
                    + "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n"
                    + "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n"
                    + "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n"
                    + "<style type=\"text/css\">\n"
                    + "    body {\n"
                    + "        color: #566787;\n"
                    + "        background: #f5f5f5;\n"
                    + "		font-family: 'Roboto', sans-serif;\n"
                    + "	}\n"
                    + "	.table-wrapper {\n"
                    + "        background: #fff;\n"
                    + "        padding: 20px;\n"
                    + "        margin: 30px 0;\n"
                    + "        box-shadow: 0 1px 1px rgba(0,0,0,.05);\n"
                    + "    }\n"
                    + "	.table-title {\n"
                    + "		font-size: 15px;\n"
                    + "        padding-bottom: 10px;\n"
                    + "        margin: 0 0 10px;\n"
                    + "		min-height: 45px;\n"
                    + "    }\n"
                    + "    .table-title h2 {\n"
                    + "        margin: 5px 0 0;\n"
                    + "        font-size: 24px;\n"
                    + "    }\n"
                    + "	.table-title select {\n"
                    + "		border-color: #ddd;\n"
                    + "		border-width: 0 0 1px 0;\n"
                    + "		padding: 3px 10px 3px 5px;\n"
                    + "		margin: 0 5px;\n"
                    + "	}\n"
                    + "	.table-title .show-entries {\n"
                    + "		margin-top: 7px;\n"
                    + "	}\n"
                    + "	.search-box {\n"
                    + "        position: relative;\n"
                    + "        float: right;\n"
                    + "    }\n"
                    + "	.search-box .input-group {\n"
                    + "		min-width: 200px;\n"
                    + "		position: absolute;\n"
                    + "		right: 0;\n"
                    + "	}\n"
                    + "	.search-box .input-group-addon, .search-box input {\n"
                    + "		border-color: #ddd;\n"
                    + "		border-radius: 0;\n"
                    + "	}\n"
                    + "	.search-box .input-group-addon {\n"
                    + "		border: none;\n"
                    + "		border: none;\n"
                    + "		background: transparent;\n"
                    + "		position: absolute;\n"
                    + "		z-index: 9;\n"
                    + "	}\n"
                    + "    .search-box input {\n"
                    + "        height: 34px;\n"
                    + "        padding-left: 28px;		\n"
                    + "		box-shadow: none !important;\n"
                    + "		border-width: 0 0 1px 0;\n"
                    + "    }\n"
                    + "	.search-box input:focus {\n"
                    + "		border-color: #3FBAE4;\n"
                    + "	}\n"
                    + "    .search-box i {\n"
                    + "        color: #a0a5b1;\n"
                    + "        font-size: 19px;\n"
                    + "		position: relative;\n"
                    + "		top: 2px;\n"
                    + "		left: -10px;\n"
                    + "    }\n"
                    + "    table.table tr th, table.table tr td {\n"
                    + "        border-color: #e9e9e9;\n"
                    + "    }\n"
                    + "    table.table th i {\n"
                    + "        font-size: 13px;\n"
                    + "        margin: 0 5px;\n"
                    + "        cursor: pointer;\n"
                    + "    }\n"
                    + "    table.table td:last-child {\n"
                    + "        width: 130px;\n"
                    + "    }\n"
                    + "    table.table td a {\n"
                    + "        color: #a0a5b1;\n"
                    + "        display: inline-block;\n"
                    + "        margin: 0 5px;\n"
                    + "    }\n"
                    + "	table.table td a.view {\n"
                    + "        color: #03A9F4;\n"
                    + "    }\n"
                    + "    table.table td a.edit {\n"
                    + "        color: #FFC107;\n"
                    + "    }\n"
                    + "    table.table td a.delete {\n"
                    + "        color: #E34724;\n"
                    + "    }\n"
                    + "    table.table td i {\n"
                    + "        font-size: 19px;\n"
                    + "    }    \n"
                    + "    .pagination {\n"
                    + "        float: right;\n"
                    + "        margin: 0 0 5px;\n"
                    + "    }\n"
                    + "    .pagination li a {\n"
                    + "        border: none;\n"
                    + "        font-size: 13px;\n"
                    + "        min-width: 30px;\n"
                    + "        min-height: 30px;\n"
                    + "		padding: 0 10px;\n"
                    + "        color: #999;\n"
                    + "        margin: 0 2px;\n"
                    + "        line-height: 30px;\n"
                    + "        border-radius: 30px !important;\n"
                    + "        text-align: center;\n"
                    + "    }\n"
                    + "    .pagination li a:hover {\n"
                    + "        color: #666;\n"
                    + "    }	\n"
                    + "    .pagination li.active a {\n"
                    + "        background: #03A9F4;\n"
                    + "    }\n"
                    + "    .pagination li.active a:hover {        \n"
                    + "        background: #0397d6;\n"
                    + "    }\n"
                    + "	.pagination li.disabled i {\n"
                    + "        color: #ccc;\n"
                    + "    }\n"
                    + "    .pagination li i {\n"
                    + "        font-size: 16px;\n"
                    + "        padding-top: 6px\n"
                    + "    }\n"
                    + "    .hint-text {\n"
                    + "        float: left;\n"
                    + "        margin-top: 10px;\n"
                    + "        font-size: 13px;\n"
                    + "    }\n"
                    + "</style>\n"
                    + "<script type=\"text/javascript\">\n"
                    + "$(document).ready(function(){\n"
                    + "	// Activate tooltips\n"
                    + "	$('[data-toggle=\"tooltip\"]').tooltip();\n"
                    + "    \n"
                    + "	// Filter table rows based on searched term\n"
                    + "    $(\"#search\").on(\"keyup\", function() {\n"
                    + "        var term = $(this).val().toLowerCase();\n"
                    + "        $(\"table tbody tr\").each(function(){\n"
                    + "            $row = $(this);\n"
                    + "            var name = $row.find(\"td:nth-child(3)\").text().toLowerCase();\n"
                    + "            console.log(name);\n"
                    + "            if(name.search(term) < 0){                \n"
                    + "                $row.hide();\n"
                    + "            } else{\n"
                    + "                $row.show();\n"
                    + "            }\n"
                    + "        });\n"
                    + "    });\n"
                    + "});\n"
                    + "</script>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "    <div class=\"container\">\n"
                    + "        <div class=\"table-wrapper\">			\n"
                    + "            <div class=\"table-title\">\n"
                    + "                <div class=\"row\">\n"
                    + "                    <div class=\"col-sm-4\">\n"
                    + "						<div class=\"col-sm-6\">"
                    + "							<a href=\"./formAdd_suster\" class=\"btn btn-success\" data-toggle=\"modal\"><i class=\"material-icons\">&#xE147;</i> <span>Tambah Data Suster</span></a>"
                    + "						</div>						\n"
                    + "					</div>\n"
                    + "					<div class=\"col-sm-4\">\n"
                    + "						<h2 class=\"text-center\">DATABASE <b>SUSTER ADM</b></h2>\n"
                    + "					</div>\n"
                    + "                    <div class=\"col-sm-4\">\n"
                    + "                        <div class=\"search-box\">\n"
                    + "							<div class=\"input-group\">\n"
                    + "								<span class=\"input-group-addon\"><i class=\"material-icons\">&#xE8B6;</i></span>\n"
                    + "								<input type=\"text\" id=\"search\" class=\"form-control\" placeholder=\"Cari berdasar nama&hellip;\">\n"
                    + "							</div>\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "            </div>");
            output.println("<table class=\"table table-bordered\">");
            output.println("<thead><tr><th>#</th>\n"
                    + "                        <th>NIK SUSTER </th>\n"
                    + "                        <th>NAMA SUSTER</th>\n"
                    + "                        <th>NAMA ASAL SUSTER</th>\n"
                    + "                        <th>OPSI</th>\n"
                    + "                    </tr>\n"
                    + "                </thead>");
            output.println("<tbody>");
            int urutan = 0;
            List<biodata_suster> list=new ArrayList<biodata_suster>();  
            while (resultset.next()) {
                urutan = urutan + 1;
                String id_Suster = resultset.getString("id_suster");
                String nama_suster = resultset.getString("nama_suster");
                String nama_asal_suster = resultset.getString("nama_asal_suster");
                
                biodata_suster data = new biodata_suster();
                data.setId_Suster(id_Suster);
                data.setNama_suster(nama_suster);
                list.add(data); 
                
                output.println("<tr>" + "<td>" + urutan + "</td>" + "<td>" + data.getId_Suster() + "</td><td>" + nama_asal_suster + "</td><td>" + nama_suster + "</td>"
                        + "<td>\n"
                        + "							<a href=\"detailViewSuster_?id_suster="+data.getId_Suster()+"\" class=\"view\" title=\"View\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE417;</i></a>\n"
                        + "                            <a href=\"#\" class=\"edit\" title=\"Edit\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE254;</i></a>\n"
                        + "                            <a href=\"hapusSuster_?id_suster="+data.getId_Suster()+"\" class=\"delete\" title=\"Delete\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE872;</i></a>\n"
                        + "                        </td></tr>");
                
            }
            output.println("</tbody>");
            output.println("</table>");
            output.println("</html></body>");
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
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
