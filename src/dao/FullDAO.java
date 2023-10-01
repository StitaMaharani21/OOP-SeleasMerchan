/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import model.Full;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

        
/**
 *
 * @author HP
 */
public class FullDAO {
    public static Connection CON;
    public static final String url = "jdbc:ucanaccess://";
    public static final String path = "C:\\Users\\HP\\Documents\\NetBeansProjects\\TubesOOP\\DatabaseBarang - Copy.mdb";
    
    public void makeConnection(){
        System.out.println("Opening database ... ");
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            CON = DriverManager.getConnection(url+path);
            System.out.println("Success");
        }catch(Exception e){
            System.out.println("Error opening database");
            System.out.println(e);
        }
    }
    
    public void closeConnection(){
        System.out.println("Closing database ... ");
        try{
            CON.close();
            System.out.println("Success");
        }catch(Exception e){
            System.out.println("Error opening database");
            System.out.println(e);
        }
    }
    
    public void insert(Full f) {
        String sql = "insert into Full(noProduk, namaProduk, hargaSatuan, jumlahProduk, totalHarga) values ('"
                +f.getnoProduk()+"','"
                +f.getnamaProduk()+"','"
                +f.gethargaSatuan()+"','"
                +f.getjumlahProduk()+"','"
                +f.gettotal()+"')";
        
        System.out.println("Adding Data...");
        
        try{
            Statement statement = CON.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added" +result +"Full Payment \n");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding full payment...");
            System.out.println(e);
        }
    }
    
    public List<Full> showFull() {
        String sql = "select * from Full";
        System.out.println("Mengambil data...");
        
        List<Full> list = new ArrayList<>();
        
        try{
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null) {
                while(rs.next()) {
                    Full f = new Full(rs.getString("noProduk")
                            ,rs.getString("namaProduk")
                            ,Integer.parseInt(rs.getString("hargaSatuan"))
                            ,Integer.parseInt(rs.getString("jumlahProduk"))
                            ,Integer.parseInt(rs.getString("totalHarga")));
                    list.add(f);
                }
            }
            rs.close();
            statement.close();
        } catch(Exception e) {
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        return list;
    }
    
    public Full searchFull(String noProduk) {
        String sql = "select * from Full where noProduk = '" +noProduk +"'";
        System.out.println("Searching data...");
        
        Full f = null;
        
        try{
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null) {
                while(rs.next()) {
                    f = new Full(rs.getString("noProduk")
                            ,rs.getString("namaProduk")
                            ,Integer.parseInt(rs.getString("hargaSatuan"))
                            ,Integer.parseInt(rs.getString("jumlahProduk"))
                            ,Integer.parseInt(rs.getString("totalHarga")));
                }
            }
            rs.close();
            statement.close();
        } catch(Exception e) {
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        
        return f;
    }
    
   
    public void deleteFull(String noProduk) {
        String sql = "delete from Full where noProduk = '" +noProduk +"'";
        System.out.println("Deleting data...");
        
        try{
            Statement s = CON.createStatement();
            int result = s.executeUpdate(sql);
            System.out.println("Delete" +result +"Data \n");
            s.close();
        } catch(Exception e) {
            System.out.println("Error deleting data...");
            System.out.println(e);
        }
    }
    
}
