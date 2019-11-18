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
    public static Connection initializeDatabase() throws SQLException, ClassNotFoundException{
        String dbDriver = "com.mysql.jdbc.Driver"; 
        String dbURL = "jdbc:mysql://localhost:3306/"; 
        
        String dbName = "suster_adm"; 
        String dbUsername = "root"; 
        String dbPassword = ""; 
        
        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL+dbName,dbUsername,dbPassword);
        return con;
    }
    
//    public static List<biodata_suster> getAllData(){  
//        List<biodata_suster> list=new ArrayList<biodata_suster>();  
//          
//        try{  
//            Connection con=koneksi_db.initializeDatabase();  
//            PreparedStatement ps=con.prepareStatement("SELECT id_suster, nama_suster, nama_asal_suster FROM biodata_suster");  
//            ResultSet rs=ps.executeQuery();  
//            while(rs.next()){  
//                biodata_suster e=new biodata_suster();  
//                e.setId_Suster(rs.getInt(1));  
//                e.setNama_suster(rs.getString(2));  
//                e.setNama_asal_suster(rs.getString(3));
//                list.add(e);  
//            }  
//            con.close();  
//        }catch(Exception e){e.printStackTrace();}  
//          
//        return list;  
//    }
    
    public static int delete(String id){  
        int status=0;  
        try{  
            Connection con=koneksi_db.initializeDatabase();  
            PreparedStatement ps=con.prepareStatement("DELETE FROM biodata_suster where id_suster=?");  
            ps.setString(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
}
