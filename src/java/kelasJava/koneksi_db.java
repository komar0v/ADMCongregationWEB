/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelasJava;

import java.sql.*;

/**
 *
 * @author ASUS
 */
public class koneksi_db {

    public static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/";

        String dbName = "suster_adm";
        String dbUsername = "root";
        String dbPassword = "";

        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
        return con;
    }

    public static int delete(String id) {
        int status = 0;
        try {
            Connection con = koneksi_db.initializeDatabase();
            PreparedStatement ps = con.prepareStatement("DELETE FROM biodata_suster WHERE id_suster=?");
            PreparedStatement ps2 = con.prepareStatement("DELETE FROM minatbakat_suster WHERE id_suster=?");
            PreparedStatement ps3 = con.prepareStatement("DELETE FROM pendidikan_suster WHERE id_suster=?");
            PreparedStatement ps4 = con.prepareStatement("DELETE FROM databiara_suster WHERE id_suster=?");
            PreparedStatement ps5 = con.prepareStatement("DELETE FROM seminar_suster WHERE id_suster=?");
            PreparedStatement ps6 = con.prepareStatement("DELETE FROM catatanpribadi_novis_satu_notes WHERE id_suster=?");
            PreparedStatement ps7 = con.prepareStatement("DELETE FROM catatanpribadi_novis_dua_notes WHERE id_suster=?");
            PreparedStatement ps8 = con.prepareStatement("DELETE FROM catatanpribadi_yunior_satu_notes WHERE id_suster=?");
            PreparedStatement ps9 = con.prepareStatement("DELETE FROM catatanpribadi_yunior_dua_notes WHERE id_suster=?");
            PreparedStatement ps10 = con.prepareStatement("DELETE FROM catatanpribadi_yunior_dua_notes WHERE id_suster=?");
            
            ps.setString(1, id);
            ps2.setString(1, id);
            ps3.setString(1, id);
            ps4.setString(1, id);
            ps5.setString(1, id);
            ps6.setString(1, id);
            ps7.setString(1, id);
            ps8.setString(1, id);
            ps9.setString(1, id);
            ps10.setString(1, id);
            
            ps2.executeUpdate();
            ps3.executeUpdate();
            ps4.executeUpdate();
            ps5.executeUpdate();
            ps6.executeUpdate();
            ps7.executeUpdate();
            ps8.executeUpdate();
            ps9.executeUpdate();
            ps10.executeUpdate();
            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static void updateMinatbakat(String dataMinatBakat, String idSuster) {
        try{
            Connection con2 = koneksi_db.initializeDatabase();
            PreparedStatement prpStmt2 = con2.prepareStatement("UPDATE minatbakat_suster SET minatbakat=? WHERE id_suster=?");
            prpStmt2.setString(1, dataMinatBakat);
            prpStmt2.setString(2, idSuster);

            prpStmt2.executeUpdate();
            con2.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void updateRiwayatPendidikan(String dataPendidikan, String idSuster) {
        try{
            Connection con3 = koneksi_db.initializeDatabase();
            PreparedStatement prpStmt3 = con3.prepareStatement("UPDATE pendidikan_suster SET pendidikan=? WHERE id_suster=?");
            prpStmt3.setString(1, dataPendidikan);
            prpStmt3.setString(2, idSuster);

            prpStmt3.executeUpdate();
            con3.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void updateSeminarYgPernahIkut(String dataSeminar, String dataSeminar2, String idSuster) {
        try{
            Connection con3 = koneksi_db.initializeDatabase();
            PreparedStatement prpStmt3 = con3.prepareStatement("UPDATE seminar_suster SET seminar=?, sertifikat=? WHERE id_suster=?");
            prpStmt3.setString(1, dataSeminar);
            prpStmt3.setString(2, dataSeminar2);
            prpStmt3.setString(3, idSuster);

            prpStmt3.executeUpdate();
            con3.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
