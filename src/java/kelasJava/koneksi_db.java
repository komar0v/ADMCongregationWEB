/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelasJava;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            ps.setString(1, id);
            ps2.setString(1, id);
            ps2.executeUpdate();
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
}
